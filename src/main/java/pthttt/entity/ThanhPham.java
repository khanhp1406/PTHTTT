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
@Table(name = "thanhpham")
public class ThanhPham implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",nullable = false)
	private int ID;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SanPhamId",nullable = false)
	private SanPham sanPham;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PhieuDatHangID",nullable = false)
	private PhieuDatHang phieuDatHang;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "XuongID",nullable = false)
	private Xuong xuong;
	
	@Column(name = "SoLuong",nullable = false)
	private int soLuong;
	
	@Column(name = "SoLuongTonKho", nullable = false)
	private int soLuongTonKho;
	
	@Column(name = "SoLuongTrongXuong", nullable = false)
	private int soLuongTrongXuong;
	
	@Column(name = "TinhTrang", nullable = false)
	private String tinhTrang;
	
	@Column(name = "LoaiGia", nullable = false)
	private float loaiGia;
	
	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	public int getSoLuongTrongXuong() {
		return soLuongTrongXuong;
	}

	public void setSoLuongTrongXuong(int soLuongTrongXuong) {
		this.soLuongTrongXuong = soLuongTrongXuong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public float getLoaiGia() {
		return loaiGia;
	}

	public void setLoaiGia(float loaiGia) {
		this.loaiGia = loaiGia;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public PhieuDatHang getPhieuDatHang() {
		return phieuDatHang;
	}

	public void setPhieuDatHang(PhieuDatHang phieuDatHang) {
		this.phieuDatHang = phieuDatHang;
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
