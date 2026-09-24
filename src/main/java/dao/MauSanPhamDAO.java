package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.MauSanPham;

public class MauSanPhamDAO implements DAOInterface<MauSanPham>{
	
	public static MauSanPhamDAO getInstance() {
		return new MauSanPhamDAO();
	}

	@Override
	public int insert(MauSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO mausanpham(maSanPhamGoc, maDanhMuc, tenSanPham, giaBanCoBan, moTaChiTiet)"+
						" VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSanPhamGoc());
			pst.setString(2, t.getMaDanhMuc());
			pst.setString(3, t.getTenSanPham());
			pst.setDouble(4, t.getGiaBanCoBan());
			pst.setString(5, t.getMoTaChiTiet());
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
	public int update(MauSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE mausanpham"+
						" SET (maDanhMuc=?, tenSanPham=?, giaBanCoBan=?, moTaChiTiet=?"+
						" WHERE (maSanPhamGoc=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getMaDanhMuc());
			pst.setString(2, t.getTenSanPham());
			pst.setDouble(3, t.getGiaBanCoBan());
			pst.setString(4, t.getMoTaChiTiet());
			pst.setString(5, t.getMaSanPhamGoc());
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
	public int delete(MauSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM mausanpham"+
						" WHERE (maSanPhamGoc=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSanPhamGoc());
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
	public ArrayList<MauSanPham> selectAll() {
		ArrayList<MauSanPham> kq = new ArrayList<MauSanPham>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM mausanpham";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maSanPhamGoc = rs.getString("maSanPhamGoc");
				String maDanhMuc = rs.getString("maDanhMuc");
				String tenSanPham = rs.getString("tenSanPham");
				double giaBanCoBan = rs.getDouble("giaBanCoBan");
				String moTaChiTiet = rs.getString("moTaChiTiet");
				MauSanPham mauSanPham = new MauSanPham(maSanPhamGoc, maDanhMuc, tenSanPham, giaBanCoBan, moTaChiTiet);
				kq.add(mauSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
