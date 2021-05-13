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
@Table(name = "nvlcandung")
public class NVLCanDung implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuMuaNVLID",nullable = false)
	private PhieuMuaNVL phieuMuaNVL;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NguyenVatLieuID",nullable = false)
	private NguyenVatLieu nguyenVatLieu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XuongID",nullable = false)
	private Xuong xuong;
	
	@Column(name = "SoLuong",nullable = false)
	private int soLuong;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public PhieuMuaNVL getPhieuMuaNVL() {
		return phieuMuaNVL;
	}

	public void setPhieuMuaNVL(PhieuMuaNVL phieuMuaNVL) {
		this.phieuMuaNVL = phieuMuaNVL;
	}

	public NguyenVatLieu getNguyenVatLieu() {
		return nguyenVatLieu;
	}

	public void setNguyenVatLieu(NguyenVatLieu nguyenVatLieu) {
		this.nguyenVatLieu = nguyenVatLieu;
	}

	public Xuong getXuong() {
		return xuong;
	}

	public void setXuong(Xuong xuong) {
		this.xuong = xuong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	
}
