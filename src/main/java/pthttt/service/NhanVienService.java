package pthttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pthttt.entity.NhanVien;
import pthttt.repository.NhanVienRepository;

@Service
@Transactional
public class NhanVienService {

	@Autowired
	private NhanVienRepository nhanVienRepository;
	
	public NhanVien findNhanVien(String tenDangNhap,String matKhau) {
		return nhanVienRepository.findByTenDangNhapAndMatKhau(tenDangNhap,matKhau);
	}
	
	public NhanVien findNhanVien(String hoTen) {
		return nhanVienRepository.findByHoTen(hoTen);
	}
	public NhanVien getNhanVien(String tenDangNhap,String matKhau) {
		return nhanVienRepository.getByTenDangNhap(tenDangNhap);
	}
	public boolean checkNhanVien(String tenDangNhap,String matKhau) {
		return nhanVienRepository.existsByTenDangNhapAndMatKhau(tenDangNhap, matKhau);
	}
	public boolean checkNhanVienByHoTen(String hoTen) {
		return nhanVienRepository.existsByHoTen(hoTen);
	}
}
