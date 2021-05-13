package pthttt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false,unique = true)
	private int ID;
	
	@Column(name = "ho_ten",nullable = false)
	private String hoTen;
	
	@Column(name = "ten_dang_nhap",nullable = false)
	private String tenDangNhap;
	
	@Column(name = "mat_khau",nullable = false)
	private String matKhau;
	
	@Column(name = "dia_chi",nullable = false)
	private String diaChi;
	
	@Column(name = "vi_tri",nullable = false)
	private String viTri;
	
	@Column(name = "bo_phan",nullable = false,unique = true)
	private String boPhan;

	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public String getBoPhan() {
		return boPhan;
	}

	public void setBoPhan(String boPhan) {
		this.boPhan = boPhan;
	}
	
}
