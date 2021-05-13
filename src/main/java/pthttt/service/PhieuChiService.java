package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuChi;
import pthttt.entity.PhieuMuaNVL;
import pthttt.repository.PhieuChiRepository;

@Service
public class PhieuChiService {

	@Autowired
	private PhieuChiRepository phieuChiRepository;
	
	public List<PhieuChi> findAll(PhieuMuaNVL phieuMuaNVL) {
		return phieuChiRepository.findAllByPhieuMuaNVL(phieuMuaNVL);
	}
	
	public PhieuChi save(PhieuChi phieuChi) {
		return phieuChiRepository.save(phieuChi);
	}
	
	public PhieuChi findOne(int ID) {
		return phieuChiRepository.findByID(ID);
	}
	
	public void delete(int ID) {
		phieuChiRepository.deleteById(ID);
	}
	
	public boolean check(PhieuMuaNVL phieuMuaNVL) {
		return phieuChiRepository.existsByPhieuMuaNVL(phieuMuaNVL);
	}
}
