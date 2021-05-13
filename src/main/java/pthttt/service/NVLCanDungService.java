package pthttt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pthttt.entity.NVLCanDung;
import pthttt.entity.PhieuMuaNVL;
import pthttt.repository.NVLCanDungRepository;

@Service
public class NVLCanDungService {

	@Autowired
	private NVLCanDungRepository nvlCanDungRepository;
	
	public List<NVLCanDung> findAll(PhieuMuaNVL phieuMuaNVL){
		return nvlCanDungRepository.findAllByPhieuMuaNVL(phieuMuaNVL);
	}
	
	public boolean check(PhieuMuaNVL phieuMuaNVL) {
		return nvlCanDungRepository.existsByPhieuMuaNVL(phieuMuaNVL);
	}
	
	public NVLCanDung save(NVLCanDung nvlCanDung) {
		return nvlCanDungRepository.save(nvlCanDung);
	}
	
	public NVLCanDung findOne(int ID) {
		return nvlCanDungRepository.findByID(ID);
	}
	
	public void delete(NVLCanDung nvlCanDung) {
		nvlCanDungRepository.delete(nvlCanDung);
	}
}
