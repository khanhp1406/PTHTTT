package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phieuluuchuyen")
public class PhieuLuuChuyen implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XuongID",nullable = false)
	private Xuong xuong;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KhoID",nullable = false)
	private Kho kho;
	
	@Column(name = "NgayLap",nullable = false)
	private String ngayLap;
	
	@Column(name = "ChuThich",nullable = false)
	private String chuThich;
	
	@Column(name = "NoiDen",nullable = false)
	private String noiDen;
	
	@Column(name = "NoiDi",nullable = false)
	private String noiDi;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Xuong getXuong() {
		return xuong;
	}

	public void setXuong(Xuong xuong) {
		this.xuong = xuong;
	}

	public Kho getKho() {
		return kho;
	}

	public void setKho(Kho kho) {
		this.kho = kho;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getNoiDen() {
		return noiDen;
	}

	public void setNoiDen(String noiDen) {
		this.noiDen = noiDen;
	}

	public String getNoiDi() {
		return noiDi;
	}

	public void setNoiDi(String noiDi) {
		this.noiDi = noiDi;
	}
	
	
}
