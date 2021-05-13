package pthttt.service;

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
}
