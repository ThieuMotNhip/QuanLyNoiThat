package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BoSanPham;

public class BoSanPhamDAO implements DAOInterface<BoSanPham>{
	
	public static BoSanPhamDAO getInstance() {
		return new BoSanPhamDAO();
	}

	@Override
	public int insert(BoSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO bosanpham(maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe, soLuongMonLe)"+
						" VALUES (?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaBoSanPham());
			pst.setString(2, t.getMaDinhDanhLuuKhoCaBo());
			pst.setString(3, t.getMaDinhDanhLuuKhoMonLe());
			pst.setInt(4, t.getSoLuongMonLe());
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
	public int update(BoSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng preparedStatement
			String sql = "UPDATE bosanpham"+
						" SET (maDinhDanhLuuKhoCaBo=?, maDinhDanhLuuKhoMonLe=?, soLuongMonLe=?)"+
						" WHERE (maBoSanPham=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDinhDanhLuuKhoCaBo());
			pst.setString(2, t.getMaDinhDanhLuuKhoMonLe());
			pst.setInt(3, t.getSoLuongMonLe());
			pst.setString(4, t.getMaBoSanPham());
			//B3: Thực thi câu lệnh sql
			kq = pst.executeUpdate();
			//B4: Xử lý kết quả
			System.out.println("Số dòng bị thay đổi: "+kq);
			System.out.println("Câu lệnh sql dùng: "+sql);
			//B5: Hủy kết nối tới cở sở dữ liệu
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(BoSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng preparedStatement
			String sql = "DELETE FROM bosanpham"+
						" WHERE (maBoSanPham=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaBoSanPham());
			//B3: Thực thi câu lệnh sql
			kq = pst.executeUpdate();
			//B4: Xử lý kết quả
			System.out.println("Số dòng bị thay đổi: "+kq);
			System.out.println("Câu lệnh sql dùng: "+sql);
			//B5: Hủy kết nối tới cở sở dữ liệu
			JDBCUtil.closeConnection(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<BoSanPham> selectAll() {
		ArrayList<BoSanPham> kq = new ArrayList<BoSanPham>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM bosanpham";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maBoSanPham = rs.getString("maBoSanPham");
				String maDinhDanhLuuKhoCaBo = rs.getString("maDinhDanhLuuKhoCaBo");
				String maDinhDanhLuuKhoMonLe = rs.getString("maDinhDanhLuuKhoMonLe");
				int soLuongMonLe = rs.getInt("soLuongMonLe");
				BoSanPham boSanPham = new BoSanPham(maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe, soLuongMonLe);
				kq.add(boSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
