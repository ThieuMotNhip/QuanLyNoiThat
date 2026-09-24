package dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
	//Phương thức thêm
	public int insert(T t);
	
	//Phương thức sửa
	public int update(T t);
	
	//Phương thức xóa
	public int delete(T t);
	
	//Phương thức lấy toàn bộ danh sách
	public ArrayList<T> selectAll();
}
