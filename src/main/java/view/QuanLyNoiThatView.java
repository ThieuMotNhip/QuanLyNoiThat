package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QuanLyNoiThatController;
import dao.BoSanPhamDAO;
import dao.ChiTietDonHangDAO;
import dao.DanhMucSanPhamDAO;
import dao.DonHangDAO;
import dao.KhachHangDAO;
import dao.MauSanPhamDAO;
import dao.SanPhamBienTheDAO;
import dao.UserDAO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.SwingConstants;

public class QuanLyNoiThatView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea jTextArea_ThongKeUser;
	private JTextArea jTextArea_ThongKeKhachHang;
	private JTextArea jextArea_ThongKeDonHang;
	private JTextArea jTextArea_ThongKeMauSanPham;
	private JTextArea jTextArea_ThongKeSanPhamBienThe;
	private JTextArea jTextArea_ThongKeDanhMucSanPham;
	private JTextArea jTextArea_ThongKeBoSanPham;
	private JTextArea jTextArea_ThongKeChiTietDonHang;
	private JTextArea jTextArea_ThongKeThuNhap;

	public QuanLyNoiThatView() {
		this.init();

	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Quản lý nội thất - Thiếu Một Nhịp");
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Controller
		QuanLyNoiThatController quanLyNoiThatController = new QuanLyNoiThatController(this);
		
		
		JLabel jLabel_Text1 = new JLabel("QUẢN LÝ NỘI THẤT - THIẾU MỘT NHỊP");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(301, 0, 306, 40);
		contentPane.add(jLabel_Text1);
		
		
		//Thanh menu
		JMenuBar jMenuBar_ThanhMenu = new JMenuBar();
		jMenuBar_ThanhMenu.setBounds(850, 0, 150, 40);
		
		JMenu jMenu_Admin = new JMenu("Admin");
		jMenu_Admin.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jMenu_Admin.setBounds(634, 0, 150, 40);
		jMenuBar_ThanhMenu.add(jMenu_Admin);
		
		JMenuItem jMenuItem_HoSo = new JMenuItem("Hồ sơ");
		jMenuItem_HoSo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jMenu_Admin.add(jMenuItem_HoSo);
		jMenuItem_HoSo.addActionListener(quanLyNoiThatController);
		
		JMenuItem jMenuItem_DangXuat = new JMenuItem("Đăng xuất");
		jMenuItem_DangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jMenu_Admin.add(jMenuItem_DangXuat);
		jMenuItem_DangXuat.addActionListener(quanLyNoiThatController);
		
		JMenuItem jMenuItem_Thoat = new JMenuItem("Thoát");
		jMenuItem_Thoat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jMenu_Admin.add(jMenuItem_Thoat);
		jMenuItem_Thoat.addActionListener(quanLyNoiThatController);
		
		this.setJMenuBar(jMenuBar_ThanhMenu);
		
		
		//Phần chức năng
		Panel jPanel_ChucNang = new Panel();
		jPanel_ChucNang.setBackground(new Color(255, 255, 255));
		jPanel_ChucNang.setBounds(10, 40, 150, 601);
		contentPane.add(jPanel_ChucNang);
		jPanel_ChucNang.setLayout(null);
		
		JButton jButton_TongQuan = new JButton("Tổng quan");
		jButton_TongQuan.setBounds(0, 10, 150, 50);
		jPanel_ChucNang.add(jButton_TongQuan);
		jButton_TongQuan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_TongQuan.addActionListener(quanLyNoiThatController);
		
		JButton jButton_User = new JButton("User");
		jButton_User.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_User.setBounds(0, 71, 150, 50);
		jPanel_ChucNang.add(jButton_User);
		jButton_User.addActionListener(quanLyNoiThatController);
		
		JButton jButton_KhachHang = new JButton("Khách hàng");
		jButton_KhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_KhachHang.setBounds(0, 132, 150, 50);
		jPanel_ChucNang.add(jButton_KhachHang);
		jButton_KhachHang.addActionListener(quanLyNoiThatController);
		
		JButton jButton_DonHang = new JButton("Đơn hàng");
		jButton_DonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_DonHang.setBounds(0, 193, 150, 50);
		jPanel_ChucNang.add(jButton_DonHang);
		jButton_DonHang.addActionListener(quanLyNoiThatController);
		
		JButton jButton_MauSanPham = new JButton("Mẫu sản phẩm");
		jButton_MauSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_MauSanPham.setBounds(0, 254, 150, 50);
		jPanel_ChucNang.add(jButton_MauSanPham);
		jButton_MauSanPham.addActionListener(quanLyNoiThatController);
		
		JButton jButton_SanPhamBienThe = new JButton("Sản phẩm biến thể");
		jButton_SanPhamBienThe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_SanPhamBienThe.setBounds(0, 315, 150, 50);
		jPanel_ChucNang.add(jButton_SanPhamBienThe);
		jButton_SanPhamBienThe.addActionListener(quanLyNoiThatController);
		
		JButton jButton_DanhMucSanPham = new JButton("Danh mục sản phẩm");
		jButton_DanhMucSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_DanhMucSanPham.setBounds(0, 376, 150, 50);
		jPanel_ChucNang.add(jButton_DanhMucSanPham);
		jButton_DanhMucSanPham.addActionListener(quanLyNoiThatController);
		
		JButton jButton_BoSanPham = new JButton("Bộ sản phẩm");
		jButton_BoSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_BoSanPham.setBounds(0, 437, 150, 50);
		jPanel_ChucNang.add(jButton_BoSanPham);
		jButton_BoSanPham.addActionListener(quanLyNoiThatController);
		
		JButton jButton_ChiTietDonHang = new JButton("Chi tiết đơn hàng");
		jButton_ChiTietDonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_ChiTietDonHang.setBounds(0, 498, 150, 50);
		jPanel_ChucNang.add(jButton_ChiTietDonHang);
		jButton_ChiTietDonHang.addActionListener(quanLyNoiThatController);
		
		
		
		//Phần thống kê
		JPanel jPanel_ThongKe = new JPanel();
		jPanel_ThongKe.setBackground(new Color(128, 255, 255));
		jPanel_ThongKe.setBounds(166, 40, 808, 223);
		contentPane.add(jPanel_ThongKe);
		jPanel_ThongKe.setLayout(null);
		
		jTextArea_ThongKeUser = new JTextArea("Số lượng user:\r\n");
		jTextArea_ThongKeUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeUser.setBounds(10, 11, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeUser);
		
		jTextArea_ThongKeKhachHang = new JTextArea("Số lượng khách hàng:");
		jTextArea_ThongKeKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeKhachHang.setBounds(310, 11, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeKhachHang);
		
		jextArea_ThongKeDonHang = new JTextArea("Số lượng đơn hàng:");
		jextArea_ThongKeDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jextArea_ThongKeDonHang.setBounds(598, 11, 200, 60);
		jPanel_ThongKe.add(jextArea_ThongKeDonHang);
		
		jTextArea_ThongKeMauSanPham = new JTextArea("Số lượng mẫu sản phẩm:");
		jTextArea_ThongKeMauSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeMauSanPham.setBounds(10, 86, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeMauSanPham);
		
		jTextArea_ThongKeSanPhamBienThe = new JTextArea("Số lượng sản phẩm biến thể:\r\n");
		jTextArea_ThongKeSanPhamBienThe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeSanPhamBienThe.setBounds(310, 82, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeSanPhamBienThe);
		
		jTextArea_ThongKeDanhMucSanPham = new JTextArea("Số lượng danh mục sản phẩm");
		jTextArea_ThongKeDanhMucSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeDanhMucSanPham.setBounds(598, 82, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeDanhMucSanPham);
		
		jTextArea_ThongKeBoSanPham = new JTextArea("Số lượng bộ sản phẩm:");
		jTextArea_ThongKeBoSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeBoSanPham.setBounds(10, 152, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeBoSanPham);
		
		jTextArea_ThongKeChiTietDonHang = new JTextArea("Số lượng chi tiết đơn hàng:");
		jTextArea_ThongKeChiTietDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeChiTietDonHang.setBounds(310, 153, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeChiTietDonHang);
		
		jTextArea_ThongKeThuNhap = new JTextArea("Tổng thu nhập:");
		jTextArea_ThongKeThuNhap.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextArea_ThongKeThuNhap.setBounds(598, 153, 200, 60);
		jPanel_ThongKe.add(jTextArea_ThongKeThuNhap);
		
		
		//Phần hình ảnh
		JPanel jPanel_HinhAnh = new JPanel();
		jPanel_HinhAnh.setBounds(166, 263, 808, 361);
		contentPane.add(jPanel_HinhAnh);
		jPanel_HinhAnh.setLayout(null);
		JLabel jLabel_HinhAnh = new JLabel("",JLabel.CENTER);
		jLabel_HinhAnh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jLabel_HinhAnh.setBounds(0, 0, 809, 361);
		jLabel_HinhAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(QuanLyNoiThatView.class.getResource("ha_TBA_ND.jpg"))));
		jPanel_HinhAnh.add(jLabel_HinhAnh);
		
		this.setVisible(true);
	}

	public void capNhatDuLieu() {
		this.jTextArea_ThongKeUser.setText("Số lượng user:\r\n"+UserDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeKhachHang.setText("Số lượng khách hàng:\r\n"+KhachHangDAO.getInstance().laySoLuong());
		this.jextArea_ThongKeDonHang.setText("Số lượng đơn hàng:\r\n"+DonHangDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeMauSanPham.setText("Số lượng mẫu sản phẩm:\r\n"+MauSanPhamDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeSanPhamBienThe.setText("Số lượng sản phẩm biến thể:\r\n"+SanPhamBienTheDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeDanhMucSanPham.setText("Số lượng danh mục sản phẩm:\r\n"+DanhMucSanPhamDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeBoSanPham.setText("Số lượng bộ sản phẩm:\r\n"+BoSanPhamDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeChiTietDonHang.setText("Số lượng chi tiết đơn hàng:\r\n"+ChiTietDonHangDAO.getInstance().laySoLuong());
		this.jTextArea_ThongKeThuNhap.setText("Tổng thu nhập:\r\n"+DonHangDAO.getInstance().tinhTongThuNhap());
	}

	public void sangQLUser() {
		this.setVisible(false);
		new QLUserView(this);
	}

	public void sangQLMauSanPham() {
		this.setVisible(false);
		new QLMauSanPhamView(this);
	}

	public void sangQLSanPhamBienThe() {
		this.setVisible(false);
		new QLSanPhamBienTheView(this);
	}

	public void sangQLDanhMucSanPham() {
		this.setVisible(false);
		new QLDanhMucSanPhamView(this);
	}

	public void sangQLBoSanPham() {
		this.setVisible(false);
		new QLBoSanPhamView(this);
	}

	public void sangQLDonHang() {
		this.setVisible(false);
		new QLDonHangView(this);
	}

	public void DangXuat() {
		new LoginView();
		this.dispose();
		
	}

	public void Thoat() {
		System.exit(0);
	}

	public void sangQLKhachHang() {
		this.setVisible(false);
		new QLKhachHangView(this);
	}

	public void sangQLChiTietDonHang() {
		this.setVisible(false);
		new QLChiTietDonHangView(this);
	}
	
	
}
