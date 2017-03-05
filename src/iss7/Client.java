import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class to act as Client in remote server logon application for CSC3048 Assignment.
 * Adapted from CSC2008 Practical 6
 */
public class Client extends JFrame {
    private Container c;
    private JButton logonButton;
    private JPanel logonFieldsPanel;
    private JPanel logonButtonPanel;
    private JTextArea outputArea;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private Socket socket;
    private ObjectInputStream clientInputStream;
    private ObjectOutputStream clientOutputStream;

    public Client() {
        super("Client");
        addWindowListener
                (new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.exit(0);
                     }
                 }
                );
        c = getContentPane();
        c.setLayout(new BorderLayout());

        logonFieldsPanel = new JPanel();
        logonFieldsPanel.setLayout(new GridLayout(2, 2, 5, 5));
        JLabel usernameLabel = new JLabel("Enter Username: ");
        logonFieldsPanel.add(usernameLabel);
        usernameField = new JTextField(10);
        logonFieldsPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Enter Password: ");
        logonFieldsPanel.add(passwordLabel);
        passwordField = new JPasswordField(10);
        logonFieldsPanel.add(passwordField);
        c.add(logonFieldsPanel, BorderLayout.CENTER);

        logonButtonPanel = new JPanel();
        logonButton = new JButton("logon");
        ButtonHandler bHandler = new ButtonHandler();
        logonButton.addActionListener(bHandler);
        logonButtonPanel.add(logonButton);
        c.add(logonButtonPanel, BorderLayout.SOUTH);

        setSize(300, 125);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]) {
        Client gameClient = new Client();
        gameClient.getConnections();
    }

    private void addOutput(String s) {
        outputArea.append(s + "\n");
        outputArea.setCaretPosition(outputArea.getText().length());
    }

    private void postLogin(boolean loggedOn, String mess) {
        c.remove(logonFieldsPanel);
        c.remove(logonButtonPanel);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);

        outputArea = new JTextArea(16, 30);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Verdana", Font.BOLD, 11));
        addOutput(mess);
        outputPanel.add(outputArea);
        outputPanel.add(new JScrollPane(outputArea));
        c.add(outputPanel, BorderLayout.NORTH);

        if (!loggedOn)
            closeStreams();
        else {
            addOutput("You logged in succcessfully!");
        }
        setSize(400, 425);
        setResizable(false);
        setVisible(true);
    }

    private void getConnections() {
        try {
            socket = new Socket(InetAddress.getLocalHost(), 6000);
            clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
            clientInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void sendLoginDetails() {
        try {
            Message username = new Message(usernameField.getText());
            username.encrypt();

            Message password = new Message(new String(passwordField.getPassword()));
            password.encrypt();

            clientOutputStream.writeObject(username);
            clientOutputStream.writeObject(password);
            /* read Boolean value sent by server - it is automatically converted to
              a primitive boolean value */
            boolean loggedOn = (Boolean) clientInputStream.readObject();

            String mess;
            if (loggedOn) {
                mess = (String) clientInputStream.readObject();
            } else {
                mess = "Logon unsuccessful.";
            }
            postLogin(loggedOn, mess);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void closeStreams() {
        try {
            clientInputStream.close();
            clientOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logonButton)
                sendLoginDetails();
        }
    }
}
