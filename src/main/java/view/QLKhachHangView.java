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

import controller.QLKhachHangController;
import dao.DonHangDAO;
import dao.KhachHangDAO;
import model.KhachHang;
import model.QLKhachHangModel;


public class QLKhachHangView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLKhachHangModel qlKhachHangModel;
	private JTextField jTextField_MaKhachHangTimKiem;
	private JTextField jTextField_MaKhachHang;
	private JTextField jTextField_Username;
	private JTextField jTextField_TenKhachHang;
	private JTable jTable_DSKhachHang;
	private JLabel jLable_MaKhachHang;
	private JTextField jTextField_SoDienThoai;
	private JTextField jTextField_DiaChiGiaoHang;
	
	public QLKhachHangView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlKhachHangModel = new QLKhachHangModel();
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
		QLKhachHangController qlKhachHangController = new QLKhachHangController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(382, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaKhachHangTimKiem = new JLabel("Mã khách hàng:");
		jLabel_MaKhachHangTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaKhachHangTimKiem.setBounds(97, 33, 143, 31);
		contentPane.add(jLabel_MaKhachHangTimKiem);
		
		jTextField_MaKhachHangTimKiem = new JTextField();
		jTextField_MaKhachHangTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaKhachHangTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaKhachHangTimKiem);
		jTextField_MaKhachHangTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlKhachHangController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlKhachHangController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH KHÁCH HÀNG");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(390, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSKhachHang = new JTable(this.qlKhachHangModel);
		jTable_DSKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSKhachHang.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSKhachHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSKhachHang.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSKhachHang);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSKhachHang.addMouseListener(qlKhachHangController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(370, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		jLable_MaKhachHang = new JLabel("Mã đơn hàng:");
		jLable_MaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaKhachHang.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaKhachHang);
		
		jTextField_MaKhachHang = new JTextField();
		jTextField_MaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaKhachHang.setColumns(10);
		jTextField_MaKhachHang.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaKhachHang);
		
		JLabel jLable_Username = new JLabel("Username:");
		jLable_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_Username.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_Username);
		
		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_Username.setColumns(10);
		jTextField_Username.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_Username);
		
		JLabel jLable_TenKhachHang = new JLabel("Tên khách hàng:");
		jLable_TenKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_TenKhachHang.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_TenKhachHang);
		
		jTextField_TenKhachHang = new JTextField();
		jTextField_TenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_TenKhachHang.setColumns(10);
		jTextField_TenKhachHang.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_TenKhachHang);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlKhachHangController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlKhachHangController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlKhachHangController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlKhachHangController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlKhachHangController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		
		JLabel jLable_SoDienThoai = new JLabel("Số điện thoại:");
		jLable_SoDienThoai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_SoDienThoai.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_SoDienThoai);
		
		jTextField_SoDienThoai = new JTextField();
		jTextField_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_SoDienThoai.setColumns(10);
		jTextField_SoDienThoai.setBounds(712, 470, 260, 33);
		contentPane.add(jTextField_SoDienThoai);
		
		JLabel jLable_DiaChiGiaoHang = new JLabel("Địa chỉ giao hàng:");
		jLable_DiaChiGiaoHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_DiaChiGiaoHang.setBounds(10, 535, 200, 31);
		contentPane.add(jLable_DiaChiGiaoHang);
		
		jTextField_DiaChiGiaoHang = new JTextField();
		jTextField_DiaChiGiaoHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_DiaChiGiaoHang.setColumns(10);
		jTextField_DiaChiGiaoHang.setBounds(215, 534, 260, 33);
		contentPane.add(jTextField_DiaChiGiaoHang);
		jButton_QuayLai.addActionListener(qlKhachHangController);
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<KhachHang> ds = KhachHangDAO.getInstance().selectAll();
			this.qlKhachHangModel.resetDanhSachKhachHang(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaKhachHang.setText("");
		this.jTextField_Username.setText("");
		this.jTextField_TenKhachHang.setText("");
		this.jTextField_SoDienThoai.setText("");
		this.jTextField_DiaChiGiaoHang.setText("");

	}

	public void them() {
		try {
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			String username = this.jTextField_Username.getText();
			String tenKhachHang = this.jTextField_TenKhachHang.getText();
			String soDienThoai = this.jTextField_SoDienThoai.getText();
			String diaChiGiaoHang = this.jTextField_DiaChiGiaoHang.getText();
			KhachHang khachHang = new KhachHang(maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = KhachHangDAO.getInstance().insert(khachHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			String username = this.jTextField_Username.getText();
			String tenKhachHang = this.jTextField_TenKhachHang.getText();
			String soDienThoai = this.jTextField_SoDienThoai.getText();
			String diaChiGiaoHang = this.jTextField_DiaChiGiaoHang.getText();
			KhachHang khachHang = new KhachHang(maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = KhachHangDAO.getInstance().update(khachHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			String username = this.jTextField_Username.getText();
			String tenKhachHang = this.jTextField_TenKhachHang.getText();
			String soDienThoai = this.jTextField_SoDienThoai.getText();
			String diaChiGiaoHang = this.jTextField_DiaChiGiaoHang.getText();
			KhachHang khachHang = new KhachHang(maKhachHang, username, tenKhachHang, soDienThoai, diaChiGiaoHang);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = KhachHangDAO.getInstance().delete(khachHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		try {
			String maKhachHangTimKiem = this.jTextField_MaKhachHangTimKiem.getText();
			if (maKhachHangTimKiem.length() > 0) {
				KhachHang khachHang = KhachHangDAO.getInstance().timKiemTheoMaKhachHang(maKhachHangTimKiem);
				this.qlKhachHangModel.hienThiKetQuaTimKiemTheoMaKhachHang(khachHang);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền mã khách hàng tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSKhachHang.getSelectedRow();
		KhachHang khachHang = this.qlKhachHangModel.getDsKhachHang().get(index);
		this.jTextField_MaKhachHang.setText(khachHang.getMaKhachHang());
		this.jTextField_Username.setText(khachHang.getUsername());
		this.jTextField_TenKhachHang.setText(khachHang.getTenKhachHang());
		this.jTextField_SoDienThoai.setText(khachHang.getSoDienThoai());
		this.jTextField_DiaChiGiaoHang.setText(khachHang.getDiaChiGiaoHang());
	}
}
