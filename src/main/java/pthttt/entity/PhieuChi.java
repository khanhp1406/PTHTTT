package pthttt.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phieuchi")
public class PhieuChi implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@Column(name = "SoPhieu",nullable = false)
	private String soPhieu;
	
	@Column(name = "LoaiPhieu",nullable = false)
	private String loaiPhieu;
	
	@Column(name = "Ngay",nullable = false)
	private String ngay;
	
	@Column(name = "NoiDung",nullable = false)
	private String noiDung;
	
	@Column(name = "GiaThanh",nullable = false)
	private float giaThanh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuMuaNVLID",nullable = false)
	private PhieuMuaNVL phieuMuaNVL;
	
	
	public PhieuMuaNVL getPhieuMuaNVL() {
		return phieuMuaNVL;
	}

	public void setPhieuMuaNVl(PhieuMuaNVL phieuMuaNVL) {
		this.phieuMuaNVL = phieuMuaNVL;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public String getSoPhieu() {
		return soPhieu;
	}

	public void setSoPhieu(String soPhieu) {
		this.soPhieu = soPhieu;
	}

	public String getLoaiPhieu() {
		return loaiPhieu;
	}

	public void setLoaiPhieu(String loaiPhieu) {
		this.loaiPhieu = loaiPhieu;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public float getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(float giaThanh) {
		this.giaThanh = giaThanh;
	}
	
	
}
