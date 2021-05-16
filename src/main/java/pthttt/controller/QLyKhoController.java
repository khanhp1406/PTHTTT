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

import pthttt.entity.Kho;
import pthttt.entity.PhieuDatHang;
import pthttt.entity.PhieuXuatKho;
import pthttt.entity.ThanhPham;
import pthttt.service.KhoService;
import pthttt.service.PhieuDatHangService;
import pthttt.service.PhieuXuatKhoService;
import pthttt.service.ThanhPhamService;

@Controller
public class QLyKhoController {

	@Autowired
	private ThanhPhamService thanhPhamService;

	@Autowired
	private KhoService khoService;
	
	@Autowired
	private PhieuDatHangService phieuDatHangService;
	
	@Autowired
	private PhieuXuatKhoService phieuXuatKhoService;
	
	@GetMapping("/listThanhPham_Kho")
	public String ListThanhPham(Model model) {
		List<ThanhPham> listtpList = new ArrayList<ThanhPham>();
		listtpList = thanhPhamService.findAllThanhPhams();
		model.addAttribute("tps", listtpList);

		return "quanLyKho_ListThanhPham";
	}
	
	@GetMapping("/addPhieuXuatKho/{ID}")
	public String addPhieuXuatKho(@PathVariable int ID,@ModelAttribute ThanhPham thanhPham,Model model,@ModelAttribute Kho kho,//
			HttpSession session) {
		thanhPham=thanhPhamService.findOneThanhPhamByID(ID);
		if(thanhPham.getSoLuongTonKho()==thanhPham.getSoLuong() && thanhPham.getTinhTrang().equalsIgnoreCase("chưa giao")) {
			model.addAttribute("maPhieuDatHang", thanhPham.getPhieuDatHang().getMaPhieu());
			kho=khoService.findOneByID(1);
			model.addAttribute("tenKho", kho.getTenKho());
			model.addAttribute("soLuong", thanhPham.getSoLuongTonKho());
			
			session.setAttribute("IDThanhPhamXuatKho", ID);
			return "quanLyKho_AddPhieuXuatKho";
		}
		else {
			return "redirect:/listThanhPham_Kho";
		}
	}
	
	@GetMapping("/active_AddPhieuXuatKho")
	public String active_AddPhieuXuatKho(@RequestParam("maPhieuDatHang")String maPhieuDatHang,@RequestParam("soLuong")int soLuong,//
			@RequestParam("ngayXuat")String ngayXuat,@RequestParam("trangThai")String trangThai,@ModelAttribute PhieuXuatKho phieuXuatKho,//
			@ModelAttribute Kho kho,@ModelAttribute PhieuDatHang phieuDatHang,@ModelAttribute ThanhPham thanhPham,HttpSession session) {
		kho=khoService.findOneByID(1);
		phieuDatHang=phieuDatHangService.findOnePhieuDatHangByMa(maPhieuDatHang);
		
		phieuXuatKho.setKho(kho);
		phieuXuatKho.setNgayXuat(ngayXuat);
		phieuXuatKho.setPhieuDatHang(phieuDatHang);
		phieuXuatKho.setSoLuong(soLuong);
		phieuXuatKho.setTrangThai(trangThai);
		
		phieuXuatKhoService.save(phieuXuatKho);
		
		int IDThanhPhamXuatKho =(int) session.getAttribute("IDThanhPhamXuatKho");
		thanhPham=thanhPhamService.findOneThanhPhamByID(IDThanhPhamXuatKho);
		
		thanhPham.setID(thanhPham.getID());
		thanhPham.setLoaiGia(thanhPham.getLoaiGia());
		thanhPham.setPhieuDatHang(thanhPham.getPhieuDatHang());
		thanhPham.setSanPham(thanhPham.getSanPham());
		thanhPham.setSoLuong(thanhPham.getSoLuong());
		thanhPham.setSoLuongTonKho(0);
		thanhPham.setSoLuongTrongXuong(thanhPham.getSoLuongTrongXuong());
		thanhPham.setTinhTrang("đã giao");
		thanhPham.setXuong(thanhPham.getXuong());
		
		thanhPhamService.saveThanhPham(thanhPham);
		return "redirect:/listThanhPham_Kho";
	}
}
