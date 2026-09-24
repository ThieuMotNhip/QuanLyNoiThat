package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.MauSanPham;
import model.SanPhamBienThe;

public class SanPhamBienTheDAO implements DAOInterface<SanPhamBienThe>{
	
	public static SanPhamBienTheDAO getInstance() {
		return new SanPhamBienTheDAO();
	}

	@Override
	public int insert(SanPhamBienThe t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "INSERT INTO sanphambienthe(maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc, giaBanChinhXac, soLuongTonKho)"+
						" VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSanPhamBienThe());
			pst.setString(2, t.getMaSanPhamGoc());
			pst.setString(3, t.getMaDinhDanhLuuKho());
			pst.setString(4, t.getMaSanPhamBienThe());
			pst.setString(5, t.getChatLieu());
			pst.setString(6, t.getKichThuoc());
			pst.setDouble(7, t.getGiaBanChinhXac());
			pst.setInt(8, t.getSoLuongTonKho());
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
	public int update(SanPhamBienThe t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "UPDATE sanphambienthe"+
						" SET (maSanPhamGoc=?, maDinhDanhLuuKho=?, maSanPhamBienThe=?, chatLieu=?, kichThuoc=?, giaBanChinhXac=?, soLuongTonKho=?)"+
						" WHERE (maSanPhamBienThe=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			
			pst.setString(1, t.getMaSanPhamGoc());
			pst.setString(2, t.getMaDinhDanhLuuKho());
			pst.setString(3, t.getMaSanPhamBienThe());
			pst.setString(4, t.getChatLieu());
			pst.setString(5, t.getKichThuoc());
			pst.setDouble(6, t.getGiaBanChinhXac());
			pst.setInt(7, t.getSoLuongTonKho());
			pst.setString(8, t.getMaSanPhamBienThe());
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
	public int delete(SanPhamBienThe t) {
		int kq = 0;
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "DELETE FROM sanphambienthe"+
						" WHERE (maSanPhamBienThe=?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, t.getMaSanPhamBienThe());
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
	public ArrayList<SanPhamBienThe> selectAll() {
		ArrayList<SanPhamBienThe> kq = new ArrayList<SanPhamBienThe>();
		try {
			//B1: Tạo kết nối tới cơ sở dữ liệu
			Connection c = JDBCUtil.getConnection();
			//B2: Viết câu lệnh sql và tạo đối tượng PreparedStatement
			String sql = "SELECT * FROM sanphambienthe";
			PreparedStatement pst = c.prepareStatement(sql);
			//B3: Thực thi câu lệnh sql
			ResultSet rs = pst.executeQuery();
			//B4: Xử lý kết quả
			while (rs.next()) {
				String maSanPhamBienThe = rs.getString("maSanPhamBienThe");
				String maSanPhamGoc = rs.getString("maSanPhamGoc");
				String maDinhDanhLuuKho = rs.getString("maDinhDanhLuuKho");
				String mauSac = rs.getString("mauSac");
				String chatLieu = rs.getString("chatLieu");
				String kichThuoc = rs.getString("kichThuoc");
				double giaBanChinhXac = rs.getDouble("giaBanChinhXac");
				int soLuongTonKho = rs.getInt("soLuongTonKho");
				SanPhamBienThe sanPhamBienThe = new SanPhamBienThe(maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc, giaBanChinhXac, soLuongTonKho);
				kq.add(sanPhamBienThe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

}
