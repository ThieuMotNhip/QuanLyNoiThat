package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLKhachHangView;

public class QLKhachHangController implements ActionListener, MouseListener{
	private QLKhachHangView qlKhachHangView;
	

	public QLKhachHangController(QLKhachHangView qlKhachHangView) {
		super();
		this.qlKhachHangView = qlKhachHangView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlKhachHangView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlKhachHangView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlKhachHangView.them();
		}else if (button.equals("Sửa")) {
			this.qlKhachHangView.sua();
		}else if (button.equals("Xóa")) {
			this.qlKhachHangView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlKhachHangView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlKhachHangView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlKhachHangView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlKhachHangView.layThongTin();
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
