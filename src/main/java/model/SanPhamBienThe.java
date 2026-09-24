package model;

public class SanPhamBienThe {
	private String maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc;
	private double giaBanChinhXac;
	private int soLuongTonKho;
	
	public SanPhamBienThe() {
		super();
	}

	public SanPhamBienThe(String maSanPhamBienThe, String maSanPhamGoc, String maDinhDanhLuuKho, String mauSac,
			String chatLieu, String kichThuoc, double giaBanChinhXac, int soLuongTonKho) {
		super();
		this.maSanPhamBienThe = maSanPhamBienThe;
		this.maSanPhamGoc = maSanPhamGoc;
		this.maDinhDanhLuuKho = maDinhDanhLuuKho;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
		this.kichThuoc = kichThuoc;
		this.giaBanChinhXac = giaBanChinhXac;
		this.soLuongTonKho = soLuongTonKho;
	}

	public String getMaSanPhamBienThe() {
		return maSanPhamBienThe;
	}

	public void setMaSanPhamBienThe(String maSanPhamBienThe) {
		this.maSanPhamBienThe = maSanPhamBienThe;
	}

	public String getMaSanPhamGoc() {
		return maSanPhamGoc;
	}

	public void setMaSanPhamGoc(String maSanPhamGoc) {
		this.maSanPhamGoc = maSanPhamGoc;
	}

	public String getMaDinhDanhLuuKho() {
		return maDinhDanhLuuKho;
	}

	public void setMaDinhDanhLuuKho(String maDinhDanhLuuKho) {
		this.maDinhDanhLuuKho = maDinhDanhLuuKho;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public double getGiaBanChinhXac() {
		return giaBanChinhXac;
	}

	public void setGiaBanChinhXac(double giaBanChinhXac) {
		this.giaBanChinhXac = giaBanChinhXac;
	}

	public int getSoLuongTonKho() {
		return soLuongTonKho;
	}

	public void setSoLuongTonKho(int soLuongTonKho) {
		this.soLuongTonKho = soLuongTonKho;
	}

	@Override
	public String toString() {
		return "SanPhamBienThe [maSanPhamBienThe=" + maSanPhamBienThe + ", maSanPhamGoc=" + maSanPhamGoc
				+ ", maDinhDanhLuuKho=" + maDinhDanhLuuKho + ", mauSac=" + mauSac + ", chatLieu=" + chatLieu
				+ ", kichThuoc=" + kichThuoc + ", giaBanChinhXac=" + giaBanChinhXac + ", soLuongTonKho=" + soLuongTonKho
				+ "]";
	}
	
}
