package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLDanhMucSanPhamView;

public class QLDanhMucSanPhamController implements ActionListener, MouseListener{
	private QLDanhMucSanPhamView qlDanhMucSanPhamView;
	

	public QLDanhMucSanPhamController(QLDanhMucSanPhamView qlDanhMucSanPhamView) {
		super();
		this.qlDanhMucSanPhamView = qlDanhMucSanPhamView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlDanhMucSanPhamView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlDanhMucSanPhamView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlDanhMucSanPhamView.them();
		}else if (button.equals("Sửa")) {
			this.qlDanhMucSanPhamView.sua();
		}else if (button.equals("Xóa")) {
			this.qlDanhMucSanPhamView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlDanhMucSanPhamView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlDanhMucSanPhamView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlDanhMucSanPhamView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlDanhMucSanPhamView.layThongTin();
		}
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
