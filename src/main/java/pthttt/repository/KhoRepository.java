package pthttt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.Kho;

@Repository
public interface KhoRepository extends JpaRepository<Kho, Integer> {

	public Kho findByID(int ID);
}
