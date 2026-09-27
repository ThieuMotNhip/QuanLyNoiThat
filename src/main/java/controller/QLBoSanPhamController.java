package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLBoSanPhamView;

public class QLBoSanPhamController implements ActionListener, MouseListener{
	private QLBoSanPhamView qlBoSanPhamView;
	
	

	public QLBoSanPhamController(QLBoSanPhamView qlBoSanPhamView) {
		super();
		this.qlBoSanPhamView = qlBoSanPhamView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlBoSanPhamView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlBoSanPhamView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlBoSanPhamView.them();
		}else if (button.equals("Sửa")) {
			this.qlBoSanPhamView.sua();
		}else if (button.equals("Xóa")) {
			this.qlBoSanPhamView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlBoSanPhamView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlBoSanPhamView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlBoSanPhamView.quayLai();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlBoSanPhamView.layThongTin();
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
