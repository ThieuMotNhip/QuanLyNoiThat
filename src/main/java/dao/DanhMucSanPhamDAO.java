package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietDonHang;
import model.DanhMucSanPham;

public class DanhMucSanPhamDAO implements DAOInterface<DanhMucSanPham>{
	
	public static DanhMucSanPhamDAO getInstance() {
		return new DanhMucSanPhamDAO();
	}

	@Override
	public int insert(DanhMucSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO danhmucsanpham(maDanhMuc, tenDanhMuc, moTa)"+
						" VALUES (?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDanhMuc());
			pst.setString(2, t.getTenDanhMuc());
			pst.setString(3, t.getMoTa());
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
	public int update(DanhMucSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE danhmucsanpham"+
						" SET (tenDanhMuc=?, moTa=?,)"+
						" WHERE (maDanhMuc=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getTenDanhMuc());
			pst.setString(2, t.getMoTa());
			pst.setString(3, t.getMaDanhMuc());
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
	public int delete(DanhMucSanPham t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM danhmucsanpham"+
						" WHERE (maDanhMuc=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaDanhMuc());
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
	public ArrayList<DanhMucSanPham> selectAll() {
		ArrayList<DanhMucSanPham> kq = new ArrayList<DanhMucSanPham>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM danhmucsanpham";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maDanhMuc = rs.getString("maDanhMuc");
				String tenDanhMuc = rs.getString("tenDanhMuc");
				String moTa = rs.getString("moTa");
				DanhMucSanPham danhMucSanPham = new DanhMucSanPham(maDanhMuc, tenDanhMuc, moTa);
				kq.add(danhMucSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
