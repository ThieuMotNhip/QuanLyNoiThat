package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BoSanPham;
import model.ChiTietDonHang;

public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	
	public static ChiTietDonHangDAO getInstance() {
		return new ChiTietDonHangDAO();
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO chitietdonhang(maChiTietDonHang, maDonHang, maSanPhamBienThe, soLuong, giaBan)"+
						" VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaChiTietDonHang());
			pst.setString(2, t.getMaDonHang());
			pst.setString(3, t.getMaSanPhamBienThe());
			pst.setInt(4, t.getSoLuong());
			pst.setDouble(5, t.getGiaBan());
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
	public int update(ChiTietDonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE chitietdonhang"+
						" SET (maDonHang=?, maSanPhamBienThe=?, soLuong=?, giaBan=?)"+
						" WHERE (maChiTietDonHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
			pst.setString(2, t.getMaSanPhamBienThe());
			pst.setInt(3, t.getSoLuong());
			pst.setDouble(4, t.getGiaBan());
			pst.setString(5, t.getMaChiTietDonHang());
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
	public int delete(ChiTietDonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM chitietdonhang"+
						" WHERE (maChiTietDonHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaChiTietDonHang());
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
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> kq = new ArrayList<ChiTietDonHang>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM chitietdonhang";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maChiTietDonHang = rs.getString("maChiTietDonHang");
				String maHoaDon = rs.getString("maHoaDon");
				String maSanPhamBienThe = rs.getString("maSanPhamBienThe");
				int soLuong = rs.getInt("soLuong");
				double giaBan = rs.getDouble("giaBan");
				ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, maChiTietDonHang, maSanPhamBienThe, soLuong, giaBan);
				kq.add(chiTietDonHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
