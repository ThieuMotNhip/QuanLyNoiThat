package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLKhachHangModel extends AbstractTableModel{
	private ArrayList<KhachHang> dsKhachHang;
	private String[] tenCacCot;
	
	public QLKhachHangModel() {
		this.dsKhachHang = new ArrayList<KhachHang>();
		this.tenCacCot = new String[] {"Mã khách hàng", "Username", "Tên khách hàng", "Số điện thoại", "Địa chỉ giao hàng"};
	}

	
	
	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}



	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
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
		return this.dsKhachHang.size();
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
		KhachHang khachHang = this.dsKhachHang.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return khachHang.getMaKhachHang();
			case 1:
				return khachHang.getUsername();
			case 2:
				return khachHang.getTenKhachHang();
			case 3:
				return khachHang.getSoDienThoai();
			case 4: 
				return khachHang.getDiaChiGiaoHang();
		}
		return null;
	}



	public void resetDanhSachKhachHang(ArrayList<KhachHang> ds) {
		this.dsKhachHang.clear();
		this.dsKhachHang.addAll(ds);
		this.fireTableDataChanged();
	}



	public void hienThiKetQuaTimKiemTheoMaKhachHang(KhachHang khachHang) {
		this.dsKhachHang.clear();
		this.dsKhachHang.add(khachHang);
		this.fireTableDataChanged();
	}

}
