package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.BangDinhMuc;
import pthttt.entity.SanPham;
import pthttt.repository.BangDinhMucRepository;

@Service
public class BangDinhMucService {

	@Autowired
	private BangDinhMucRepository bangDinhMucRepository;
	
	public List<BangDinhMuc> findAllBySanPham(SanPham sanPham){
		return bangDinhMucRepository.findAllBySanPham(sanPham);
	}
	
	
	public BangDinhMuc findByID(int ID) {
		return bangDinhMucRepository.findByID(ID);
	}
	public BangDinhMuc save(BangDinhMuc bangDinhMuc) {
		return bangDinhMucRepository.save(bangDinhMuc);
	}
	
	public void deleteBangDinhMuc(BangDinhMuc bangDinhMuc) {
		bangDinhMucRepository.delete(bangDinhMuc);
	}
	
	public List<BangDinhMuc> findAll(){
		return bangDinhMucRepository.findAll();
	}
}
