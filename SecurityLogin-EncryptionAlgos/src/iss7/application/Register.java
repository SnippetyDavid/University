package application;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
    private JTextArea outputArea;

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
        outputArea = new JTextArea("", 5, 30);
        outputArea.setBorder(new LineBorder(Color.BLACK));
        outputArea.setEditable(false);
        outputArea.setWrapStyleWord(true);
        outputArea.setLineWrap(true);
        constraints.gridx = 0;
        constraints.gridy = 2;
        c.add(outputArea, constraints);

        // Row 4
        String guidelines = new String(
                "Passwords guidelines:\n\n" + "a) Password should be at least 10 characters long.\n"
                        + "b) Password should be at most 36 characters long.\n"
                        + "c) Password should contain at least 4 unique characters.\n\n"
                        + "A unique 8 digit user ID will then be generated for you. Please write this down.");
        JTextArea guidelineArea = new JTextArea(guidelines, 40, 30);
        guidelineArea.setBorder(new LineBorder(Color.BLACK));
        guidelineArea.setEditable(false);
        guidelineArea.setWrapStyleWord(true);
        guidelineArea.setLineWrap(true);
        constraints.gridx = 0;
        constraints.gridy = 3;
        c.add(guidelineArea, constraints);

        // Row 5
        ButtonHandler handler = new ButtonHandler();
        submitButton = new JButton("Submit");
        constraints.gridx = 0;
        constraints.gridy = 4;
        submitButton.addActionListener(handler);
        c.add(submitButton, constraints);

        pack();
        setResizable(false);
        setVisible(true);

    }

    private boolean isPasswordValid(char[] password) {
        // Check password length
        System.out.println(password.length);
        if (password.length < 10 || password.length > 36)
            return false;

        // Check for unique characters
        Set<Character> uniqueChars = new HashSet<Character>();
        for (char c: password) {
            uniqueChars.add(c);
        }
        if (uniqueChars.size() < 4)
            return false;
        uniqueChars.clear();
        
        return true;
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton) {
                // verify first password is valid
                char[] passwordChars = passwordField.getPassword();
                boolean isCorrect = isPasswordValid(passwordChars);

                // verify both passwords match
                char[] verifyChars = verifyPasswordField.getPassword();
                isCorrect = isCorrect & Arrays.equals(passwordChars, verifyChars);
                
                Arrays.fill(passwordChars, '0');
                Arrays.fill(verifyChars, '0');
                passwordField.selectAll();
                verifyPasswordField.selectAll();

                if (isCorrect) {
                    // submit

                    // receive and display generated ID
                    outputArea.setText("DISPLAY GENERATED ID HERE");

                } else {
                    outputArea.setText("Password entered is not valid. Please follow the rules and try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Register();
    }

}
