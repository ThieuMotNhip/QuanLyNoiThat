package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLUserView;

public class QLUserController implements ActionListener, MouseListener{
	private QLUserView qlUserView;
	

	public QLUserController(QLUserView qlUserView) {
		super();
		this.qlUserView = qlUserView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlUserView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlUserView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlUserView.them();
		}else if (button.equals("Sửa")) {
			this.qlUserView.sua();
		}else if (button.equals("Xóa")) {
			this.qlUserView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlUserView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlUserView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlUserView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlUserView.layThongTin();
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
