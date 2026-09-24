package model;

public class KhachHang {
	private String maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String username, String tenKhachHang, String soDienThoai,
			String diaChiGiaoHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.username = username;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", username=" + username + ", tenKhachHang=" + tenKhachHang
				+ ", soDienThoai=" + soDienThoai + ", diaChiGiaoHang=" + diaChiGiaoHang + "]";
	}
	
	
}
