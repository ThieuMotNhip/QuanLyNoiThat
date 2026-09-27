package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLDonHangModel extends AbstractTableModel{
	private ArrayList<DonHang> dsDonHang;
	private String[] tenCacCot;
	
	public QLDonHangModel() {
		this.dsDonHang = new ArrayList<DonHang>();
		this.tenCacCot = new String[] {"Mã đơn hàng", "Mã khách hàng", "Ngày đặt hàng", "Trạng thái", "Tổng giá trị đơn hàng", "Số tiền khách đã đặt cọc"};
	}
	
	

	public ArrayList<DonHang> getDsDonHang() {
		return dsDonHang;
	}



	public void setDsDonHang(ArrayList<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
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
		return this.dsDonHang.size();
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
		DonHang donHang = this.dsDonHang.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return donHang.getMaDonHang();
			case 1:
				return donHang.getMaKhachHang();
			case 2:
				return donHang.getNgayDatHang();
			case 3: 
				return donHang.getTrangThai();
			case 4: 
				return donHang.getTongGiaTriDonHang();
			case 5:
				return donHang.getSoTienKhachHangDaDatCoc();
		}
		return null;
	}



	public void resetDanhSachDonHang(ArrayList<DonHang> ds) {
		this.dsDonHang.clear();
		this.dsDonHang.addAll(ds);
		this.fireTableDataChanged();
	}



	public void hienThiKetQuaTimKiemTheoMaDonHang(DonHang donHang) {
		this.dsDonHang.clear();
		this.dsDonHang.add(donHang);
		this.fireTableDataChanged();
	}

}
