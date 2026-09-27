package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.QuanLyNoiThatView;

public class QuanLyNoiThatController implements ActionListener{
	private QuanLyNoiThatView quanLyNoiThatView;
	

	public QuanLyNoiThatController(QuanLyNoiThatView quanLyNoiThatView) {
		super();
		this.quanLyNoiThatView = quanLyNoiThatView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tổng quan")) {
			this.quanLyNoiThatView.capNhatDuLieu();
		}else if (button.equals("User")) {
			this.quanLyNoiThatView.sangQLUser();
		}else if (button.equals("Mẫu sản phẩm")) {
			this.quanLyNoiThatView.sangQLMauSanPham();
		}else if (button.equals("Sản phẩm biến thể")) {
			this.quanLyNoiThatView.sangQLSanPhamBienThe();
		}else if (button.equals("Danh mục sản phẩm")) {
			this.quanLyNoiThatView.sangQLDanhMucSanPham();
		}else if (button.equals("Bộ sản phẩm")) {
			this.quanLyNoiThatView.sangQLBoSanPham();
		}else if (button.equals("Chi tiết đơn hàng")) {
			this.quanLyNoiThatView.sangQLChiTietDonHang();
		}else if (button.equals("Khách hàng")) {
			this.quanLyNoiThatView.sangQLKhachHang();
		}else if (button.equals("Đơn hàng")) {
			this.quanLyNoiThatView.sangQLDonHang();
		}else if (button.equals("Đăng xuất")) {
			this.quanLyNoiThatView.DangXuat();
		}else if (button.equals("Thoát")) {
			this.quanLyNoiThatView.Thoat();
		}
	}

}
