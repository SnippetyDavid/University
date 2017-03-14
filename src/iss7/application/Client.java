package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 3681683193416937427L;
	private JButton loginButton, registerButton;

	public Client() {
		super("Client");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 5, 10, 5);

		JTextArea outputArea = new JTextArea("Would you like to login as an existing user, or register a new user?");
		outputArea.setBorder(new LineBorder(Color.BLACK));
		outputArea.setEditable(false);
		outputArea.setWrapStyleWord(true);
		outputArea.setLineWrap(true);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		constraints.weightx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		c.add(outputArea, constraints);

		ButtonHandler handler = new ButtonHandler();
		loginButton = new JButton("Login");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.gridwidth = 1;
		loginButton.addActionListener(handler);
		c.add(loginButton, constraints);

		registerButton = new JButton("Register");
		constraints.gridx = 2;
		constraints.gridy = 1;
		registerButton.addActionListener(handler);
		c.add(registerButton, constraints);

		setSize(250, 200);
		setResizable(false);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == loginButton) {
				Login login = new Login();
				login.getConnections();
			}
			else if (e.getSource() == registerButton) {
				Register register = new Register();
			}
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
	}

}
