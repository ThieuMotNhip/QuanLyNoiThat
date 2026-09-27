package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Date;
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

import controller.QLDonHangController;
import dao.DonHangDAO;
import model.DonHang;
import model.QLDonHangModel;
import javax.swing.JComboBox;

public class QLDonHangView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLDonHangModel qlDonHangModel;
	private JTextField jTextField_MaDonHangTimKiem;
	private JTextField jTextField_MaDonHang;
	private JTextField jTextField_MaKhachHang;
	private JTextField jTextField_NgayDatHang;
	private JTable jTable_DSDonHang;
	private JLabel jLable_MaDonHang;
	private JTextField jTextField_TongGiaTriDonHang;
	private JTextField jTextField_SoTienKhachDaDatCoc;
	private JComboBox jComboBox_TrangThai;
	
	public QLDonHangView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlDonHangModel = new QLDonHangModel();
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
		QLDonHangController qlDonHangController = new QLDonHangController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM ĐƠN HÀNG");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(382, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaDonHangTimKiem = new JLabel("Mã đơn hàng:");
		jLabel_MaDonHangTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaDonHangTimKiem.setBounds(97, 33, 143, 31);
		contentPane.add(jLabel_MaDonHangTimKiem);
		
		jTextField_MaDonHangTimKiem = new JTextField();
		jTextField_MaDonHangTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDonHangTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaDonHangTimKiem);
		jTextField_MaDonHangTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlDonHangController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlDonHangController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH ĐƠN HÀNG");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(390, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSDonHang = new JTable(this.qlDonHangModel);
		jTable_DSDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSDonHang.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSDonHang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSDonHang.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSDonHang);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSDonHang.addMouseListener(qlDonHangController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN ĐƠN HÀNG");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(370, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		jLable_MaDonHang = new JLabel("Mã đơn hàng:");
		jLable_MaDonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDonHang.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaDonHang);
		
		jTextField_MaDonHang = new JTextField();
		jTextField_MaDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDonHang.setColumns(10);
		jTextField_MaDonHang.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaDonHang);
		
		JLabel jLable_MaKhachHang = new JLabel("Mã khách hàng:");
		jLable_MaKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaKhachHang.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_MaKhachHang);
		
		jTextField_MaKhachHang = new JTextField();
		jTextField_MaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaKhachHang.setColumns(10);
		jTextField_MaKhachHang.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_MaKhachHang);
		
		JLabel jLable_NgayDatHang = new JLabel("Ngày đặt hàng(yyyy-mm-dd):");
		jLable_NgayDatHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_NgayDatHang.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_NgayDatHang);
		
		jTextField_NgayDatHang = new JTextField();
		jTextField_NgayDatHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_NgayDatHang.setColumns(10);
		jTextField_NgayDatHang.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_NgayDatHang);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlDonHangController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlDonHangController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlDonHangController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlDonHangController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlDonHangController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		
		JLabel jLable_TrangThai = new JLabel("Trạng thái:");
		jLable_TrangThai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_TrangThai.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_TrangThai);
		
		jComboBox_TrangThai = new JComboBox();
		jComboBox_TrangThai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jComboBox_TrangThai.setBounds(712, 472, 260, 33);
		jComboBox_TrangThai.addItem("");
		jComboBox_TrangThai.addItem("Chờ xử lý");
		jComboBox_TrangThai.addItem("Đang sản xuất");
		jComboBox_TrangThai.addItem("Đang lắp đặt");
		jComboBox_TrangThai.addItem("Đã hoàn thành");
		contentPane.add(jComboBox_TrangThai);
		jButton_QuayLai.addActionListener(qlDonHangController);
		
		JLabel jLable_TongGiaTriDonHang = new JLabel("Tổng giá trị đơn hàng:");
		jLable_TongGiaTriDonHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_TongGiaTriDonHang.setBounds(10, 535, 200, 31);
		contentPane.add(jLable_TongGiaTriDonHang);
		
		jTextField_TongGiaTriDonHang = new JTextField();
		jTextField_TongGiaTriDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_TongGiaTriDonHang.setColumns(10);
		jTextField_TongGiaTriDonHang.setBounds(215, 534, 260, 33);
		contentPane.add(jTextField_TongGiaTriDonHang);
		
		JLabel jLable_SoTienKhachDaDatCoc = new JLabel("Số tiền khách đã đặt cọc:");
		jLable_SoTienKhachDaDatCoc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_SoTienKhachDaDatCoc.setBounds(502, 535, 200, 31);
		contentPane.add(jLable_SoTienKhachDaDatCoc);
		
		jTextField_SoTienKhachDaDatCoc = new JTextField();
		jTextField_SoTienKhachDaDatCoc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_SoTienKhachDaDatCoc.setColumns(10);
		jTextField_SoTienKhachDaDatCoc.setBounds(712, 535, 260, 33);
		contentPane.add(jTextField_SoTienKhachDaDatCoc);
		
		
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<DonHang> ds = DonHangDAO.getInstance().selectAll();
			this.qlDonHangModel.resetDanhSachDonHang(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_MaDonHang.setText("");
		this.jTextField_MaKhachHang.setText("");
		this.jTextField_NgayDatHang.setText("");
		this.jComboBox_TrangThai.setSelectedIndex(0);
		this.jTextField_TongGiaTriDonHang.setText("");
		this.jTextField_SoTienKhachDaDatCoc.setText("");
	}

	public void them() {
		try {
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			Date ngayDatHang = Date.valueOf(this.jTextField_NgayDatHang.getText());
			String trangThai = (String) this.jComboBox_TrangThai.getSelectedItem();
			double tongGiaTriDonHang = Double.valueOf(this.jTextField_TongGiaTriDonHang.getText());
			double soTienKhachDaDatCoc =Double.valueOf(this.jTextField_SoTienKhachDaDatCoc.getText());
			DonHang donHang = new DonHang(maDonHang, maKhachHang, ngayDatHang, trangThai, tongGiaTriDonHang, soTienKhachDaDatCoc);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DonHangDAO.getInstance().insert(donHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			Date ngayDatHang = Date.valueOf(this.jTextField_NgayDatHang.getText());
			String trangThai = (String) this.jComboBox_TrangThai.getSelectedItem();
			double tongGiaTriDonHang = Double.valueOf(this.jTextField_TongGiaTriDonHang.getText());
			double soTienKhachDaDatCoc =Double.valueOf(this.jTextField_SoTienKhachDaDatCoc.getText());
			DonHang donHang = new DonHang(maDonHang, maKhachHang, ngayDatHang, trangThai, tongGiaTriDonHang, soTienKhachDaDatCoc);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DonHangDAO.getInstance().update(donHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String maDonHang = this.jTextField_MaDonHang.getText();
			String maKhachHang = this.jTextField_MaKhachHang.getText();
			Date ngayDatHang = Date.valueOf(this.jTextField_NgayDatHang.getText());
			String trangThai = (String) this.jComboBox_TrangThai.getSelectedItem();
			double tongGiaTriDonHang = Double.valueOf(this.jTextField_TongGiaTriDonHang.getText());
			double soTienKhachDaDatCoc =Double.valueOf(this.jTextField_SoTienKhachDaDatCoc.getText());
			DonHang donHang = new DonHang(maDonHang, maKhachHang, ngayDatHang, trangThai, tongGiaTriDonHang, soTienKhachDaDatCoc);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = DonHangDAO.getInstance().delete(donHang);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		try {
			String maDonHangTimKiem = this.jTextField_MaDonHangTimKiem.getText();
			if (maDonHangTimKiem.length() > 0) {
				DonHang donHang = DonHangDAO.getInstance().timKiemTheoMaDonHang(maDonHangTimKiem);
				this.qlDonHangModel.hienThiKetQuaTimKiemTheoMaDonHang(donHang);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền mã đơn hàng tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSDonHang.getSelectedRow();
		DonHang donHang = this.qlDonHangModel.getDsDonHang().get(index);
		this.jTextField_MaDonHang.setText(donHang.getMaDonHang());
		this.jTextField_MaKhachHang.setText(donHang.getMaKhachHang());
		this.jTextField_NgayDatHang.setText(donHang.getNgayDatHang()+"");
		this.jComboBox_TrangThai.setSelectedItem(donHang.getTrangThai());
		this.jTextField_TongGiaTriDonHang.setText(donHang.getTongGiaTriDonHang()+"");
		this.jTextField_SoTienKhachDaDatCoc.setText(donHang.getSoTienKhachHangDaDatCoc()+"");
	}
}
