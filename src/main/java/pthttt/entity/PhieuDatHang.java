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
@Table(name = "phieudathang")
public class PhieuDatHang implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int ID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NhanVienID", nullable = false)
	private NhanVien nhanVien;

	@Column(name = "MaPhieu", nullable = false)
	private String maPhieu;

	@Column(name = "NgayLap", nullable = false)
	private String ngayLap;

	@Column(name = "TenKH", nullable = false)
	private String tenKH;

	@Column(name = "SoDienThoaiKH", nullable = false)
	private String sdtKH;

	@Column(name = "NgayGiaoHang", nullable = false)
	private String ngayGiaoHang;

	@Column(name = "TrangThai", nullable = false)
	private String trangThai;

	@Column(name = "ChuThich", nullable = false)
	private String chuThich;

	@Column(name = "DiaChiKH", nullable = false)
	private String diaChiKH;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdtKH() {
		return sdtKH;
	}

	public void setSdtKH(String sdtKH) {
		this.sdtKH = sdtKH;
	}

	public String getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(String ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getChuThich() {
		return chuThich;
	}

	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}

	public String getDiaChiKH() {
		return diaChiKH;
	}

	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}

}
