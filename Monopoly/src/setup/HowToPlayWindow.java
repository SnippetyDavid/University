package setup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class HowToPlayWindow {
	
	private JFrame htpWindow;
	private JLabel title = new JLabel("");
	private JPanel container = new JPanel();
	private JTabbedPane tabArea = new JTabbedPane();
	
	//Tabs
	
	private JPanel generalTab;
	
	Dimension htpdim = Toolkit.getDefaultToolkit().getScreenSize();

	public HowToPlayWindow()
	{
		setupFrame();
		addPanels();
	}
	
	
	private void setupFrame()
	{
		htpWindow = new JFrame();
		htpWindow.setSize(600,480);
		htpWindow.setMaximumSize(new Dimension(600,480));
		htpWindow.setAlwaysOnTop(true);
		htpWindow.setResizable(false);
		htpWindow.setTitle("How To Play");
		htpWindow.setVisible(true);
		htpWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		htpWindow.setLocation(htpdim.width/2-htpWindow.getSize().width/2, htpdim.height/2-htpWindow.getSize().height/2);
	}
	
	private void addPanels()
	{
		htpWindow.add(container);
		container.setBackground(Color.DARK_GRAY);
		
		container.add(title);
		title.setText("How to Play");
		title.setFont(new Font("Consolas",Font.BOLD, 24));
		title.setForeground(Color.white);
		
		tabArea.setSize(450, 480);
		container.add(tabArea);
		//images
		JLabel generalPlay = new JLabel(new ImageIcon("images/HowToPlay/GeneralPlay.png"));
		JLabel trainandwarps = new JLabel(new ImageIcon("images/HowToPlay/TrainsWarps.png"));
		JLabel shotsLectures = new JLabel(new ImageIcon("images/HowToPlay/LecturesandShots.png"));
		tabArea.add("General Play", generalPlay);
		tabArea.add("Trains and Warp Zones", trainandwarps);
		tabArea.add("Lectures and Shot Cards", shotsLectures);
		
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				htpWindow.dispose();
			}
		});
		container.add(closeButton);
		
	}
}
