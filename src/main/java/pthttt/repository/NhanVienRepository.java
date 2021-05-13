package pthttt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pthttt.entity.NhanVien;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

	@Query(value = "select * from pthttt.nhanvien nv where nv.ten_dang_nhap=?1 and nv.mat_khau=?2", nativeQuery = true)
	public NhanVien findByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau);
	
	public NhanVien findByHoTen(String hoTen);

	public NhanVien getByTenDangNhap(String tenDangNhap);

	public boolean existsByTenDangNhapAndMatKhau(String tenDangNhap, String matKhau) ;

	public boolean existsByHoTen(String hoTen);
}
