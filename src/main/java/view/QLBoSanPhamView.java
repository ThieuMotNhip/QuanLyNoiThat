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
import controller.QLBoSanPhamController;
import dao.BoSanPhamDAO;
import model.BoSanPham;
import model.QLBoSanPhamModel;

public class QLBoSanPhamView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLBoSanPhamModel qlBoSanPhamModel;
	private JTextField jTextField_MaBoSanPhamTimKiem;
	private JTextField jTextField_MaBoSanPham;
	private JTextField jTextField_MaDinhDanhLuuKhoCaBo;
	private JTextField jTextField_MaDinhDanhLuuKhoMonLe;
	private JTextField jTextField_SoLuongMonLe;
	private JTable jTable_DSBoSanPham;
	
	
	public QLBoSanPhamView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlBoSanPhamModel = new QLBoSanPhamModel();
		this.init();
	}


	private void init() {
		setTitle("Quản lý bộ sản phẩm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setSize(1000, 800);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Controller
		QLBoSanPhamController qlBoSanPhamController = new QLBoSanPhamController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM BỘ SẢN PHẨM");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(400, 0, 204, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_MaBoSanPhamTimKiem = new JLabel("Mã bộ sản phẩm:");
		jLabel_MaBoSanPhamTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_MaBoSanPhamTimKiem.setBounds(124, 33, 116, 31);
		contentPane.add(jLabel_MaBoSanPhamTimKiem);
		
		jTextField_MaBoSanPhamTimKiem = new JTextField();
		jTextField_MaBoSanPhamTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaBoSanPhamTimKiem.setBounds(250, 32, 302, 33);
		contentPane.add(jTextField_MaBoSanPhamTimKiem);
		jTextField_MaBoSanPhamTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlBoSanPhamController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlBoSanPhamController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH BỘ SẢN PHẨM");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(387, 62, 217, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSBoSanPham = new JTable(this.qlBoSanPhamModel);
		jTable_DSBoSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSBoSanPham.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSBoSanPham.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSBoSanPham.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSBoSanPham);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSBoSanPham.addMouseListener(qlBoSanPhamController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN BỘ SẢN PHẨM");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(400, 381, 204, 31);
		contentPane.add(jLabel_Text3);
		
		JLabel jLable_MaBoSanPham = new JLabel("Mã bộ sản phẩm:");
		jLable_MaBoSanPham.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaBoSanPham.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_MaBoSanPham);
		
		jTextField_MaBoSanPham = new JTextField();
		jTextField_MaBoSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaBoSanPham.setColumns(10);
		jTextField_MaBoSanPham.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_MaBoSanPham);
		
		JLabel jLable_MaDinhDanhLuuKhoCaBo = new JLabel("Mã định danh lưu kho cả bộ:");
		jLable_MaDinhDanhLuuKhoCaBo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDinhDanhLuuKhoCaBo.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_MaDinhDanhLuuKhoCaBo);
		
		jTextField_MaDinhDanhLuuKhoCaBo = new JTextField();
		jTextField_MaDinhDanhLuuKhoCaBo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDinhDanhLuuKhoCaBo.setColumns(10);
		jTextField_MaDinhDanhLuuKhoCaBo.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_MaDinhDanhLuuKhoCaBo);
		
		JLabel jLable_MaDinhDanhLuuKhoMonLe = new JLabel("Mã định danh lưu kho món lẻ:");
		jLable_MaDinhDanhLuuKhoMonLe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_MaDinhDanhLuuKhoMonLe.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_MaDinhDanhLuuKhoMonLe);
		
		jTextField_MaDinhDanhLuuKhoMonLe = new JTextField();
		jTextField_MaDinhDanhLuuKhoMonLe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_MaDinhDanhLuuKhoMonLe.setColumns(10);
		jTextField_MaDinhDanhLuuKhoMonLe.setBounds(215, 471, 260, 33);
		contentPane.add(jTextField_MaDinhDanhLuuKhoMonLe);
		
		JLabel jLable_SoLuongMonLe = new JLabel("Số lượng món lẻ:");
		jLable_SoLuongMonLe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_SoLuongMonLe.setBounds(502, 472, 200, 31);
		contentPane.add(jLable_SoLuongMonLe);
		
		jTextField_SoLuongMonLe = new JTextField();
		jTextField_SoLuongMonLe.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_SoLuongMonLe.setColumns(10);
		jTextField_SoLuongMonLe.setBounds(712, 471, 260, 33);
		contentPane.add(jTextField_SoLuongMonLe);
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlBoSanPhamController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlBoSanPhamController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlBoSanPhamController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlBoSanPhamController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlBoSanPhamController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		jButton_QuayLai.addActionListener(qlBoSanPhamController);
		
		
		this.setVisible(true);
	}


	public void them() {
		try {
			String maBoSanPham = this.jTextField_MaBoSanPham.getText();
			String maDinhDanhLuuKhoCaBo = this.jTextField_MaDinhDanhLuuKhoCaBo.getText();
			String maDinhDanhLuuKhoMonLe = this.jTextField_MaDinhDanhLuuKhoMonLe.getText();
			int soLuongMonLe = Integer.valueOf(this.jTextField_SoLuongMonLe.getText());
			BoSanPham boSanPham = new BoSanPham(maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe, soLuongMonLe);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = BoSanPhamDAO.getInstance().insert(boSanPham);
				this.qlBoSanPhamModel.them(boSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void sua() {
		try {
			String maBoSanPham = this.jTextField_MaBoSanPham.getText();
			String maDinhDanhLuuKhoCaBo = this.jTextField_MaDinhDanhLuuKhoCaBo.getText();
			String maDinhDanhLuuKhoMonLe = this.jTextField_MaDinhDanhLuuKhoMonLe.getText();
			int soLuongMonLe = Integer.valueOf(this.jTextField_SoLuongMonLe.getText());
			BoSanPham boSanPham = new BoSanPham(maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe, soLuongMonLe);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = BoSanPhamDAO.getInstance().update(boSanPham);
				this.qlBoSanPhamModel.sua(boSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void xoa() {
		try {
			String maBoSanPham = this.jTextField_MaBoSanPham.getText();
			String maDinhDanhLuuKhoCaBo = this.jTextField_MaDinhDanhLuuKhoCaBo.getText();
			String maDinhDanhLuuKhoMonLe = this.jTextField_MaDinhDanhLuuKhoMonLe.getText();
			int soLuongMonLe = Integer.valueOf(this.jTextField_SoLuongMonLe.getText());
			BoSanPham boSanPham = new BoSanPham(maBoSanPham, maDinhDanhLuuKhoCaBo, maDinhDanhLuuKhoMonLe, soLuongMonLe);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = BoSanPhamDAO.getInstance().delete(boSanPham);
				this.qlBoSanPhamModel.xoa(boSanPham);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void timKiem() {
		try {
			String maBoSanPhamTimKiem = this.jTextField_MaBoSanPhamTimKiem.getText();
			if (maBoSanPhamTimKiem.length() > 0) {
				BoSanPham boSanPham = BoSanPhamDAO.getInstance().timKiemTheoMaBoSanPham(maBoSanPhamTimKiem);
				this.qlBoSanPhamModel.hienThiKetQuaTimKiemTheoMaBoSanPham(boSanPham);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền mã bộ sản phẩm cần tìm kiếm!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public void huyTim() {
		this.layToanBoDanhSach();
	}


	public void xoaThongTin() {
		this.jTextField_MaBoSanPham.setText("");
		this.jTextField_MaDinhDanhLuuKhoCaBo.setText("");
		this.jTextField_MaDinhDanhLuuKhoMonLe.setText("");
		this.jTextField_SoLuongMonLe.setText("");
	}


	public void layToanBoDanhSach() {
		try {
			ArrayList<BoSanPham> ds = BoSanPhamDAO.getInstance().selectAll();
			this.qlBoSanPhamModel.resetLaiDanhSachBoSanPham(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}


	public void layThongTin() {
		int index = this.jTable_DSBoSanPham.getSelectedRow();
		BoSanPham boSanPham = this.qlBoSanPhamModel.getDsBoSanPham().get(index);
		this.jTextField_MaBoSanPham.setText(boSanPham.getMaBoSanPham());
		this.jTextField_MaDinhDanhLuuKhoCaBo.setText(boSanPham.getMaDinhDanhLuuKhoCaBo());
		this.jTextField_MaDinhDanhLuuKhoMonLe.setText(boSanPham.getMaDinhDanhLuuKhoMonLe());
		this.jTextField_SoLuongMonLe.setText(boSanPham.getSoLuongMonLe()+"");
	}

}
