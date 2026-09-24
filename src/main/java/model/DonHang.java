package model;

import java.sql.Date;

public class DonHang {
	private String maDonHang, maKhachHang;
	private Date ngayDatHang;
	private String trangThai;
	private double tongGiaTriDonHang, soTienKhachHangDaDatCoc;
	
	public DonHang() {
		super();
	}

	public DonHang(String maDonHang, String maKhachHang, Date ngayDatHang, String trangThai, double tongGiaTriDonHang,
			double soTienKhachHangDaDatCoc) {
		super();
		this.maDonHang = maDonHang;
		this.maKhachHang = maKhachHang;
		this.ngayDatHang = ngayDatHang;
		this.trangThai = trangThai;
		this.tongGiaTriDonHang = tongGiaTriDonHang;
		this.soTienKhachHangDaDatCoc = soTienKhachHangDaDatCoc;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public double getTongGiaTriDonHang() {
		return tongGiaTriDonHang;
	}

	public void setTongGiaTriDonHang(double tongGiaTriDonHang) {
		this.tongGiaTriDonHang = tongGiaTriDonHang;
	}

	public double getSoTienKhachHangDaDatCoc() {
		return soTienKhachHangDaDatCoc;
	}

	public void setSoTienKhachHangDaDatCoc(double soTienKhachHangDaDatCoc) {
		this.soTienKhachHangDaDatCoc = soTienKhachHangDaDatCoc;
	}

	@Override
	public String toString() {
		return "DonHang [maDonHang=" + maDonHang + ", maKhachHang=" + maKhachHang + ", ngayDatHang=" + ngayDatHang
				+ ", trangThai=" + trangThai + ", tongGiaTriDonHang=" + tongGiaTriDonHang + ", soTienKhachHangDaDatCoc="
				+ soTienKhachHangDaDatCoc + "]";
	}
	
	
}
