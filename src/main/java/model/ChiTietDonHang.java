package model;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(Double.valueOf(giaBan), maChiTietDonHang, maDonHang, maSanPhamBienThe,
				Integer.valueOf(soLuong));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDonHang other = (ChiTietDonHang) obj;
		return Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Objects.equals(maChiTietDonHang, other.maChiTietDonHang)
				&& Objects.equals(maDonHang, other.maDonHang)
				&& Objects.equals(maSanPhamBienThe, other.maSanPhamBienThe) && soLuong == other.soLuong;
	}
	
}
