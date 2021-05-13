package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.LenhSanXuat;
import pthttt.entity.PhieuMuaNVL;
import pthttt.repository.PhieuMuaNVLRepository;

@Service
public class PhieuMuaNVLService {

	@Autowired
	private PhieuMuaNVLRepository phieuMuaNVLRepository;
	
	public boolean existsLenhSanXuat(LenhSanXuat lenhSanXuat) {
		return phieuMuaNVLRepository.existsByLenhSanXuat(lenhSanXuat);
	}
	
	public List<PhieuMuaNVL> findAllByLenhSanXuat(LenhSanXuat lenhSanXuat){
		return phieuMuaNVLRepository.findAllByLenhSanXuat(lenhSanXuat);
	}
	
	public PhieuMuaNVL findOneByID(int ID) {
		return phieuMuaNVLRepository.findByID(ID);
	}
	
	public PhieuMuaNVL save(PhieuMuaNVL phieuMuaNVL) {
		return phieuMuaNVLRepository.save(phieuMuaNVL);
	}
	
	public void delete(int ID) {
		phieuMuaNVLRepository.deleteById(ID);
	}
	
	public PhieuMuaNVL findOneByMaPhieu(String maPhieu) {
		return phieuMuaNVLRepository.findByMaPhieu(maPhieu);
	}
}
