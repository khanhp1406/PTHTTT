package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.PhieuDatHang;
import pthttt.entity.PhieuThu;

@Repository
public interface PhieuThuRepository extends JpaRepository<PhieuThu, Integer>{

	public List<PhieuThu> findAllByPhieuDatHang(PhieuDatHang phieuDatHang) ;
	
	public boolean existsByPhieuDatHang(PhieuDatHang phieuDatHang); 
	
	public PhieuThu findByID(int ID);
	
}
