package pthttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuLuuChuyen;
import pthttt.repository.PhieuLuuChuyenRepository;

@Service
public class PhieuLuuChuyenService {

	@Autowired
	private PhieuLuuChuyenRepository phieuLuuChuyenRepository;
	
	public PhieuLuuChuyen save(PhieuLuuChuyen phieuLuuChuyen) {
		return phieuLuuChuyenRepository.save(phieuLuuChuyen);
	}
}
