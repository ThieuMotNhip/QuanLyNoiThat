package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLChiTietDonHangModel extends AbstractTableModel{
	private ArrayList<ChiTietDonHang> dsChiTietDonHang;
	private String[] tenCacCot;
	
	public QLChiTietDonHangModel() {
		this.dsChiTietDonHang = new ArrayList<ChiTietDonHang>();
		this.tenCacCot = new String[] {"Mã chi tiết đơn hàng", "Mã đơn hàng", "Mã sản phẩm biến thể", "Số lượng", "Giá bán"};
	}
	

	public ArrayList<ChiTietDonHang> getDsChiTietDonHang() {
		return dsChiTietDonHang;
	}


	public void setDsChiTietDonHang(ArrayList<ChiTietDonHang> dsChiTietDonHang) {
		this.dsChiTietDonHang = dsChiTietDonHang;
	}


	public String[] getTenCacCot() {
		return tenCacCot;
	}


	public void setTenCacCot(String[] tenCacCot) {
		this.tenCacCot = tenCacCot;
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.dsChiTietDonHang.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.tenCacCot.length;
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.tenCacCot[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		ChiTietDonHang chiTietDonHang = this.dsChiTietDonHang.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return chiTietDonHang.getMaChiTietDonHang();
			case 1:
				return chiTietDonHang.getMaDonHang();
			case 2:
				return chiTietDonHang.getMaSanPhamBienThe();
			case 3:
				return chiTietDonHang.getSoLuong();
			case 4:
				return chiTietDonHang.getGiaBan();
		}
		return null;
	}

	public void resetDanhSachChiTietDonHang(ArrayList<ChiTietDonHang> ds) {
		this.dsChiTietDonHang.clear();
		this.dsChiTietDonHang.addAll(ds);
		this.fireTableDataChanged();
	}

	public void them(ChiTietDonHang chiTietDonHang) {
		this.dsChiTietDonHang.add(chiTietDonHang);
		this.fireTableDataChanged();
	}

	public void sua(ChiTietDonHang chiTietDonHang) {
		for (int i = 0; i < this.dsChiTietDonHang.size(); i++) {
			if (this.dsChiTietDonHang.get(i).getMaChiTietDonHang().equals(chiTietDonHang.getMaChiTietDonHang())) {
				this.dsChiTietDonHang.set(i, chiTietDonHang);
			}
		}
		this.fireTableDataChanged();
	}

	public void xoa(ChiTietDonHang chiTietDonHang) {
		this.dsChiTietDonHang.remove(chiTietDonHang);
		this.fireTableDataChanged();
	}

	public void hienThiKetQuaTimKiemTheoMaChiTietDonHang(ChiTietDonHang chiTietDonHang) {
		this.dsChiTietDonHang.clear();
		this.dsChiTietDonHang.add(chiTietDonHang);
		this.fireTableDataChanged();
	}

}
