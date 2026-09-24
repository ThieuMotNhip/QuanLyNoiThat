package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.SanPhamBienThe;
import model.User;

public class UserDAO implements DAOInterface<User>{
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO user(username, password, role)"+
						" VALUES (?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());
			pst.setString(3, t.getRole());
			//B3: Thực thi câu lệnh sql
			kq = pst.executeUpdate();
			//B4: Xử lý kết quả
			System.out.println("Câu lệnh sql đã thực thi: "+sql);
			System.out.println("Số dòng bị thay đổi: "+kq);
			//B5: Hủy kết nối tới cơ sở dữ liệu
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(User t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE user"+
						" SET (password=?, role=?)"+
						" WHERE (username=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getRole());
			pst.setString(3, t.getUsername());
			//B3: Thực thi câu lệnh sql
			kq = pst.executeUpdate();
			//B4: Xử lý kết quả
			System.out.println("Câu lệnh sql đã thực thi: "+sql);
			System.out.println("Số dòng bị thay đổi: "+kq);
			//B5: Hủy kết nối tới cơ sở dữ liệu
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(User t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM user"+
						" WHERE (username=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			//B3: Thực thi câu lệnh sql
			kq = pst.executeUpdate();
			//B4: Xử lý kết quả
			System.out.println("Câu lệnh sql đã thực thi: "+sql);
			System.out.println("Số dòng bị thay đổi: "+kq);
			//B5: Hủy kết nối tới cơ sở dữ liệu
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> kq = new ArrayList<User>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM user";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String role = rs.getString("role");
				User user = new User(username, password, role);
				kq.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}
	

}
