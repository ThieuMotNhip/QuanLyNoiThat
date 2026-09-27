package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLDonHangView;

public class QLDonHangController implements ActionListener, MouseListener{
	private QLDonHangView qlDonHangView;
	

	public QLDonHangController(QLDonHangView qlDonHangView) {
		super();
		this.qlDonHangView = qlDonHangView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlDonHangView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlDonHangView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlDonHangView.them();
		}else if (button.equals("Sửa")) {
			this.qlDonHangView.sua();
		}else if (button.equals("Xóa")) {
			this.qlDonHangView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlDonHangView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlDonHangView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlDonHangView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlDonHangView.layThongTin();
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
