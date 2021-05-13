package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.PhieuDatHang;

@Repository
public interface PhieuDatHangRepository extends JpaRepository<PhieuDatHang, Integer>{
 
	public List<PhieuDatHang> findAll() ;
	 
	public PhieuDatHang findByMaPhieu(String maPhieu);
	
	public PhieuDatHang findByID(int ID);
	
}
