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

import pthttt.entity.LenhSanXuat;
import pthttt.entity.NhanVien;
import pthttt.entity.PhieuDatHang;
import pthttt.service.LenhSanXuatService;
import pthttt.service.NhanVienService;
import pthttt.service.PhieuDatHangService;
import pthttt.service.PhieuMuaNVLService;

@Controller
public class QLyKyThuatController {

	@Autowired
	private PhieuDatHangService phieuDatHangService;
	
	@Autowired
	private LenhSanXuatService lenhSanXuatService;
	
	@Autowired
	private PhieuMuaNVLService phieuMuaNVLService;
	
	@Autowired
	private NhanVienService nhanVienService;
	
	@GetMapping("/phieuDatHang_KT")
	public String listPhieuDatHang(Model model) {
		List<PhieuDatHang> listpdh=new ArrayList<PhieuDatHang>();
		listpdh=phieuDatHangService.findAllPhieuDatHang();
		model.addAttribute("pdhs", listpdh);
		return "quanLyKT_ListPhieuDatHang";
	}
	
	@GetMapping("/listLenhSanXuat/{ID}")
	public String listLenhSanXuat(Model model,@PathVariable int ID,@ModelAttribute PhieuDatHang phieuDatHang) {
		phieuDatHang=phieuDatHangService.findOnePhieuDatHangByID(ID);
		List<LenhSanXuat> listlsx=new ArrayList<LenhSanXuat>();
		listlsx=lenhSanXuatService.findAllByPhieuDatHang(phieuDatHang);
		model.addAttribute("lsxs", listlsx);
		return "quanLyKT_ListLenhSanXuat";
	}
	
	@GetMapping("/removeLenhSanXuat/{ID}")
	public String removeLenhSanXuat(@PathVariable int ID,@ModelAttribute LenhSanXuat lenhSanXuat) {
		lenhSanXuat=lenhSanXuatService.findOneByID(ID);
		if(phieuMuaNVLService.existsLenhSanXuat(lenhSanXuat)) {
			return "redirect:/phieuDatHang_KT";
		}else {
			lenhSanXuatService.removeLenhSanXuat(lenhSanXuat);
		}
		return "redirect:/phieuDatHang_KT";
	}
	
	@GetMapping("/editLenhSanXuat/{ID}")
	public String editLenhSanXuat(@ModelAttribute LenhSanXuat lenhSanXuat,Model model,@PathVariable int ID) {
		lenhSanXuat=lenhSanXuatService.findOneByID(ID);
		model.addAttribute("ID", lenhSanXuat.getID());
		model.addAttribute("tenNhanVien", lenhSanXuat.getNhanVien().getHoTen());
		model.addAttribute("maPhieuDatHang", lenhSanXuat.getPhieuDatHang().getMaPhieu());
		model.addAttribute("ngayBatDauSP", lenhSanXuat.getNgayBatDauSP());
		model.addAttribute("ngayXuatSP", lenhSanXuat.getNgayXuatSP());
		model.addAttribute("trangThai", lenhSanXuat.getTrangThai());
		model.addAttribute("chuThich", lenhSanXuat.getChuThich());
		return "quanLyKT_EditLenhSanXuat";
	}
	
	@GetMapping("/active_EditLenhSanXuat")
	public String active_EditLenhSanXuat(@ModelAttribute LenhSanXuat lenhSanXuat,@RequestParam("ID")int ID,@RequestParam("tenNhanVien")String tenNhanVien,//
			@RequestParam("maPhieuDatHang")String maPhieuDatHang,@RequestParam("ngayBatDauSP")String ngayBatDauSP,@RequestParam("ngayXuatSP")String ngayXuatSP,//
			@RequestParam("trangThai")String trangThai,@RequestParam("chuThich")String chuThich,@ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute NhanVien nhanVien) {
		
		nhanVien=nhanVienService.findNhanVien(tenNhanVien);
		phieuDatHang=phieuDatHangService.findOnePhieuDatHangByMa(maPhieuDatHang);
		lenhSanXuat.setID(ID);
		lenhSanXuat.setChuThich(chuThich);
		lenhSanXuat.setNgayBatDauSP(ngayBatDauSP);
		lenhSanXuat.setNgayXuatSP(ngayXuatSP);
		lenhSanXuat.setNhanVien(nhanVien);
		lenhSanXuat.setPhieuDatHang(phieuDatHang);
		lenhSanXuat.setTrangThai(trangThai);
		
		lenhSanXuatService.save(lenhSanXuat);
		return "redirect:/phieuDatHang_KT";
	}
	
	@GetMapping("/addLenhSanXuat/{ID}")
	public String addLenhSanXuat(Model model,@PathVariable int ID,@ModelAttribute PhieuDatHang phieuDatHang,HttpSession session) {
		phieuDatHang=phieuDatHangService.findOnePhieuDatHangByID(ID);
		model.addAttribute("maPhieuDatHang", phieuDatHang.getMaPhieu());
		
		String hoTenKyThuat=(String) session.getAttribute("hoTenKyThuat");
		model.addAttribute("hoTenKyThuat", hoTenKyThuat);
		return "quanLyKT_AddLenhSanXuat";
	}
	
	@GetMapping("/active_AddLenhSanXuat")
	public String active_AddLenhSanXuat(@ModelAttribute LenhSanXuat lenhSanXuat,@RequestParam("tenNhanVien")String tenNhanVien,@RequestParam("maPhieuDatHang")String maPhieuDatHang,//
			@RequestParam("ngayBatDauSP")String ngayBatDauSP,@RequestParam("ngayXuatSP")String ngayXuatSP,@RequestParam("trangThai")String trangThai,//
			@RequestParam("chuThich")String chuThich,@ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute NhanVien nhanVien) {
		
		nhanVien=nhanVienService.findNhanVien(tenNhanVien);
		phieuDatHang=phieuDatHangService.findOnePhieuDatHangByMa(maPhieuDatHang);
		lenhSanXuat.setChuThich(chuThich);
		lenhSanXuat.setNgayBatDauSP(ngayBatDauSP);
		lenhSanXuat.setNgayXuatSP(ngayXuatSP);
		lenhSanXuat.setNhanVien(nhanVien);
		lenhSanXuat.setPhieuDatHang(phieuDatHang);
		lenhSanXuat.setTrangThai(trangThai);
		
		lenhSanXuatService.save(lenhSanXuat);
		return "redirect:/phieuDatHang_KT";
	}
}
