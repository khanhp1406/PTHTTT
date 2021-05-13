package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.PhieuChi;
import pthttt.entity.PhieuMuaNVL;

@Repository
public interface PhieuChiRepository extends JpaRepository<PhieuChi, Integer>{

	public List<PhieuChi> findAllByPhieuMuaNVL(PhieuMuaNVL phieuMuaNVL);
	
	public PhieuChi findByID(int ID);
	
	public  void deleteById(Integer id); 
	
	public boolean existsByPhieuMuaNVL(PhieuMuaNVL phieuMuaNVL);
}
