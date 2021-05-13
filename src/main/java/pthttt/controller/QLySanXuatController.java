package pthttt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import pthttt.entity.BangDinhMuc;
import pthttt.entity.CongDoanSX;
import pthttt.entity.NguyenVatLieu;
import pthttt.entity.NhanVien;
import pthttt.entity.SanPham;
import pthttt.service.BangDinhMucService;
import pthttt.service.CongDoanSXService;
import pthttt.service.NguyenVatLieuService;
import pthttt.service.NhanVienService;
import pthttt.service.SanPhamService;

@Controller
public class QLySanXuatController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private BangDinhMucService bangDinhMucService;

	@Autowired
	private CongDoanSXService congDoanSXService;

	@Autowired
	private NhanVienService nhanVienService;

	@Autowired
	private NguyenVatLieuService nguyenVatLieuService;

	@GetMapping("/listSanPham_SX")
	public String listSanPham(Model model) {
		List<SanPham> listsp = new ArrayList<SanPham>();
		listsp = sanPhamService.findAllSanPham();
		model.addAttribute("sps", listsp);
		return "quanLySanXuat_ListSanPham";
	}

	@GetMapping("/listBangDinhMuc/{ID}")
	public String listBangDinhMuc(Model model, @PathVariable int ID, @ModelAttribute SanPham sanPham) {
		sanPham = sanPhamService.findSanPhamByID(ID);
		List<BangDinhMuc> listbdm = new ArrayList<BangDinhMuc>();
		listbdm = bangDinhMucService.findAllBySanPham(sanPham);
		model.addAttribute("bdms", listbdm);
		return "quanLySanXuat_ListBangDinhMuc";
	}

	@GetMapping("/listCongDoanSanXuat/{ID}")
	public String listCongDoanSanXuat(Model model, @PathVariable int ID, @ModelAttribute SanPham sanPham) {
		sanPham = sanPhamService.findSanPhamByID(ID);
		List<CongDoanSX> liscdsx = new ArrayList<CongDoanSX>();
		liscdsx = congDoanSXService.findAllBySanPham(sanPham);
		model.addAttribute("cdsxs", liscdsx);
		return "quanLySanXuat_ListCongDoanSanXuat";
	}

	@GetMapping("/addCongDoanSanXuat/{ID}")
	public String addCongDoanSanXuat(@PathVariable int ID, @ModelAttribute SanPham sanPham, Model model) {
		sanPham = sanPhamService.findSanPhamByID(ID);
		model.addAttribute("tenSanPham", sanPham.getTenSP());
		return "quanLySanXuat_AddCongDoanSanXuat";
	}

	@GetMapping("/active_AddCongDoanSanXuat")
	public String active_AddCongDoanSanXuat(@ModelAttribute CongDoanSX congDoanSX,
			@RequestParam("tenSanPham") String tenSanPham, //
			@RequestParam("tenCongDoan") String tenCongDoan,
			@RequestParam("thoiGianHoanThien") String thoiGianHoanThien, //
			@RequestParam("moTa") String moTa, @ModelAttribute SanPham sanPham) {
		sanPham = sanPhamService.findSanPham(tenSanPham);
		congDoanSX.setMoTa(moTa);
		congDoanSX.setSanPham(sanPham);
		congDoanSX.setTenCongDoan(tenCongDoan);
		congDoanSX.setThoiGianHoanThien(thoiGianHoanThien);

		congDoanSXService.save(congDoanSX);
		return "redirect:/listSanPham_SX";
	}

	@GetMapping("/addBangDinhMuc/{ID}")
	public String addBangDinhMuc(@PathVariable int ID, @ModelAttribute SanPham sanPham, Model model,
			HttpSession session) {
		sanPham = sanPhamService.findSanPhamByID(ID);
		model.addAttribute("tenSanPham", sanPham.getTenSP());
		String hoTenSanXuat = (String) session.getAttribute("hoTenSanXuat");
		model.addAttribute("hoTenSanXuat", hoTenSanXuat);
		return "quanLySanXuat_AddBangDinhMuc";
	}

	@GetMapping("/active_AddBangDinhMuc")
	public String active_AddBangDinhMuc(@RequestParam("tenSanPham") String tenSanPham,
			@RequestParam("tenNVL") String tenNVL, //
			@RequestParam("soLuong") int soLuong, @RequestParam("hoTenSanXuat") String hoTenSanXuat,
			@ModelAttribute SanPham sanPham, //
			@ModelAttribute BangDinhMuc bangDinhMuc, @ModelAttribute NhanVien nhanVien,
			@ModelAttribute NguyenVatLieu nguyenVatLieu) {
		sanPham = sanPhamService.findSanPham(tenSanPham);
		nhanVien = nhanVienService.findNhanVien(hoTenSanXuat);
		nguyenVatLieu = nguyenVatLieuService.findOneNVLByTenNVL(tenNVL);
		bangDinhMuc.setNguyenVatLieu(nguyenVatLieu);
		bangDinhMuc.setNhanVien(nhanVien);
		bangDinhMuc.setSanPham(sanPham);
		bangDinhMuc.setSoLuong(soLuong);

		bangDinhMucService.save(bangDinhMuc);
		return "redirect:/listSanPham_SX";
	}

	@GetMapping("/editBangDinhMuc/{ID}")
	public String editBangDinhMuc(@PathVariable int ID, @ModelAttribute BangDinhMuc bangDinhMuc, Model model) {
		bangDinhMuc = bangDinhMucService.findByID(ID);
		model.addAttribute("ID", ID);
		model.addAttribute("tenSanPham", bangDinhMuc.getSanPham().getTenSP());
		model.addAttribute("tenNVL", bangDinhMuc.getNguyenVatLieu().getTenNVL());
		model.addAttribute("soLuong", bangDinhMuc.getSoLuong());
		model.addAttribute("hoTenSanXuat", bangDinhMuc.getNhanVien().getHoTen());
		return "quanLySanXuat_EditBangDinhMuc";
	}

	@GetMapping("/active_EditBangDinhMuc")
	public String active_EditBangDinhMuc(@RequestParam("ID")int ID,@RequestParam("tenSanPham")String tenSanPham,@RequestParam("tenNVL")String tenNVL,//
			@RequestParam("soLuong")int soluong,@RequestParam("hoTenSanXuat")String hoTenSanXuat,@ModelAttribute BangDinhMuc bangDinhMuc,//
			@ModelAttribute SanPham sanPham,@ModelAttribute NhanVien nhanVien,@ModelAttribute NguyenVatLieu nguyenVatLieu) {
		sanPham = sanPhamService.findSanPham(tenSanPham);
		nhanVien = nhanVienService.findNhanVien(hoTenSanXuat);
		nguyenVatLieu = nguyenVatLieuService.findOneNVLByTenNVL(tenNVL);
		
		bangDinhMuc.setID(ID);
		bangDinhMuc.setNguyenVatLieu(nguyenVatLieu);
		bangDinhMuc.setNhanVien(nhanVien);
		bangDinhMuc.setSanPham(sanPham);
		bangDinhMuc.setSoLuong(soluong);
		
		bangDinhMucService.save(bangDinhMuc);
		return "redirect:/listSanPham_SX";
	}
	
	@GetMapping("/removeBangDinhMuc/{ID}")
	public String removeBangDinhMuc(@PathVariable int ID,@ModelAttribute BangDinhMuc bangDinhMuc) {
		bangDinhMuc=bangDinhMucService.findByID(ID);
		bangDinhMucService.deleteBangDinhMuc(bangDinhMuc);
		return "redirect:/listSanPham_SX";
	}
	
	@GetMapping("/editCongDoanSanXuat/{ID}")
	public String editCongDoanSanXuat(@PathVariable int ID,Model model,@ModelAttribute CongDoanSX congDoanSX) {
		congDoanSX =congDoanSXService.findOneByID(ID);
		
		model.addAttribute("ID", congDoanSX.getID());
		model.addAttribute("tenSanPham", congDoanSX.getSanPham().getTenSP());
		model.addAttribute("tenCongDoan", congDoanSX.getTenCongDoan());
		model.addAttribute("thoiGianHoanThien", congDoanSX.getThoiGianHoanThien());
		model.addAttribute("moTa", congDoanSX.getMoTa());
		return "quanLySanXuat_EditCongDoanSanXuat";
	}
	
	@GetMapping("/active_EditCongDoanSanXuat")
	public String active_EditCongDoanSanXuat(@RequestParam("ID")int ID,@RequestParam("tenSanPham")String tenSanPham,@RequestParam("tenCongDoan")String tenCongDoan,//
			@RequestParam("thoiGianHoanThien")String thoiGianHoanThien,@RequestParam("moTa")String moTa,@ModelAttribute CongDoanSX congDoanSX,//
			@ModelAttribute SanPham sanPham) {
		sanPham=sanPhamService.findSanPham(tenSanPham);
		congDoanSX.setID(ID);
		congDoanSX.setMoTa(moTa);
		congDoanSX.setSanPham(sanPham);
		congDoanSX.setTenCongDoan(tenCongDoan);
		congDoanSX.setThoiGianHoanThien(thoiGianHoanThien);
		
		congDoanSXService.save(congDoanSX);
		return "redirect:/listSanPham_SX";
	}
	
	@GetMapping("/removeCongDoanSanXuat/{ID}")
	public String removeCongDoanSanXuat(@PathVariable int ID,@ModelAttribute CongDoanSX congDoanSX) {
		congDoanSX=congDoanSXService.findOneByID(ID);
		congDoanSXService.deleteCongDoanSX(congDoanSX);
		return "redirect:/listSanPham_SX";
	}
}
