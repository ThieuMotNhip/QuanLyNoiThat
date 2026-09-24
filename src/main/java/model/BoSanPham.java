package model;

public class BoSanPham {
	private String maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe;
	private int soLuongMonLe;
	
	public BoSanPham() {
		super();
	}

	public BoSanPham(String maBoSanPham, String maDinhDanhLuuKhoCaBo, String maDinhDanhLuuKhoMonLe, int soLuongMonLe) {
		super();
		this.maBoSanPham = maBoSanPham;
		this.maDinhDanhLuuKhoCaBo = maDinhDanhLuuKhoCaBo;
		this.maDinhDanhLuuKhoMonLe = maDinhDanhLuuKhoMonLe;
		this.soLuongMonLe = soLuongMonLe;
	}

	public String getMaBoSanPham() {
		return maBoSanPham;
	}

	public void setMaBoSanPham(String maBoSanPham) {
		this.maBoSanPham = maBoSanPham;
	}

	public String getMaDinhDanhLuuKhoCaBo() {
		return maDinhDanhLuuKhoCaBo;
	}

	public void setMaDinhDanhLuuKhoCaBo(String maDinhDanhLuuKhoCaBo) {
		this.maDinhDanhLuuKhoCaBo = maDinhDanhLuuKhoCaBo;
	}

	public String getMaDinhDanhLuuKhoMonLe() {
		return maDinhDanhLuuKhoMonLe;
	}

	public void setMaDinhDanhLuuKhoMonLe(String maDinhDanhLuuKhoMonLe) {
		this.maDinhDanhLuuKhoMonLe = maDinhDanhLuuKhoMonLe;
	}

	public int getSoLuongMonLe() {
		return soLuongMonLe;
	}

	public void setSoLuongMonLe(int soLuongMonLe) {
		this.soLuongMonLe = soLuongMonLe;
	}

	@Override
	public String toString() {
		return "BoSanPham [maBoSanPham=" + maBoSanPham + ", maDinhDanhLuuKhoCaBo=" + maDinhDanhLuuKhoCaBo
				+ ", maDinhDanhLuuKhoMonLe=" + maDinhDanhLuuKhoMonLe + ", soLuongMonLe=" + soLuongMonLe + "]";
	}
	
	
}
