package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.NguyenVatLieu;
import pthttt.repository.NguyenVatLieuRepository;

@Service
public class NguyenVatLieuService {

	@Autowired
	private NguyenVatLieuRepository nguyenVatLieuRepository;
	
	public NguyenVatLieu findOneNVLByTenNVL(String tenNVL) {
		return nguyenVatLieuRepository.findByTenNVL(tenNVL);
	}
	
	public List<NguyenVatLieu> findAll(){
		return nguyenVatLieuRepository.findAll();
	}
	
	public NguyenVatLieu save(NguyenVatLieu nguyenVatLieu) {
		return nguyenVatLieuRepository.save(nguyenVatLieu);
	}
	
	public NguyenVatLieu findByID(int ID) {
		return nguyenVatLieuRepository.findByID(ID);
	}
}
