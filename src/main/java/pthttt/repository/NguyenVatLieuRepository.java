package pthttt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.NguyenVatLieu;

@Repository
public interface NguyenVatLieuRepository extends JpaRepository<NguyenVatLieu, Integer>{

	public NguyenVatLieu findByTenNVL(String tenNVL);
}
