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

import controller.QLMauSanPhamController;
import dao.KhachHangDAO;
import dao.MauSanPhamDAO;
import model.MauSanPham;
import model.QLMauSanPhamModel;


public class QLMauSanPhamView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLMauSanPhamModel qlMauSanPhamModel;
	private JTextField jTextField_MaSanPhamGocTimKiem;
	private JTextField jTextField_MaSanPhamGoc;
	private JTextField jTextField_MaDanhMuc;
	private JTextField jTextField_TenSanPham;
	private JTable jTable_DSMauSanPham;
	private JLabel jLable_MaSanPhamGoc;
	private JTextField jTextField_GiaBanCoBan;
	private JTextField jTextField_MoTaChiTiet;
	
	public QLMauSanPhamView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlMauSanPhamModel = new QLMauSanPhamModel();
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
		QLMauSanPhamController qlMauSanPhamController = new QLMauSanPhamController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM MẪU SẢN PHẨM");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(382, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaSanPhamGocTimKiem = new JLabel("Mã sản phẩm gốc:");
		jLabel_MaSanPhamGocTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaSanPhamGocTimKiem.setBounds(97, 33, 143, 31);
		contentPane.add(jLabel_MaSanPhamGocTimKiem);
		
		jTextField_MaSanPhamGocTimKiem = new JTextField();
		jTextField_MaSanPhamGocTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamGocTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaSanPhamGocTimKiem);
		jTextField_MaSanPhamGocTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlMauSanPhamController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlMauSanPhamController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH MẪU SẢN PHẨM");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(390, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSMauSanPham = new JTable(this.qlMauSanPhamModel);
		jTable_DSMauSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSMauSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSMauSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSMauSanPham.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSMauSanPham);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSMauSanPham.addMouseListener(qlMauSanPhamController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN MẪU SẢN PHẨM");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(370, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		jLable_MaSanPhamGoc = new JLabel("Mã sản phẩm gốc:");
		jLable_MaSanPhamGoc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaSanPhamGoc.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaSanPhamGoc);
		
		jTextField_MaSanPhamGoc = new JTextField();
		jTextField_MaSanPhamGoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamGoc.setColumns(10);
		jTextField_MaSanPhamGoc.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaSanPhamGoc);
		
		JLabel jLable_MaDanhMuc = new JLabel("Mã danh mục:");
		jLable_MaDanhMuc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDanhMuc.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_MaDanhMuc);
		
		jTextField_MaDanhMuc = new JTextField();
		jTextField_MaDanhMuc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDanhMuc.setColumns(10);
		jTextField_MaDanhMuc.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_MaDanhMuc);
		
		JLabel jLable_TenSanPham = new JLabel("Tên sản phẩm:");
		jLable_TenSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_TenSanPham.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_TenSanPham);
		
		jTextField_TenSanPham = new JTextField();
		jTextField_TenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_TenSanPham.setColumns(10);
		jTextField_TenSanPham.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_TenSanPham);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlMauSanPhamController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlMauSanPhamController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlMauSanPhamController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlMauSanPhamController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlMauSanPhamController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		
		JLabel jLable_GiaBanCoBan = new JLabel("Giá bán cơ bản:");
		jLable_GiaBanCoBan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_GiaBanCoBan.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_GiaBanCoBan);
		
		jTextField_GiaBanCoBan = new JTextField();
		jTextField_GiaBanCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_GiaBanCoBan.setColumns(10);
		jTextField_GiaBanCoBan.setBounds(712, 470, 260, 33);
		contentPane.add(jTextField_GiaBanCoBan);
		
		JLabel jLable_MoTaChiTiet = new JLabel("Mô tả chi tiết:");
		jLable_MoTaChiTiet.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MoTaChiTiet.setBounds(10, 535, 200, 31);
		contentPane.add(jLable_MoTaChiTiet);
		
		jTextField_MoTaChiTiet = new JTextField();
		jTextField_MoTaChiTiet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MoTaChiTiet.setColumns(10);
		jTextField_MoTaChiTiet.setBounds(215, 534, 260, 33);
		contentPane.add(jTextField_MoTaChiTiet);
		jButton_QuayLai.addActionListener(qlMauSanPhamController);
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<MauSanPham> ds = MauSanPhamDAO.getInstance().selectAll();
			this.qlMauSanPhamModel.resetDanhSachMauSanPham(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaSanPhamGoc.setText("");
		this.jTextField_MaDanhMuc.setText("");
		this.jTextField_TenSanPham.setText("");
		this.jTextField_GiaBanCoBan.setText("");
		this.jTextField_MoTaChiTiet.setText("");
	}

	public void them() {
		try {
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenSanPham = this.jTextField_TenSanPham.getText();
			double giaBanCoBan = Double.valueOf(this.jTextField_GiaBanCoBan.getText());
			String moTaChiTiet = this.jTextField_MoTaChiTiet.getText();
			MauSanPham mauSanPham = new MauSanPham(maSanPhamGoc, maDanhMuc, tenSanPham, giaBanCoBan, moTaChiTiet);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = MauSanPhamDAO.getInstance().insert(mauSanPham);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenSanPham = this.jTextField_TenSanPham.getText();
			double giaBanCoBan = Double.valueOf(this.jTextField_GiaBanCoBan.getText());
			String moTaChiTiet = this.jTextField_MoTaChiTiet.getText();
			MauSanPham mauSanPham = new MauSanPham(maSanPhamGoc, maDanhMuc, tenSanPham, giaBanCoBan, moTaChiTiet);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = MauSanPhamDAO.getInstance().update(mauSanPham);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDanhMuc = this.jTextField_MaDanhMuc.getText();
			String tenSanPham = this.jTextField_TenSanPham.getText();
			double giaBanCoBan = Double.valueOf(this.jTextField_GiaBanCoBan.getText());
			String moTaChiTiet = this.jTextField_MoTaChiTiet.getText();
			MauSanPham mauSanPham = new MauSanPham(maSanPhamGoc, maDanhMuc, tenSanPham, giaBanCoBan, moTaChiTiet);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = MauSanPhamDAO.getInstance().delete(mauSanPham);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		try {
			String maSanPhamGocTimKiem = this.jTextField_MaSanPhamGocTimKiem.getText();
			if (maSanPhamGocTimKiem.length() > 0) {
				MauSanPham mauSanPham = MauSanPhamDAO.getInstance().timKiemTheoMaSanPhamGoc(maSanPhamGocTimKiem);
				this.qlMauSanPhamModel.hienThiKetQuaTimKiemTheoMaSanPhamGoc(mauSanPham);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền mã sản phẩm gốc tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSMauSanPham.getSelectedRow();
		MauSanPham mauSanPham = this.qlMauSanPhamModel.getDsMauSanPham().get(index);
		this.jTextField_MaSanPhamGoc.setText(mauSanPham.getMaSanPhamGoc());
		this.jTextField_MaDanhMuc.setText(mauSanPham.getMaDanhMuc());
		this.jTextField_TenSanPham.setText(mauSanPham.getTenSanPham());
		this.jTextField_GiaBanCoBan.setText(mauSanPham.getGiaBanCoBan()+"");
		this.jTextField_MoTaChiTiet.setText(mauSanPham.getMoTaChiTiet());
	}
}
