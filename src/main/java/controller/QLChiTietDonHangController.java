package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLChiTietDonHangView;

public class QLChiTietDonHangController implements ActionListener, MouseListener{
	private QLChiTietDonHangView qlChiTietDonHangView;
		

	public QLChiTietDonHangController(QLChiTietDonHangView qlChiTietDonHangView) {
		super();
		this.qlChiTietDonHangView = qlChiTietDonHangView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlChiTietDonHangView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlChiTietDonHangView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlChiTietDonHangView.them();
		}else if (button.equals("Sửa")) {
			this.qlChiTietDonHangView.sua();
		}else if (button.equals("Xóa")) {
			this.qlChiTietDonHangView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlChiTietDonHangView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlChiTietDonHangView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlChiTietDonHangView.quayLai();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlChiTietDonHangView.layThongTin();
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
