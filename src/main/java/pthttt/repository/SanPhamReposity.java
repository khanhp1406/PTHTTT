package pthttt.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pthttt.entity.SanPham;

@Repository
public interface SanPhamReposity extends JpaRepository<SanPham, Integer>{
     
	//@Query(value = "SELECT * FROM pthttt.sanpham sp where sp.tensp=?1",nativeQuery = true)
	public SanPham findByTenSanPham(String tenSanPham);
	
	public SanPham findByID(int ID);
	
	public List<SanPham> findAll();
}
