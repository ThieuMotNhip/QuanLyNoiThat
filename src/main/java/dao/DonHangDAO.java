package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.DanhMucSanPham;
import model.DonHang;

public class DonHangDAO implements DAOInterface<DonHang>{
	
	public static DonHangDAO getInstance() {
		return new DonHangDAO();
	}

	@Override
	public int insert(DonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO donhang(maDonHang, maKhachHang, ngayDatHang, trangThai, tongGiaTriDonHang, soTienKhachHangDaDatCoc)"+
						" VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
			pst.setString(2, t.getMaKhachHang());
			pst.setDate(3, t.getNgayDatHang());
			pst.setString(4, t.getTrangThai());
			pst.setDouble(5, t.getTongGiaTriDonHang());
			pst.setDouble(6, t.getSoTienKhachHangDaDatCoc());
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
	public int update(DonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE donhang"+
						" SET (maKhachHang=?, ngayDatHang=?, trangThai=?, tongGiaTriDonHang=?, soTienKhachHangDaDatCoc=?)"+
						" WHERE (maDonHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getMaKhachHang());
			pst.setDate(2, t.getNgayDatHang());
			pst.setString(3, t.getTrangThai());
			pst.setDouble(4, t.getTongGiaTriDonHang());
			pst.setDouble(5, t.getSoTienKhachHangDaDatCoc());
			pst.setString(6, t.getMaDonHang());
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
	public int delete(DonHang t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM donhang"+
						" WHERE (maDonHang=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDonHang());
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
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> kq = new ArrayList<DonHang>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM donhang";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maDonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				Date ngayDatHang = rs.getDate("ngayDatHang");
				String trangThai = rs.getString("trangThai");
				double tongGiaTriDonHang = rs.getDouble("tongGiaTriDonHang");
				double soTienKhachHangDaDatCoc = rs.getDouble("soTienKhachHangDaDatCoc");
				DonHang donHang = new DonHang(maDonHang, maKhachHang, ngayDatHang, trangThai, tongGiaTriDonHang, soTienKhachHangDaDatCoc);
				kq.add(donHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
