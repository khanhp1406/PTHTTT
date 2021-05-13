package pthttt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pthttt.entity.Xuong;

@Repository
public interface XuongRepository extends JpaRepository<Xuong, Integer>{
	
	public Xuong findById(int ID);
	
}
