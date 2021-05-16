package pthttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.Kho;
import pthttt.repository.KhoRepository;

@Service
public class KhoService {

	@Autowired
	private KhoRepository khoRepository;
	
	public Kho findOneByID(int ID) {
		return khoRepository.findByID(ID);
	}
}
