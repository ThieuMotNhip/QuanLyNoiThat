package model;

public class ChiTietDonHang {
	private String maChiTietDonHang, maDonHang, maSanPhamBienThe;
	private int soLuong;
	private double giaBan;
	
	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(String maChiTietDonHang, String maDonHang, String maSanPhamBienThe, int soLuong,
			double giaBan) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.maDonHang = maDonHang;
		this.maSanPhamBienThe = maSanPhamBienThe;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getMaSanPhamBienThe() {
		return maSanPhamBienThe;
	}

	public void setMaSanPhamBienThe(String maSanPhamBienThe) {
		this.maSanPhamBienThe = maSanPhamBienThe;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", maDonHang=" + maDonHang
				+ ", maSanPhamBienThe=" + maSanPhamBienThe + ", soLuong=" + soLuong + ", giaBan=" + giaBan + "]";
	}
	
}
