package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.CongDoanSX;
import pthttt.entity.SanPham;
import pthttt.repository.CongDoanSXRepository;

@Service
public class CongDoanSXService {

	@Autowired
	private CongDoanSXRepository congDoanSXRepository;
	
	public List<CongDoanSX> findAllBySanPham(SanPham sanPham){
		return congDoanSXRepository.findAllBySanPham(sanPham);
	}
	
	public CongDoanSX save(CongDoanSX congDoanSX) {
		return congDoanSXRepository.save(congDoanSX);
	}
	
	public CongDoanSX findOneByID(int ID) {
		return congDoanSXRepository.findByID(ID);
	}
	
	public void deleteCongDoanSX(CongDoanSX congDoanSX) {
		congDoanSXRepository.delete(congDoanSX);
	}
}
