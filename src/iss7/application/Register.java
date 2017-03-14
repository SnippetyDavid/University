package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Register extends JFrame {

	private static final long serialVersionUID = 6436562819071415973L;

	private JButton submitButton;
	private JPasswordField passwordField, verifyPasswordField;

	public Register() {
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 5);

		// Row 1
		constraints.gridx = 0;
		constraints.gridy = 0;
		JLabel passwordLabel = new JLabel("Password: ");
		c.add(passwordLabel, constraints);
		constraints.gridx = 1;
		passwordField = new JPasswordField(20);
		c.add(passwordField, constraints);

		// Row 2
		constraints.gridx = 0;
		constraints.gridy = 1;
		JLabel verifyPasswordLabel = new JLabel("Verify password: ");
		c.add(verifyPasswordLabel, constraints);
		verifyPasswordField = new JPasswordField(20);
		constraints.gridx = 1;
		c.add(verifyPasswordField, constraints);

		// Row 3
		constraints.gridwidth = 2;
		String guidelines = new String(
		        "Passwords guidelines:\n\n" + "a) Password should be at least 10 characters long.\n"
		                + "b) Password should be at most 36 characters long.\n"
		                + "c) Password should contain at least 4 unique characters.\n\n"
		                + "A unique 8 digit user ID will then be generated for you. Please write this down.");
		JTextArea outputArea = new JTextArea(guidelines, 40, 30);
		outputArea.setBorder(new LineBorder(Color.BLACK));
		outputArea.setEditable(false);
		outputArea.setWrapStyleWord(true);
		outputArea.setLineWrap(true);
		constraints.gridx = 0;
		constraints.gridy = 2;
		c.add(outputArea, constraints);

		ButtonHandler handler = new ButtonHandler();
		submitButton = new JButton("Submit");
		constraints.gridx = 0;
		constraints.gridy = 3;
		submitButton.addActionListener(handler);
		c.add(submitButton, constraints);

		pack();
		setResizable(false);
		setVisible(true);
	}

	private boolean isPasswordValid(String password) {
		boolean isValid = true;
		if (password.length() < 10)
			isValid = false;
		if (password.length() >= 36)
			isValid = false;
		return isValid;
	}

	private boolean doPasswordsMatch() {
		return false;
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitButton) {
				boolean isCorrect;
				// verify first password is valid
				char[] passwordChars = passwordField.getPassword();
				String password = new String(passwordField.getPassword());
				Arrays.fill(passwordChars, '0');
				passwordField.selectAll();
				
				isCorrect = isPasswordValid(password);
				
				// verify both passwords match
				

				// submit
				// receive and display generated ID
			}
		}
	}

	public static void main(String[] args) {
		new Register();
	}

}
