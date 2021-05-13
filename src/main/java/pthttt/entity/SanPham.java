package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable{

	private static final long serialVersionUID = 12L;
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false,unique = true)
	private int ID;
	
	@Column(name = "MaSP",nullable = false)
	private String maSP;
	
	@Column(name = "TenSanPham",nullable = false)
	private String tenSanPham;
	
	@Column(name = "KhoiLuong",nullable = false)
	private float khoiLuong;
	
	@Column(name = "DoDai",nullable = false)
	private float doDai;
	
	@Column(name = "DoRong",nullable = false)
	private float doRong;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSanPham;
	}

	public void setTenSP(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public float getKhoiLuong() {
		return khoiLuong;
	}

	public void setKhoiLuong(float khoiLuong) {
		this.khoiLuong = khoiLuong;
	}

	public float getDoDai() {
		return doDai;
	}

	public void setDoDai(float doDai) {
		this.doDai = doDai;
	}

	public float getDoRong() {
		return doRong;
	}

	public void setDoRong(float doRong) {
		this.doRong = doRong;
	}
	
	
}
