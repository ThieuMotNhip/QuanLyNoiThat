package model;

public class DanhMucSanPham {
	private String maDanhMuc;
	private String tenDanhMuc;
	private String moTa;
	
	public DanhMucSanPham() {
		super();
	}

	public DanhMucSanPham(String maDanhMuc, String tenDanhMuc, String moTa) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.moTa = moTa;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "DanhMucSanPham [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + ", moTa=" + moTa + "]";
	}
	
}
