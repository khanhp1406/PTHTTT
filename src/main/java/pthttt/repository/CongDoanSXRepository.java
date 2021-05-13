package pthttt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.CongDoanSX;
import pthttt.entity.SanPham;

@Repository
public interface CongDoanSXRepository extends JpaRepository<CongDoanSX, Integer>{

	public List<CongDoanSX> findAllBySanPham(SanPham sanPham);
	
	public CongDoanSX findByID(int ID);
	
}
