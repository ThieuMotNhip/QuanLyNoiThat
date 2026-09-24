package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DonHang;
import model.KhachHang;

public class KhachHangDAO implements DAOInterface<KhachHang>{
	
	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO khachhang(maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang)"+
						" VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getTenKhachHang());
			pst.setString(4, t.getSoDienThoai());
			pst.setString(5, t.getDiaChiGiaoHang());
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
	public int update(KhachHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE khachhang"+
						" SET (username=?, tenKhachHang=?, soDienThoai=?, diaChiGiaoHang=?)"+
						" WHERE (maKhachHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getTenKhachHang());
			pst.setString(3, t.getSoDienThoai());
			pst.setString(4, t.getDiaChiGiaoHang());
			pst.setString(5, t.getMaKhachHang());
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
	public int delete(KhachHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM khachhang"+
						" WHERE (maKhachHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaKhachHang());
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
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> kq = new ArrayList<KhachHang>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM khachhang";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maKhachHang = rs.getString("maKhachHang");
				String username = rs.getString("username");
				String tenKhachHang = rs.getString("tenKhachHang");
				String soDienThoai = rs.getString("soDienThoai");
				String diaChiGiaoHang = rs.getString("diaChiGiaoHang");
				KhachHang khachHang = new KhachHang(maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang);
				kq.add(khachHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
