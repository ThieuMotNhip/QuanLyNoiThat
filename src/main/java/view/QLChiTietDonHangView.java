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

import controller.QLChiTietDonHangController;
import dao.ChiTietDonHangDAO;
import model.ChiTietDonHang;
import model.QLChiTietDonHangModel;


public class QLChiTietDonHangView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLChiTietDonHangModel qlChiTietDonHangModel;
	private JTextField jTextField_MaChiTietDonHangTimKiem;
	private JTextField jTextField_MaChiTietDonHang;
	private JTextField jTextField_MaDonHang;
	private JTextField jTextField_MaSanPhamBienThe;
	private JTextField jTextField_SoLuong;
	private JTable jTable_DSChiTietDonHang;
	private JTextField jTextField_GiaBan;
	
	public QLChiTietDonHangView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlChiTietDonHangModel = new QLChiTietDonHangModel();
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
		QLChiTietDonHangController qlChiTietDonHangController = new QLChiTietDonHangController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM CHI TIẾT ĐƠN HÀNG");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(365, 0, 260, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaChiTietDonHangTimKiem = new JLabel("Mã chi tiết đơn hàng:");
		jLabel_MaChiTietDonHangTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaChiTietDonHangTimKiem.setBounds(97, 33, 143, 31);
		contentPane.add(jLabel_MaChiTietDonHangTimKiem);
		
		jTextField_MaChiTietDonHangTimKiem = new JTextField();
		jTextField_MaChiTietDonHangTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaChiTietDonHangTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaChiTietDonHangTimKiem);
		jTextField_MaChiTietDonHangTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlChiTietDonHangController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH CHI TIẾT ĐƠN HÀNG");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(365, 62, 260, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSChiTietDonHang = new JTable(this.qlChiTietDonHangModel);
		jTable_DSChiTietDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSChiTietDonHang.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSChiTietDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSChiTietDonHang.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSChiTietDonHang);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSChiTietDonHang.addMouseListener(qlChiTietDonHangController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN CHI TIẾT ĐƠN HÀNG");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(334, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		JLabel jLable_MaChiTietDonHang = new JLabel("Mã chi tiết đơn hàng:");
		jLable_MaChiTietDonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaChiTietDonHang.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaChiTietDonHang);
		
		jTextField_MaChiTietDonHang = new JTextField();
		jTextField_MaChiTietDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaChiTietDonHang.setColumns(10);
		jTextField_MaChiTietDonHang.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaChiTietDonHang);
		
		JLabel jLable_MaDonHang = new JLabel("Mã đơn hàng:");
		jLable_MaDonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDonHang.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_MaDonHang);
		
		jTextField_MaDonHang = new JTextField();
		jTextField_MaDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDonHang.setColumns(10);
		jTextField_MaDonHang.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_MaDonHang);
		
		JLabel jLable_MaSanPhamBienThe = new JLabel("Mã sản phẩm biến thể:");
		jLable_MaSanPhamBienThe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaSanPhamBienThe.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_MaSanPhamBienThe);
		
		jTextField_MaSanPhamBienThe = new JTextField();
		jTextField_MaSanPhamBienThe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamBienThe.setColumns(10);
		jTextField_MaSanPhamBienThe.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_MaSanPhamBienThe);
		
		JLabel jLable_SoLuong = new JLabel("Số lượng:");
		jLable_SoLuong.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_SoLuong.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_SoLuong);
		
		jTextField_SoLuong = new JTextField();
		jTextField_SoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_SoLuong.setColumns(10);
		jTextField_SoLuong.setBounds(712, 471, 260, 33);
		contentPane.add(jTextField_SoLuong);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlChiTietDonHangController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		jButton_QuayLai.addActionListener(qlChiTietDonHangController);
		
		
		JLabel jLable_GiaBan = new JLabel("Giá bán:");
		jLable_GiaBan.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_GiaBan.setBounds(10, 536, 200, 31);
		contentPane.add(jLable_GiaBan);
		
		jTextField_GiaBan = new JTextField();
		jTextField_GiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_GiaBan.setColumns(10);
		jTextField_GiaBan.setBounds(215, 536, 260, 33);
		contentPane.add(jTextField_GiaBan);
		
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<ChiTietDonHang> ds = ChiTietDonHangDAO.getInstance().selectAll();
			this.qlChiTietDonHangModel.resetDanhSachChiTietDonHang(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void them() {
		try {
			String maChiTietDonHang = this.jTextField_MaChiTietDonHang.getText();
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			int soLuong = Integer.valueOf(this.jTextField_SoLuong.getText());
			double giaBan = Integer.valueOf(this.jTextField_GiaBan.getText());
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, maDonHang, maSanPhamBienThe, soLuong, giaBan);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = ChiTietDonHangDAO.getInstance().insert(chiTietDonHang);
				this.qlChiTietDonHangModel.them(chiTietDonHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maChiTietDonHang = this.jTextField_MaChiTietDonHang.getText();
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			int soLuong = Integer.valueOf(this.jTextField_SoLuong.getText());
			double giaBan = Integer.valueOf(this.jTextField_GiaBan.getText());
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, maDonHang, maSanPhamBienThe, soLuong, giaBan);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = ChiTietDonHangDAO.getInstance().update(chiTietDonHang);
				this.qlChiTietDonHangModel.sua(chiTietDonHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maChiTietDonHang = this.jTextField_MaChiTietDonHang.getText();
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			int soLuong = Integer.valueOf(this.jTextField_SoLuong.getText());
			double giaBan = Integer.valueOf(this.jTextField_GiaBan.getText());
			ChiTietDonHang chiTietDonHang = new ChiTietDonHang(maChiTietDonHang, maDonHang, maSanPhamBienThe, soLuong, giaBan);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = ChiTietDonHangDAO.getInstance().delete(chiTietDonHang);
				this.qlChiTietDonHangModel.xoa(chiTietDonHang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaChiTietDonHang.setText("");
		this.jTextField_MaDonHang.setText("");
		this.jTextField_MaSanPhamBienThe.setText("");
		this.jTextField_SoLuong.setText("");
		this.jTextField_GiaBan.setText("");
	}

	public void timKiem() {
		try {
			String maChiTietDonHangTimKiem = this.jTextField_MaChiTietDonHangTimKiem.getText();
			if (maChiTietDonHangTimKiem.length() > 0) {
				ChiTietDonHang chiTietDonHang = ChiTietDonHangDAO.getInstance().timKiemTheoMaChiTietDonHang(maChiTietDonHangTimKiem);
				this.qlChiTietDonHangModel.hienThiKetQuaTimKiemTheoMaChiTietDonHang(chiTietDonHang);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điên mã chi tiết đơn hàng tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSChiTietDonHang.getSelectedRow();
		ChiTietDonHang chiTietDonHang = this.qlChiTietDonHangModel.getDsChiTietDonHang().get(index);
		this.jTextField_MaChiTietDonHang.setText(chiTietDonHang.getMaChiTietDonHang());
		this.jTextField_MaDonHang.setText(chiTietDonHang.getMaDonHang());
		this.jTextField_MaSanPhamBienThe.setText(chiTietDonHang.getMaSanPhamBienThe());
		this.jTextField_SoLuong.setText(chiTietDonHang.getSoLuong()+"");
		this.jTextField_GiaBan.setText(chiTietDonHang.getGiaBan()+"");
	}
}
