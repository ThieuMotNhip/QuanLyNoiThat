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

import controller.QLSanPhamBienTheController;
import dao.MauSanPhamDAO;
import dao.SanPhamBienTheDAO;
import model.QLSanPhamBienTheModel;
import model.SanPhamBienThe;


public class QLSanPhamBienTheView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLSanPhamBienTheModel qlSanPhamBienTheModel;
	private JTextField jTextField_MaSanPhamBienTheTimKiem;
	private JTextField jTextField_MaSanPhamBienThe;
	private JTextField jTextField_MaSanPhamGoc;
	private JTextField jTextField_MaDinhDanhLuuKho;
	private JTable jTable_DSSanPhamBienThe;
	private JLabel jLable_MaSanPhamBienThe;
	private JTextField jTextField_MauSac;
	private JTextField jTextField_ChatLieu;
	private JTextField jTextField_KichThuoc;
	private JTextField jTextField_GiaBanChinhXac;
	private JTextField jTextField_SoLuongTonKho;
	
	public QLSanPhamBienTheView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlSanPhamBienTheModel = new QLSanPhamBienTheModel();
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
		QLSanPhamBienTheController qlSanPhamBienTheController = new QLSanPhamBienTheController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM SẢN PHẨM BIẾN THỂ");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(382, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaSanPhamBienTheTimKiem = new JLabel("Mã sản phẩm biến thể:");
		jLabel_MaSanPhamBienTheTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaSanPhamBienTheTimKiem.setBounds(97, 33, 159, 31);
		contentPane.add(jLabel_MaSanPhamBienTheTimKiem);
		
		jTextField_MaSanPhamBienTheTimKiem = new JTextField();
		jTextField_MaSanPhamBienTheTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamBienTheTimKiem.setBounds(266, 32, 286, 33);
		contentPane.add(jTextField_MaSanPhamBienTheTimKiem);
		jTextField_MaSanPhamBienTheTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlSanPhamBienTheController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH SẢN PHẨM BIẾN THỂ");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(390, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSSanPhamBienThe = new JTable(this.qlSanPhamBienTheModel);
		jTable_DSSanPhamBienThe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSSanPhamBienThe.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSSanPhamBienThe.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSSanPhamBienThe.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSSanPhamBienThe);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSSanPhamBienThe.addMouseListener(qlSanPhamBienTheController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN SẢN PHẨM BIẾN THỂ");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(370, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		jLable_MaSanPhamBienThe = new JLabel("Mã sản phẩm biến thể:");
		jLable_MaSanPhamBienThe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaSanPhamBienThe.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaSanPhamBienThe);
		
		jTextField_MaSanPhamBienThe = new JTextField();
		jTextField_MaSanPhamBienThe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamBienThe.setColumns(10);
		jTextField_MaSanPhamBienThe.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaSanPhamBienThe);
		
		JLabel jLable_MaSanPhamGoc = new JLabel("Mã sản phẩm gốc:");
		jLable_MaSanPhamGoc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaSanPhamGoc.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_MaSanPhamGoc);
		
		jTextField_MaSanPhamGoc = new JTextField();
		jTextField_MaSanPhamGoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaSanPhamGoc.setColumns(10);
		jTextField_MaSanPhamGoc.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_MaSanPhamGoc);
		
		JLabel jLable_MaDinhDanhLuuKho = new JLabel("Mã định danh lưu kho:");
		jLable_MaDinhDanhLuuKho.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDinhDanhLuuKho.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_MaDinhDanhLuuKho);
		
		jTextField_MaDinhDanhLuuKho = new JTextField();
		jTextField_MaDinhDanhLuuKho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDinhDanhLuuKho.setColumns(10);
		jTextField_MaDinhDanhLuuKho.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_MaDinhDanhLuuKho);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlSanPhamBienTheController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		
		JLabel jLable_MauSac = new JLabel("Màu sắc:");
		jLable_MauSac.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MauSac.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_MauSac);
		
		jTextField_MauSac = new JTextField();
		jTextField_MauSac.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MauSac.setColumns(10);
		jTextField_MauSac.setBounds(712, 470, 260, 33);
		contentPane.add(jTextField_MauSac);
		
		JLabel jLable_ChatLieu = new JLabel("Chất liệu:");
		jLable_ChatLieu.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_ChatLieu.setBounds(10, 535, 200, 31);
		contentPane.add(jLable_ChatLieu);
		
		jTextField_ChatLieu = new JTextField();
		jTextField_ChatLieu.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_ChatLieu.setColumns(10);
		jTextField_ChatLieu.setBounds(215, 534, 260, 33);
		contentPane.add(jTextField_ChatLieu);
		
		JLabel jLable_KichThuoc = new JLabel("Kích thước:");
		jLable_KichThuoc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_KichThuoc.setBounds(502, 535, 200, 31);
		contentPane.add(jLable_KichThuoc);
		
		jTextField_KichThuoc = new JTextField();
		jTextField_KichThuoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_KichThuoc.setColumns(10);
		jTextField_KichThuoc.setBounds(712, 534, 260, 33);
		contentPane.add(jTextField_KichThuoc);
		
		JLabel jLable_GiaBanChinhXac = new JLabel("Giá bán chính xác:");
		jLable_GiaBanChinhXac.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_GiaBanChinhXac.setBounds(10, 599, 200, 31);
		contentPane.add(jLable_GiaBanChinhXac);
		
		jTextField_GiaBanChinhXac = new JTextField();
		jTextField_GiaBanChinhXac.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_GiaBanChinhXac.setColumns(10);
		jTextField_GiaBanChinhXac.setBounds(215, 598, 260, 33);
		contentPane.add(jTextField_GiaBanChinhXac);
		
		JLabel jLable_SoLuongTonKho = new JLabel("Số lượng tồn kho:");
		jLable_SoLuongTonKho.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_SoLuongTonKho.setBounds(502, 599, 200, 31);
		contentPane.add(jLable_SoLuongTonKho);
		
		jTextField_SoLuongTonKho = new JTextField();
		jTextField_SoLuongTonKho.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_SoLuongTonKho.setColumns(10);
		jTextField_SoLuongTonKho.setBounds(712, 599, 260, 33);
		contentPane.add(jTextField_SoLuongTonKho);
		jButton_QuayLai.addActionListener(qlSanPhamBienTheController);
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<SanPhamBienThe> ds = SanPhamBienTheDAO.getInstance().selectAll();
			this.qlSanPhamBienTheModel.resetDanhSachSanPhamBienThe(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaSanPhamBienThe.setText("");
		this.jTextField_MaSanPhamGoc.setText("");
		this.jTextField_MaDinhDanhLuuKho.setText("");
		this.jTextField_MauSac.setText("");
		this.jTextField_ChatLieu.setText("");
		this.jTextField_KichThuoc.setText("");
		this.jTextField_GiaBanChinhXac.setText("");
		this.jTextField_SoLuongTonKho.setText("");
	}

	public void them() {
		try {
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDinhDanhLuuKho = this.jTextField_MaDinhDanhLuuKho.getText();
			String mauSac = this.jTextField_MauSac.getText();
			String chatLieu = this.jTextField_ChatLieu.getText();
			String kichThuoc = this.jTextField_KichThuoc.getText();
			double giaBanChinhXac = Double.valueOf(this.jTextField_GiaBanChinhXac.getText());
			int soLuongTonKho = Integer.valueOf(this.jTextField_SoLuongTonKho.getText());
			SanPhamBienThe sanPhamBienThe = new SanPhamBienThe(maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc, giaBanChinhXac, soLuongTonKho);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = SanPhamBienTheDAO.getInstance().insert(sanPhamBienThe);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDinhDanhLuuKho = this.jTextField_MaDinhDanhLuuKho.getText();
			String mauSac = this.jTextField_MauSac.getText();
			String chatLieu = this.jTextField_ChatLieu.getText();
			String kichThuoc = this.jTextField_KichThuoc.getText();
			double giaBanChinhXac = Double.valueOf(this.jTextField_GiaBanChinhXac.getText());
			int soLuongTonKho = Integer.valueOf(this.jTextField_SoLuongTonKho.getText());
			SanPhamBienThe sanPhamBienThe = new SanPhamBienThe(maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc, giaBanChinhXac, soLuongTonKho);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = SanPhamBienTheDAO.getInstance().update(sanPhamBienThe);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maSanPhamBienThe = this.jTextField_MaSanPhamBienThe.getText();
			String maSanPhamGoc = this.jTextField_MaSanPhamGoc.getText();
			String maDinhDanhLuuKho = this.jTextField_MaDinhDanhLuuKho.getText();
			String mauSac = this.jTextField_MauSac.getText();
			String chatLieu = this.jTextField_ChatLieu.getText();
			String kichThuoc = this.jTextField_KichThuoc.getText();
			double giaBanChinhXac = Double.valueOf(this.jTextField_GiaBanChinhXac.getText());
			int soLuongTonKho = Integer.valueOf(this.jTextField_SoLuongTonKho.getText());
			SanPhamBienThe sanPhamBienThe = new SanPhamBienThe(maSanPhamBienThe, maSanPhamGoc, maDinhDanhLuuKho, mauSac, chatLieu, kichThuoc, giaBanChinhXac, soLuongTonKho);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = SanPhamBienTheDAO.getInstance().delete(sanPhamBienThe);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		try {
			String maSanPhamBienTheTimKiem = this.jTextField_MaSanPhamBienTheTimKiem.getText();
			if (maSanPhamBienTheTimKiem.length() > 0) {
				SanPhamBienThe sanPhamBienThe = SanPhamBienTheDAO.getInstance().timKiemTheoMaSanPhamBienThe(maSanPhamBienTheTimKiem);
				this.qlSanPhamBienTheModel.hienThiKetQuaTimKiemTheoMaSanPhamBienThe(sanPhamBienThe);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền mã sản phẩm biến thể tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSSanPhamBienThe.getSelectedRow();
		SanPhamBienThe sanPhamBienThe = this.qlSanPhamBienTheModel.getDsSanPhamBienThe().get(index);
		this.jTextField_MaSanPhamBienThe.setText(sanPhamBienThe.getMaSanPhamBienThe());
		this.jTextField_MaSanPhamGoc.setText(sanPhamBienThe.getMaSanPhamGoc());
		this.jTextField_MaDinhDanhLuuKho.setText(sanPhamBienThe.getMaDinhDanhLuuKho());
		this.jTextField_MauSac.setText(sanPhamBienThe.getMauSac());
		this.jTextField_ChatLieu.setText(sanPhamBienThe.getChatLieu());
		this.jTextField_KichThuoc.setText(sanPhamBienThe.getKichThuoc());
		this.jTextField_GiaBanChinhXac.setText(sanPhamBienThe.getGiaBanChinhXac()+"");
		this.jTextField_SoLuongTonKho.setText(sanPhamBienThe.getSoLuongTonKho()+"");
	}
}
