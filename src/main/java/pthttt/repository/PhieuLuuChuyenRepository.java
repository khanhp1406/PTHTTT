package pthttt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.PhieuLuuChuyen;

@Repository
public interface PhieuLuuChuyenRepository extends JpaRepository<PhieuLuuChuyen, Integer>{

}
