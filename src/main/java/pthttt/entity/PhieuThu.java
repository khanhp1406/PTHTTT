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
@Table(name = "phieuthu")
public class PhieuThu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuDatHangID",nullable = false)
	private PhieuDatHang phieuDatHang;
	
	@Column(name = "SoPhieu",nullable = false)
	private String soPhieu;
	
	@Column(name = "LoaiPhieu",nullable = false)
	private String loaiPhieu;
	
	@Column(name = "Ngay",nullable = false)
	private String ngay;
	
	@Column(name = "NoiDung",nullable = false)
	private String noiDung;
	
	@Column(name = "ChuThich",nullable = false)
	private String chuThich;
	
	@Column(name = "TienDatCoc",nullable = false)
	private float tienDatCoc;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public PhieuDatHang getPhieudathang() {
		return phieuDatHang;
	}

	public void setPhieudathang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
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

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public float getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(float tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}
	
	
}
