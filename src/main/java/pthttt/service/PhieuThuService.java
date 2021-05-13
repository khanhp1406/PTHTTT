package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuDatHang;
import pthttt.entity.PhieuThu;
import pthttt.repository.PhieuThuRepository;

@Service
public class PhieuThuService {

	@Autowired
	private PhieuThuRepository phieuThuRepository;
	
	public List<PhieuThu> findAllByPhieuDatHang(PhieuDatHang phieuDatHang){
		return phieuThuRepository.findAllByPhieuDatHang(phieuDatHang);
	}
	
	public boolean checkPhieuThuByPhieuDatHang(PhieuDatHang phieuDatHang) {
		return phieuThuRepository.existsByPhieuDatHang(phieuDatHang);
	}
	
	public void savePhieuThu(PhieuThu phieuThu) {
		 phieuThuRepository.save(phieuThu);
	}
	public void removePhieuThu(int ID) {
		phieuThuRepository.deleteById(ID);
	}
	
	public PhieuThu findOnePhieuTHuByID(int ID) {
		return phieuThuRepository.findByID(ID);
	}
}
