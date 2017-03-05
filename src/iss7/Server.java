import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Class to act as Server in remote server logon application for CSC3048 Assignment.
 * Adapted from CSC2008 Practical 6
 */
public class Server extends JFrame {
    private JTextArea outputArea;
    private ServerSocket serverSocket;

    public Server() {
        super("Server");
        addWindowListener
                (new WindowAdapter() {
                     public void windowClosing(WindowEvent e) {
                         System.exit(0);
                     }
                 }
                );
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        try {
            serverSocket = new ServerSocket(6000);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // create and add GUI components
        outputArea = new JTextArea(15, 30);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        c.add(outputArea);
        c.add(new JScrollPane(outputArea));

        setSize(350, 300);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]) {
        Server gameServer = new Server();
        gameServer.waitForData();
    }

    private void addOutput(String s) {
        outputArea.append(s + "\n");
        outputArea.setCaretPosition(outputArea.getText().length());
    }

    private void waitForData() {
        try {
            addOutput("Server is up and waiting for a connection...");

            Socket client = serverSocket.accept();
            ObjectInputStream serverInputStream = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream serverOutputStream = new ObjectOutputStream(client.getOutputStream());

            Message username = (Message) serverInputStream.readObject();
            Message password = (Message) serverInputStream.readObject();

            addOutput("\nLogin Details Received\n----------------------------------------");
            addOutput("encrypted username : " + username.getMessage());
            addOutput("encrypted password : " + password.getMessage());

            username.decrypt();
            password.decrypt();

            addOutput("decrypted username : " + username.getMessage());
            addOutput("decrypted password : " + password.getMessage());

            // Everything from here down needs to be removed. May be helpful for development though

            String[] names = {"mark", "joan", "bill", "jack"};
            String[] passwords = {"frequency", "secret", "row", "cryptography"};

            boolean valid = false;
            for (int i = 0; i < names.length; i++) {	/* test whether corresponding username and password is a match to
                   username and password received from client */
                if (names[i].equals(username.getMessage()) && passwords[i].equals(password.getMessage()))
                    valid = true;
            }

            if (!valid) {
                serverOutputStream.writeObject(Boolean.FALSE);
                addOutput("Logon denied - Boolean value false send to client");
            } else {
                serverOutputStream.writeObject(Boolean.TRUE);
                addOutput("Logon successful - Boolean value true send to client");
                serverOutputStream.writeObject("We're done here boiz");

            }

            addOutput("Done");
            // Useless things end here

            serverInputStream.close();
            serverOutputStream.close();
            client.close();
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}