package model;

public class MauSanPham {
	private String maSanPhamGoc, maDanhMuc, tenSanPham;
	private double giaBanCoBan;
	private String moTaChiTiet;
	
	public MauSanPham() {
		super();
	}

	public MauSanPham(String maSanPhamGoc, String maDanhMuc, String tenSanPham, double giaBanCoBan,
			String moTaChiTiet) {
		super();
		this.maSanPhamGoc = maSanPhamGoc;
		this.maDanhMuc = maDanhMuc;
		this.tenSanPham = tenSanPham;
		this.giaBanCoBan = giaBanCoBan;
		this.moTaChiTiet = moTaChiTiet;
	}

	public String getMaSanPhamGoc() {
		return maSanPhamGoc;
	}

	public void setMaSanPhamGoc(String maSanPhamGoc) {
		this.maSanPhamGoc = maSanPhamGoc;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGiaBanCoBan() {
		return giaBanCoBan;
	}

	public void setGiaBanCoBan(double giaBanCoBan) {
		this.giaBanCoBan = giaBanCoBan;
	}

	public String getMoTaChiTiet() {
		return moTaChiTiet;
	}

	public void setMoTaChiTiet(String moTaChiTiet) {
		this.moTaChiTiet = moTaChiTiet;
	}

	@Override
	public String toString() {
		return "MauSanPham [maSanPhamGoc=" + maSanPhamGoc + ", maDanhMuc=" + maDanhMuc + ", tenSanPham=" + tenSanPham
				+ ", giaBanCoBan=" + giaBanCoBan + ", moTaChiTiet=" + moTaChiTiet + "]";
	}
	
}
