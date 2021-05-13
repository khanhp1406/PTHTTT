package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.LenhSanXuat;
import pthttt.entity.PhieuDatHang;
import pthttt.repository.LenhSanXuatRepository;

@Service
public class LenhSanXuatService {

	@Autowired
	private LenhSanXuatRepository lenhSanXuatRepository;
	
	public List<LenhSanXuat> findAllByPhieuDatHang(PhieuDatHang phieuDatHang){
		return lenhSanXuatRepository.findAllByPhieuDatHang(phieuDatHang);
	}
	
	public List<LenhSanXuat> findAllLenhSanXuat(){
		return lenhSanXuatRepository.findAll();
	}
	public LenhSanXuat findOneByID(int ID) {
		return lenhSanXuatRepository.findByID(ID);
	}
	
	public void removeLenhSanXuat(LenhSanXuat lenhSanXuat) {
		lenhSanXuatRepository.delete(lenhSanXuat);
	}
	
	public LenhSanXuat save(LenhSanXuat lenhSanXuat) {
		return lenhSanXuatRepository.save(lenhSanXuat);
	}
	
	public boolean check(PhieuDatHang phieuDatHang) {
		return lenhSanXuatRepository.existsByPhieuDatHang(phieuDatHang);
	}
}
