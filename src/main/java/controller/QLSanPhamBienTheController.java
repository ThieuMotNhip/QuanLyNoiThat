package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.QLSanPhamBienTheView;

public class QLSanPhamBienTheController implements ActionListener, MouseListener{
	private QLSanPhamBienTheView qlSanPhamBienTheView;
	

	public QLSanPhamBienTheController(QLSanPhamBienTheView qlSanPhamBienTheView) {
		super();
		this.qlSanPhamBienTheView = qlSanPhamBienTheView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Tìm kiếm")) {
			this.qlSanPhamBienTheView.timKiem();
		}else if (button.equals("Hủy tìm")) {
			this.qlSanPhamBienTheView.huyTim();
		}else if (button.equals("Thêm")) {
			this.qlSanPhamBienTheView.them();
		}else if (button.equals("Sửa")) {
			this.qlSanPhamBienTheView.sua();
		}else if (button.equals("Xóa")) {
			this.qlSanPhamBienTheView.xoa();
		}else if (button.equals("Xóa thông tin")) {
			this.qlSanPhamBienTheView.xoaThongTin();
		}else if (button.equals("Lấy toàn bộ danh sách")) {
			this.qlSanPhamBienTheView.layToanBoDanhSach();
		}else if (button.equals("Quay lại")) {
			this.qlSanPhamBienTheView.quayLai();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.qlSanPhamBienTheView.layThongTin();
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
