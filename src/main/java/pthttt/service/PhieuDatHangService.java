package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.PhieuDatHang;
import pthttt.repository.PhieuDatHangRepository;

@Service
public class PhieuDatHangService {

	@Autowired
	PhieuDatHangRepository pdhRepository;
	
	public List<PhieuDatHang> findAllPhieuDatHang() {
		return  pdhRepository.findAll();
	}
	
	public PhieuDatHang savePhieuDatHang(PhieuDatHang phieuDatHang) {
		return pdhRepository.save(phieuDatHang);
	}
	
	public PhieuDatHang findOnePhieuDatHangByID(int ID) {
		return pdhRepository.findByID(ID);
	}
	
	public PhieuDatHang findOnePhieuDatHangByMa(String maPhieu) {
		return pdhRepository.findByMaPhieu(maPhieu);
	}
	
	public void delete(int id) {
        pdhRepository.deleteById(id);
    }
}
