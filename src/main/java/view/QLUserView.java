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

import controller.QLUserController;
import dao.SanPhamBienTheDAO;
import dao.UserDAO;
import model.QLUserModel;
import model.User;

import javax.swing.JComboBox;


public class QLUserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private QuanLyNoiThatView quanLyNoiThatView;
	private JPanel contentPane;
	private QLUserModel qlUserModel;
	private JTextField jTextField_UsernameTimKiem;
	private JTextField jTextField_Username;
	private JTextField jTextField_Password;
	private JTable jTable_DSUser;
	private JLabel jLable_Username;
	private JComboBox jComboBox_Role;
	
	public QLUserView(QuanLyNoiThatView quanLyNoiThatView) {
		this.quanLyNoiThatView = quanLyNoiThatView;
		this.qlUserModel = new QLUserModel();
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
		QLUserController qlUserController = new QLUserController(this);
		
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
		JLabel jLabel_Text1 = new JLabel("TÌM KIẾM SẢN USER");
		jLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text1.setBounds(382, 0, 274, 31);
		contentPane.add(jLabel_Text1);
		
		JLabel jLabel_UsernameTimKiem = new JLabel("Username:");
		jLabel_UsernameTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_UsernameTimKiem.setBounds(97, 33, 159, 31);
		contentPane.add(jLabel_UsernameTimKiem);
		
		jTextField_UsernameTimKiem = new JTextField();
		jTextField_UsernameTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_UsernameTimKiem.setBounds(266, 32, 286, 33);
		contentPane.add(jTextField_UsernameTimKiem);
		jTextField_UsernameTimKiem.setColumns(10);
		
		JButton jButton_TimKiem = new JButton("Tìm kiếm");
		jButton_TimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_TimKiem.setBounds(601, 28, 125, 40);
		contentPane.add(jButton_TimKiem);
		jButton_TimKiem.addActionListener(qlUserController);
		
		JButton jButton_HuyTim = new JButton("Hủy tìm");
		jButton_HuyTim.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jButton_HuyTim.setBounds(736, 28, 125, 40);
		contentPane.add(jButton_HuyTim);
		jButton_HuyTim.addActionListener(qlUserController);
		
		
		//Phần bảng danh sách điểm
		JLabel jLabel_Text2 = new JLabel("DANH SÁCH USER");
		jLabel_Text2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text2.setBounds(390, 62, 291, 31);
		contentPane.add(jLabel_Text2);
		
		jTable_DSUser = new JTable(this.qlUserModel);
		jTable_DSUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTable_DSUser.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 16));
		jTable_DSUser.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jTable_DSUser.setRowHeight(40);
		JScrollPane jScrollPane = new JScrollPane(jTable_DSUser);
		jScrollPane.setBounds(10, 93, 962, 289);
		contentPane.add(jScrollPane);
		jTable_DSUser.addMouseListener(qlUserController);
		
		
		//Phần thông tin điểm
		JLabel jLabel_Text3 = new JLabel("THÔNG TIN USER");
		jLabel_Text3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Text3.setBounds(370, 381, 291, 31);
		contentPane.add(jLabel_Text3);
		
		jLable_Username = new JLabel("Username:");
		jLable_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_Username.setBounds(10, 411, 200, 31);
		contentPane.add(jLable_Username);
		
		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_Username.setColumns(10);
		jTextField_Username.setBounds(215, 410, 260, 33);
		contentPane.add(jTextField_Username);
		
		JLabel jLable_Password = new JLabel("Password:");
		jLable_Password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_Password.setBounds(502, 411, 200, 31);
		contentPane.add(jLable_Password);
		
		jTextField_Password = new JTextField();
		jTextField_Password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_Password.setColumns(10);
		jTextField_Password.setBounds(712, 410, 260, 33);
		contentPane.add(jTextField_Password);
		
		JLabel jLable_Role = new JLabel("Role:");
		jLable_Role.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLable_Role.setBounds(10, 472, 200, 31);
		contentPane.add(jLable_Role);
		
		jComboBox_Role = new JComboBox();
		jComboBox_Role.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jComboBox_Role.setBounds(215, 472, 260, 33);
		jComboBox_Role.addItem("");
		jComboBox_Role.addItem("admin");
		jComboBox_Role.addItem("user");
		contentPane.add(jComboBox_Role);
		
		
		
		//Phần chức năng, nút bấm
		JButton jButton_Them = new JButton("Thêm");
		jButton_Them.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Them.setBounds(124, 646, 170, 40);
		contentPane.add(jButton_Them);
		jButton_Them.addActionListener(qlUserController);
		
		JButton jButton_Sua = new JButton("Sửa");
		jButton_Sua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Sua.setBounds(400, 646, 170, 40);
		contentPane.add(jButton_Sua);
		jButton_Sua.addActionListener(qlUserController);
		
		JButton jButton_Xoa = new JButton("Xóa");
		jButton_Xoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_Xoa.setBounds(712, 646, 170, 40);
		contentPane.add(jButton_Xoa);
		jButton_Xoa.addActionListener(qlUserController);
		
		JButton jButton_XoaThongTin = new JButton("Xóa thông tin");
		jButton_XoaThongTin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_XoaThongTin.setBounds(124, 710, 170, 40);
		contentPane.add(jButton_XoaThongTin);
		jButton_XoaThongTin.addActionListener(qlUserController);
		
		JButton jButton_LayToanBoDanhSach = new JButton("Lấy toàn bộ danh sách");
		jButton_LayToanBoDanhSach.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_LayToanBoDanhSach.setBounds(400, 710, 181, 40);
		contentPane.add(jButton_LayToanBoDanhSach);
		jButton_LayToanBoDanhSach.addActionListener(qlUserController);
		
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jButton_QuayLai.setBounds(712, 710, 170, 40);
		contentPane.add(jButton_QuayLai);
		jButton_QuayLai.addActionListener(qlUserController);
		
		
		
		this.setVisible(true);
	}

	public void quayLai() {
		this.quanLyNoiThatView.setVisible(true);
		this.dispose();
		
	}

	public void layToanBoDanhSach() {
		try {
			ArrayList<User> ds = UserDAO.getInstance().selectAll();
			this.qlUserModel.resetDanhSachUser(ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoaThongTin() {
		this.jTextField_Username.setText("");
		this.jTextField_Password.setText("");
		this.jComboBox_Role.setSelectedIndex(0);
	}

	public void them() {
		try {
			String username = this.jTextField_Username.getText();
			String password = this.jTextField_Password.getText();
			String role = (String) this.jComboBox_Role.getSelectedItem();
			User user = new User(username, password, role);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = UserDAO.getInstance().insert(user);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sua() {
		try {
			String username = this.jTextField_Username.getText();
			String password = this.jTextField_Password.getText();
			String role = (String) this.jComboBox_Role.getSelectedItem();
			User user = new User(username, password, role);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = UserDAO.getInstance().update(user);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void xoa() {
		try {
			String username = this.jTextField_Username.getText();
			String password = this.jTextField_Password.getText();
			String role = (String) this.jComboBox_Role.getSelectedItem();
			User user = new User(username, password, role);
			JOptionPane jOptionPane = new JOptionPane();
			jOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa?");
			if (jOptionPane.YES_OPTION == 0) {
				int check = UserDAO.getInstance().delete(user);
				this.layToanBoDanhSach();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		try {
			String usernameTimKiem = this.jTextField_UsernameTimKiem.getText();
			if (usernameTimKiem.length() > 0) {
				User user = UserDAO.getInstance().timKiemTheoUsername(usernameTimKiem);
				this.qlUserModel.hienThiKetQuaTimKiemTheoUsername(user);
			}else {
				JOptionPane.showMessageDialog(this, "Bạn chưa điền username tìm kiếm!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void huyTim() {
		this.layToanBoDanhSach();
	}

	public void layThongTin() {
		int index = this.jTable_DSUser.getSelectedRow();
		User user = this.qlUserModel.getDsUser().get(index);
		this.jTextField_Username.setText(user.getUsername());
		this.jTextField_Password.setText(user.getPassword());
		this.jComboBox_Role.setSelectedItem(user.getRole());
	}
}
