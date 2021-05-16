package pthttt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuXuatKho;
import pthttt.repository.PhieuXuatKhoRepository;

@Service
public class PhieuXuatKhoService {

	@Autowired
	private PhieuXuatKhoRepository phieuXuatKhoRepository;
	
	public PhieuXuatKho save(PhieuXuatKho phieuXuatKho) {
		return phieuXuatKhoRepository.save(phieuXuatKho);
	}
}
