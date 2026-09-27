package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import controller.SignUpController;
import dao.UserDAO;
import model.User;

public class SignUpView extends JFrame {

	private static final long serialVersionUID = 1L;
	private LoginView loginView;
	private JPanel contentPane;
	private JTextField jTextField_Username;
	private JPasswordField jPasswordField_Password;
	private JPasswordField jPasswordField_ConfirmPassword;
	
	public SignUpView(LoginView loginView) {
		this.loginView = loginView;
		this.init();
	}

	private void init() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Controller
		SignUpController signUpController = new SignUpController(this);
		
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
		JPanel jPanel_SignUp = new JPanel();
		jPanel_SignUp.setBackground(new Color(0, 255, 255));
		jPanel_SignUp.setBounds(259, 11, 425, 439);
		contentPane.add(jPanel_SignUp);
		jPanel_SignUp.setLayout(null);
		JLabel JLabel_Text1 = new JLabel("CHÀO MỪNG ĐẾN VỚI CHƯƠNG TRÌNH",JLabel.CENTER);
		JLabel_Text1.setForeground(new Color(255, 0, 0));
		JLabel_Text1.setBackground(new Color(255, 255, 0));
		JLabel_Text1.setOpaque(true);
		JLabel_Text1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		JLabel_Text1.setBounds(21, 24, 394, 29);
		jPanel_SignUp.add(JLabel_Text1);
		JLabel jLable_Text2 = new JLabel("Sign Up");
		jLable_Text2.setBounds(176, 75, 81, 42);
		jLable_Text2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jPanel_SignUp.add(jLable_Text2);
		
		//Phần username và password
		JLabel jLabel_Username = new JLabel("Username:");
		jLabel_Username.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Username.setBounds(70, 127, 81, 42);
		jPanel_SignUp.add(jLabel_Username);
		jTextField_Username = new JTextField();
		jTextField_Username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jTextField_Username.setBounds(150, 128, 240, 31);
		jPanel_SignUp.add(jTextField_Username);
		jTextField_Username.setColumns(10);
		JLabel jLabel_Password = new JLabel("Password:");
		jLabel_Password.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_Password.setBounds(70, 186, 81, 42);
		jPanel_SignUp.add(jLabel_Password);
		jPasswordField_Password = new JPasswordField();
		jPasswordField_Password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jPasswordField_Password.setBounds(150, 192, 240, 31);
		jPanel_SignUp.add(jPasswordField_Password);
		
		JLabel jLabel_ConfirmPassword = new JLabel("Confirm password:");
		jLabel_ConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		jLabel_ConfirmPassword.setBounds(21, 251, 130, 42);
		jPanel_SignUp.add(jLabel_ConfirmPassword);
		
		jPasswordField_ConfirmPassword = new JPasswordField();
		jPasswordField_ConfirmPassword.setToolTipText("");
		jPasswordField_ConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jPasswordField_ConfirmPassword.setBounds(150, 257, 240, 31);
		jPanel_SignUp.add(jPasswordField_ConfirmPassword);
		
		//Phần nút bấm
		JButton jButton_QuayLai = new JButton("Quay lại");
		jButton_QuayLai.setBackground(new Color(255, 255, 255));
		jButton_QuayLai.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton_QuayLai.setBounds(230, 316, 105, 33);
		jPanel_SignUp.add(jButton_QuayLai);
		
		JButton jButton_SignUp = new JButton("Sign Up");
		jButton_SignUp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		jButton_SignUp.setBackground(Color.WHITE);
		jButton_SignUp.setBounds(96, 316, 105, 33);
		jPanel_SignUp.add(jButton_SignUp);
		
		
		jButton_SignUp.addActionListener(signUpController);
		jButton_QuayLai.addActionListener(signUpController);
		

		this.setVisible(true);
	}

	public void quayLai() {
		this.loginView.setVisible(true);
		this.dispose();
	}

}
