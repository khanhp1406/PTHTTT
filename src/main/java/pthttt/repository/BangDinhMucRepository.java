package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.BangDinhMuc;
import pthttt.entity.SanPham;

@Repository
public interface BangDinhMucRepository extends JpaRepository<BangDinhMuc, Integer>{

	public List<BangDinhMuc> findAllBySanPham(SanPham sanPham);
	
	public BangDinhMuc findByID(int ID);
	
	public List<BangDinhMuc> findAll();
	

}
