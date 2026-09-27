package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLBoSanPhamModel extends AbstractTableModel{
	private ArrayList<BoSanPham> dsBoSanPham;
	private String[] tenCacCot;
	
	public QLBoSanPhamModel() {
		this.dsBoSanPham = new ArrayList<BoSanPham>();
		this.tenCacCot = new String[] {"Mã bộ sản phẩm", "Mã định danh lưu kho cả bộ", "Mã định danh lưu kho món lẻ", "Số lượng món lẻ"};
	}
	

	public ArrayList<BoSanPham> getDsBoSanPham() {
		return dsBoSanPham;
	}


	public void setDsBoSanPham(ArrayList<BoSanPham> dsBoSanPham) {
		this.dsBoSanPham = dsBoSanPham;
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
		return this.dsBoSanPham.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return tenCacCot.length;
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.tenCacCot[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		BoSanPham boSanPham = this.dsBoSanPham.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return boSanPham.getMaBoSanPham();
			case 1:
				return boSanPham.getMaDinhDanhLuuKhoCaBo();
			case 2:
				return boSanPham.getMaDinhDanhLuuKhoMonLe();
			case 3:
				return boSanPham.getSoLuongMonLe();
		}
		return null;
	}


	public void them(BoSanPham boSanPham) {
		this.dsBoSanPham.add(boSanPham);
		this.fireTableDataChanged();
	}


	public void sua(BoSanPham boSanPham) {
		for (int i = 0; i < this.dsBoSanPham.size(); i++) {
			if (this.dsBoSanPham.get(i).getMaBoSanPham().equals(boSanPham.getMaBoSanPham())) {
				this.dsBoSanPham.set(i, boSanPham);
			}
		}
		this.fireTableDataChanged();
	}


	public void xoa(BoSanPham boSanPham) {
		this.dsBoSanPham.remove(boSanPham);
		this.fireTableDataChanged();
	}


	public void hienThiKetQuaTimKiemTheoMaBoSanPham(BoSanPham boSanPham) {
		this.dsBoSanPham.clear();
		this.dsBoSanPham.add(boSanPham);
		this.fireTableDataChanged();
	}


	public void resetLaiDanhSachBoSanPham(ArrayList<BoSanPham> ds) {
		this.dsBoSanPham.clear();
		this.dsBoSanPham.addAll(ds);
		this.fireTableDataChanged();
	}

}
