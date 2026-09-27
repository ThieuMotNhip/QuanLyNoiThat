package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLDanhMucSanPhamModel extends AbstractTableModel{
	private ArrayList<DanhMucSanPham> dsDanhMucSanPham;
	private String[] tenCacCot;
	
	public QLDanhMucSanPhamModel() {
		this.dsDanhMucSanPham = new ArrayList<DanhMucSanPham>();
		this.tenCacCot = new String[] {"Mã danh mục", "Tên danh mục", "Mô tả"};
	}
	
	

	public ArrayList<DanhMucSanPham> getDsDanhMucSanPham() {
		return dsDanhMucSanPham;
	}



	public void setDsDanhMucSanPham(ArrayList<DanhMucSanPham> dsDanhMucSanPham) {
		this.dsDanhMucSanPham = dsDanhMucSanPham;
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
		return this.dsDanhMucSanPham.size();
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
		DanhMucSanPham danhMucSanPham = this.dsDanhMucSanPham.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return danhMucSanPham.getMaDanhMuc();
			case 1:
				return danhMucSanPham.getTenDanhMuc();
			case 2:
				return danhMucSanPham.getMoTa();
		}
		return null;
	}

	public void resetDanhSachDanhMucSanPham(ArrayList<DanhMucSanPham> ds) {
		this.dsDanhMucSanPham.clear();
		this.dsDanhMucSanPham.addAll(ds);
		this.fireTableDataChanged();
	}

	public void them(DanhMucSanPham danhMucSanPham) {
		this.dsDanhMucSanPham.add(danhMucSanPham);
		this.fireTableDataChanged();
	}

	public void sua(DanhMucSanPham danhMucSanPham) {
		for (int i = 0; i < this.dsDanhMucSanPham.size(); i++) {
			if (this.dsDanhMucSanPham.get(i).getMaDanhMuc().equals(danhMucSanPham.getMaDanhMuc())) {
				this.dsDanhMucSanPham.set(i, danhMucSanPham);
			}
		}
		this.fireTableDataChanged();
	}

	public void xoa(DanhMucSanPham danhMucSanPham) {
		this.dsDanhMucSanPham.remove(danhMucSanPham);
		this.fireTableDataChanged();
	}

	public void hienThiKetQuaTimKiemTheoMaDanhMuc(DanhMucSanPham danhMucSanPham) {
		this.dsDanhMucSanPham.clear();
		this.dsDanhMucSanPham.add(danhMucSanPham);
		this.fireTableDataChanged();
	}

}
