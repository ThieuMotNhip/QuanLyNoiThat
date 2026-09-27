package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLSanPhamBienTheModel extends AbstractTableModel{
	private ArrayList<SanPhamBienThe> dsSanPhamBienThe;
	private String[] tenCacCot;
	
	public QLSanPhamBienTheModel() {
		this.dsSanPhamBienThe = new ArrayList<SanPhamBienThe>();
		this.tenCacCot = new String[] {"Mã sản phẩm biến thể", "Mã sản phẩm gốc", "Mã định danh lưu kho", "Màu sắc", "Chất liệu", "Kích thước", "Giá bán chính xác", "Số lượng tồn kho"};
	}
	
	

	public ArrayList<SanPhamBienThe> getDsSanPhamBienThe() {
		return dsSanPhamBienThe;
	}



	public void setDsSanPhamBienThe(ArrayList<SanPhamBienThe> dsSanPhamBienThe) {
		this.dsSanPhamBienThe = dsSanPhamBienThe;
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
		return this.dsSanPhamBienThe.size();
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
		SanPhamBienThe sanPhamBienThe = this.dsSanPhamBienThe.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return sanPhamBienThe.getMaSanPhamBienThe();
			case 1: 
				return sanPhamBienThe.getMaSanPhamGoc();
			case 2:
				return sanPhamBienThe.getMaDinhDanhLuuKho();
			case 3:
				return sanPhamBienThe.getMauSac();
			case 4:
				return sanPhamBienThe.getChatLieu();
			case 5:
				return sanPhamBienThe.getKichThuoc();
			case 6:
				return sanPhamBienThe.getGiaBanChinhXac();
			case 7:
				return sanPhamBienThe.getSoLuongTonKho();
		}
		return null;
	}



	public void resetDanhSachSanPhamBienThe(ArrayList<SanPhamBienThe> ds) {
		this.dsSanPhamBienThe.clear();
		this.dsSanPhamBienThe.addAll(ds);
		this.fireTableDataChanged();
	}



	public void hienThiKetQuaTimKiemTheoMaSanPhamBienThe(SanPhamBienThe sanPhamBienThe) {
		this.dsSanPhamBienThe.clear();
		this.dsSanPhamBienThe.add(sanPhamBienThe);
		this.fireTableDataChanged();
	}

}
