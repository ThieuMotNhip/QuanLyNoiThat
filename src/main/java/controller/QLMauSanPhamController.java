package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLMauSanPhamView;

public class QLMauSanPhamController implements ActionListener, MouseListener{
	private QLMauSanPhamView qlMauSanPhamView;
	

	public QLMauSanPhamController(QLMauSanPhamView qlMauSanPhamView) {
		super();
		this.qlMauSanPhamView = qlMauSanPhamView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlMauSanPhamView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlMauSanPhamView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlMauSanPhamView.them();
		}else if (button.equals("Sửa")) {
			this.qlMauSanPhamView.sua();
		}else if (button.equals("Xóa")) {
			this.qlMauSanPhamView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlMauSanPhamView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlMauSanPhamView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlMauSanPhamView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlMauSanPhamView.layThongTin();
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
