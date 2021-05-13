package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.NVLCanDung;
import pthttt.entity.PhieuMuaNVL;

@Repository
public interface NVLCanDungRepository extends JpaRepository<NVLCanDung, Integer>{

	public List<NVLCanDung> findAllByPhieuMuaNVL(PhieuMuaNVL phieuMuaNVL);

	public boolean existsByPhieuMuaNVL(PhieuMuaNVL phieuMuaNVL);
	
	public NVLCanDung findByID(int ID);
}
