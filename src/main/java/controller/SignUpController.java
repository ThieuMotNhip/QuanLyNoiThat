package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SignUpView;

public class SignUpController implements ActionListener{
	private SignUpView signUpView;
	

	public SignUpController(SignUpView signUpView) {
		super();
		this.signUpView = signUpView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("Sign Up")) {
			
		}else if (button.equals("Quay lại")) {
			this.signUpView.quayLai();
		}
	}

}
