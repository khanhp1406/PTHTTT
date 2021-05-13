package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.LenhSanXuat;
import pthttt.entity.PhieuMuaNVL;

@Repository
public interface PhieuMuaNVLRepository extends JpaRepository<PhieuMuaNVL, Integer>{

	public boolean existsByLenhSanXuat(LenhSanXuat lenhSanXuat); 
	
	public List<PhieuMuaNVL> findAllByLenhSanXuat(LenhSanXuat lenhSanXuat);
	
	public PhieuMuaNVL findByID(int ID);
	
	public PhieuMuaNVL findByMaPhieu(String maPhieu);
	
	public void deleteById(int ID);
}
