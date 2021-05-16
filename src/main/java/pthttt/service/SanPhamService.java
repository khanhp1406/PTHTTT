package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.SanPham;
import pthttt.repository.SanPhamReposity;

@Service
public class SanPhamService {
	
	@Autowired
	private SanPhamReposity sanPhamRepository;

	public SanPham findSanPham(String tenSanPham) {
		return sanPhamRepository.findByTenSanPham(tenSanPham);
	}
	
	public SanPham findSanPhamByID(int ID) {
		return sanPhamRepository.findByID(ID);
	}
	
	public List<SanPham> findAllSanPham(){
		return sanPhamRepository.findAll();
	}
	
	public SanPham save(SanPham sanPham) {
		return sanPhamRepository.save(sanPham);
	}
}
