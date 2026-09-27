package view;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import dao.UserDAO;
import model.User;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextField_Username;
	private JPasswordField jPasswordField_Password;

	public LoginView() {
		this.init();
	}
	
	private void init() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Controller
		LoginController loginController = new LoginController(this);
		
		//Phần hình ảnh
		JPanel jPanel_hinhAnh = new JPanel();
		jPanel_hinhAnh.setBounds(10, 11, 250, 439);
		jPanel_hinhAnh.setLayout(null);
		JLabel jLabel_hinhAnh = new JLabel();
		jLabel_hinhAnh.setBounds(0, 0, 250, 439);
		jLabel_hinhAnh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(LoginView.class.getResource("ha_TBA.jpg"))));
		jPanel_hinhAnh.add(jLabel_hinhAnh);
		contentPane.add(jPanel_hinhAnh);
		
		//Phần login
		JPanel jPanel_Login = new JPanel();
		jPanel_Login.setBackground(new Color(0, 255, 255));
		jPanel_Login.setBounds(259, 11, 425, 439);
		contentPane.add(jPanel_Login);
		jPanel_Login.setLayout(null);
		JLabel JLabel_Text1 = new JLabel("CHÀO MỪNG ĐẾN VỚI CHƯƠNG TRÌNH",JLabel.CENTER);
		JLabel_Text1.setForeground(new Color(255, 0, 0));
		JLabel_Text1.setBackground(new Color(255, 255, 0));
		JLabel_Text1.setOpaque(true);
		JLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLabel_Text1.setBounds(21, 24, 394, 29);
		jPanel_Login.add(JLabel_Text1);
		JLabel jLable_Text2 = new JLabel("Login");
		jLable_Text2.setBounds(176, 75, 81, 42);
		jLable_Text2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jPanel_Login.add(jLable_Text2);
		
		//Phần username và password
		JLabel jLabel_Username = new JLabel("Username:");
		jLabel_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Username.setBounds(70, 127, 81, 42);
		jPanel_Login.add(jLabel_Username);
		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_Username.setBounds(150, 128, 240, 31);
		jPanel_Login.add(jTextField_Username);
		jTextField_Username.setColumns(10);
		JLabel jLabel_Password = new JLabel("Password:");
		jLabel_Password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Password.setBounds(70, 186, 81, 42);
		jPanel_Login.add(jLabel_Password);
		jPasswordField_Password = new JPasswordField();
		jPasswordField_Password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jPasswordField_Password.setBounds(150, 193, 240, 31);
		jPanel_Login.add(jPasswordField_Password);
		
		JButton jButton_SignIn = new JButton("Sign In");
		jButton_SignIn.setBackground(new Color(255, 255, 255));
		jButton_SignIn.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton_SignIn.setBounds(111, 254, 105, 33);
		jPanel_Login.add(jButton_SignIn);
		
		JButton jButton_SignUp = new JButton("Sign Up");
		jButton_SignUp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton_SignUp.setBackground(Color.WHITE);
		jButton_SignUp.setBounds(243, 254, 105, 33);
		jPanel_Login.add(jButton_SignUp);
		jButton_SignUp.addActionListener(loginController);
		jButton_SignIn.addActionListener(loginController);
		

		this.setVisible(true);
	}
	
	public void signIn() {
		String username = this.jTextField_Username.getText();
		String password = this.jPasswordField_Password.getText();
		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			boolean check = UserDAO.getInstance().kiemTraAdminDangNhap(user);
			if (check) {
				new QuanLyNoiThatView();
				this.dispose();
			}else {
				JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không chính xác!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void signUp() {
		new SignUpView(this);
		this.setVisible(false);
	}

}
