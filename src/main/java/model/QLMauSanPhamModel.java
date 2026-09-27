package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLMauSanPhamModel extends AbstractTableModel{
	private ArrayList<MauSanPham> dsMauSanPham;
	private String[] tenCacCot;
	
	public QLMauSanPhamModel() {
		this.dsMauSanPham = new ArrayList<MauSanPham>();
		this.tenCacCot = new String[] {"Mã sản phẩm gốc", "Mã danh mục", "Tên sản phẩm", "Giá bán cơ bản", "Mô tả chi tiết"};
	}
	
	

	public ArrayList<MauSanPham> getDsMauSanPham() {
		return dsMauSanPham;
	}



	public void setDsMauSanPham(ArrayList<MauSanPham> dsMauSanPham) {
		this.dsMauSanPham = dsMauSanPham;
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
		return this.dsMauSanPham.size();
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
		MauSanPham mauSanPham = this.dsMauSanPham.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return mauSanPham.getMaSanPhamGoc();
			case 1: 
				return mauSanPham.getMaDanhMuc();
			case 2:
				return mauSanPham.getTenSanPham();
			case 3:
				return mauSanPham.getGiaBanCoBan();
			case 4:
				return mauSanPham.getMoTaChiTiet();
		}
		return null;
	}

	public void resetDanhSachMauSanPham(ArrayList<MauSanPham> ds) {
		this.dsMauSanPham.clear();
		this.dsMauSanPham.addAll(ds);
		this.fireTableDataChanged();
	}

	public void hienThiKetQuaTimKiemTheoMaSanPhamGoc(MauSanPham mauSanPham) {
		this.dsMauSanPham.clear();
		this.dsMauSanPham.add(mauSanPham);
		this.fireTableDataChanged();
	}

}
