package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class QLUserModel extends AbstractTableModel{
	private ArrayList<User> dsUser;
	private String[] tenCacCot;
	
	public QLUserModel() {
		this.dsUser = new ArrayList<User>();
		this.tenCacCot = new String[] {"Username", "Password", "Role"};
	}
	
	

	public ArrayList<User> getDsUser() {
		return dsUser;
	}



	public void setDsUser(ArrayList<User> dsUser) {
		this.dsUser = dsUser;
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
		return this.dsUser.size();
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
		User user = this.dsUser.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return user.getUsername();
			case 1:
				return user.getPassword();
			case 2:
				return user.getRole();
		}
		return null;
	}

	public void resetDanhSachUser(ArrayList<User> ds) {
		this.dsUser.clear();
		this.dsUser.addAll(ds);
		this.fireTableDataChanged();
	}



	public void hienThiKetQuaTimKiemTheoUsername(User user) {
		this.dsUser.clear();
		this.dsUser.add(user);
		this.fireTableDataChanged();
	}

}
