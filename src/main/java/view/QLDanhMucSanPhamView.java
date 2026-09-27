package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.QLDanhMucSanPhamController;
import dao.ChiTietDonHangDAO;
import dao.DanhMucSanPhamDAO;
import model.DanhMucSanPham;
import model.QLDanhMucSanPhamModel;

public class QLDanhMucSanPhamView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView qlLyNoiThatView;
	private JPanel contentPane;
	private QLDanhMucSanPhamModel qlDanhMucSanPhamModel;
	private JTextField jTextField_MaDanhMucTimKiem;
	private JTextField jTextField_MaDanhMuc;
	private JTextField jTextField_TenDanhMuc;
	private JTextField jTextField_MoTa;
	private JTable jTable_DSDanhMucSanPham;
	
	public QLDanhMucSanPhamView(QuanLyNoiThatView qlLyNoiThatView) {
		this.qlLyNoiThatView = qlLyNoiThatView;
		this.qlDanhMucSanPhamModel = new QLDanhMucSanPhamModel();
		this.init();
	}
	
	private void init() {
		setTitle("Quản lý chi tiết đơn hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Controller
		QLDanhMucSanPhamController qlDanhMucSanPhamController = new QLDanhMucSanPhamController(this);
		
		//Thanh menu
		JMenuBar jMenuBar_ThanhMenu = new JMenuBar();
		jMenuBar_ThanhMenu.setBounds(0, 0, 101, 22);
		contentPane.add(jMenuBar_ThanhMenu);
		JMenu jMenu_File = new JMenu("File");
		jMenu_File.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenuBar_ThanhMenu.add(jMenu_File);
		
		JMenuItem JMenuItem_Open = new JMenuItem("Open");
		JMenuItem_Open.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenu_File.add(JMenuItem_Open);
		
		JMenuItem jMenuItem_Save = new JMenuItem("Save");
		jMenuItem_Save.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenu_File.add(jMenuItem_Save);
		
		JMenuItem jMenuItem_Exit = new JMenuItem("Exit");
		jMenuItem_Exit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenu_File.add(jMenuItem_Exit);
		
		JMenu jMenu_About = new JMenu("About");
		jMenu_About.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenuBar_ThanhMenu.add(jMenu_About);
		
		JMenuItem jMenuItem_AboutMe = new JMenuItem("About me");
		jMenuItem_AboutMe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jMenu_About.add(jMenuItem_AboutMe);
		
		
		//Phần tìm kiếm
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM DANH MỤC SẢN PHẨM");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(365, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaDanhMucTimKiem = new JLabel("Mã danh mục:");
		jLabel_MaDanhMucTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaDanhMucTimKiem.setBounds(97, 33, 143, 31);
		contentPane.add(jLabel_MaDanhMucTimKiem);
		
		jTextField_MaDanhMucTimKiem = new JTextField();
		jTextField_MaDanhMucTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDanhMucTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaDanhMucTimKiem);
		jTextField_MaDanhMucTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlDanhMucSanPhamController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH DANH MỤC SẢN PHẨM");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(348, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSDanhMucSanPham = new JTable(this.qlDanhMucSanPhamModel);
		jTable_DSDanhMucSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSDanhMucSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSDanhMucSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSDanhMucSanPham.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSDanhMucSanPham);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSDanhMucSanPham.addMouseListener(qlDanhMucSanPhamController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN DANH MỤC SẢN PHẨM");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(334, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		JLabel jLable_MaDanhMuc = new JLabel("Mã danh mục:");
		jLable_MaDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDanhMuc.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaDanhMuc);
		
		jTextField_MaDanhMuc = new JTextField();
		jTextField_MaDanhMuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDanhMuc.setColumns(10);
		jTextField_MaDanhMuc.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaDanhMuc);
		
		JLabel jLable_TenDanhMuc = new JLabel("Tên danh mục:");
		jLable_TenDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_TenDanhMuc.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_TenDanhMuc);
		
		jTextField_TenDanhMuc = new JTextField();
		jTextField_TenDanhMuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_TenDanhMuc.setColumns(10);
		jTextField_TenDanhMuc.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_TenDanhMuc);
		
		JLabel jLable_MoTa = new JLabel("Mô tả:");
		jLable_MoTa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MoTa.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_MoTa);
		
		jTextField_MoTa = new JTextField();
		jTextField_MoTa.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MoTa.setColumns(10);
		jTextField_MoTa.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_MoTa);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlDanhMucSanPhamController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		jButton_QuayLai.addActionListener(qlDanhMucSanPhamController);
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.qlLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<DanhMucSanPham> ds = DanhMucSanPhamDAO.getInstance().selectAll();
			this.qlDanhMucSanPhamModel.resetDanhSachDanhMucSanPham(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void them() {
		try {
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenDanhMuc = this.jTextField_TenDanhMuc.getText();
			String moTa = this.jTextField_MoTa.getText();
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham(maDanhMuc, tenDanhMuc, moTa);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DanhMucSanPhamDAO.getInstance().insert(danhMucSanPham);
				this.qlDanhMucSanPhamModel.them(danhMucSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenDanhMuc = this.jTextField_TenDanhMuc.getText();
			String moTa = this.jTextField_MoTa.getText();
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham(maDanhMuc, tenDanhMuc, moTa);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DanhMucSanPhamDAO.getInstance().update(danhMucSanPham);
				this.qlDanhMucSanPhamModel.sua(danhMucSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenDanhMuc = this.jTextField_TenDanhMuc.getText();
			String moTa = this.jTextField_MoTa.getText();
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham(maDanhMuc, tenDanhMuc, moTa);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DanhMucSanPhamDAO.getInstance().delete(danhMucSanPham);
				this.qlDanhMucSanPhamModel.xoa(danhMucSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaDanhMuc.setText("");
		this.jTextField_TenDanhMuc.setText("");
		this.jTextField_MoTa.setText("");
	}

	public void timKiem() {
		try {
			String maDanhMucTimKiem = this.jTextField_MaDanhMucTimKiem.getText();
			if (maDanhMucTimKiem.length() > 0) {
				DanhMucSanPham danhMucSanPham = DanhMucSanPhamDAO.getInstance().timKiemTheoMaDanhMuc(maDanhMucTimKiem);
				this.qlDanhMucSanPhamModel.hienThiKetQuaTimKiemTheoMaDanhMuc(danhMucSanPham);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điên mã danh mục tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSDanhMucSanPham.getSelectedRow();
		DanhMucSanPham danhMucSanPham = this.qlDanhMucSanPhamModel.getDsDanhMucSanPham().get(index);
		this.jTextField_MaDanhMuc.setText(danhMucSanPham.getMaDanhMuc());
		this.jTextField_TenDanhMuc.setText(danhMucSanPham.getTenDanhMuc());
		this.jTextField_MoTa.setText(danhMucSanPham.getMoTa());
	}

}
