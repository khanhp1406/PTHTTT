package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.LenhSanXuat;
import pthttt.entity.PhieuDatHang;

@Repository
public interface LenhSanXuatRepository extends JpaRepository<LenhSanXuat, Integer> {

	public List<LenhSanXuat> findAllByPhieuDatHang(PhieuDatHang phieuDatHang);
	
	public List<LenhSanXuat> findAll();
	
	public LenhSanXuat findByID(int ID);
	
	public boolean existsByPhieuDatHang(PhieuDatHang phieuDatHang);
 }
