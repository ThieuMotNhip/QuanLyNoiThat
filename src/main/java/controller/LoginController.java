package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginView;

public class LoginController implements ActionListener{
	private LoginView loginView;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Sign In")) {
			this.loginView.signIn();
		}else if (button.equals("Sign Up")) {
			this.loginView.signUp();
		}
	}

}
