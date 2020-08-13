package mainWindow;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import mainGame.Player;
@SuppressWarnings({ "unchecked", "rawtypes" })


public class TradeWindow extends JFrame {

	/**
	 * This class allows for trading of propeties and money between players
	 * 
	 * @author Brogrammers
	 */
	
	/**
	 * Declaration of instance variables
	 */
	private static final long serialVersionUID = 1L;
	private JPanel tradeOfferPanel, tradeCounterPanel;
	private JLabel tradeTitle, offerProperty, offerCash;

	private JComboBox tradeProps, otherPlayer, counterProps;
	private JSpinner numberChooser, numberChooser2;
	private JButton confirmButton, cancelButton;
	private Player current, tradeTo;
	
	public TradeWindow() {

		setupWindow();
	}

	/**
	 * Setting up the display and layout of the trade window
	 */
	private void setupWindow() {
		setSize(450, 250);

		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);

		setLayout(new GridBagLayout());
		setTitle("Trade");

		tradeOfferPanel = new JPanel();
		tradeCounterPanel = new JPanel();
		tradeTitle = new JLabel("",SwingConstants.CENTER);
		new JLabel("Other player",SwingConstants.CENTER);
		confirmButton = new JButton("Confirm");
		cancelButton = new JButton("Cancel");

		tradeOfferPanel.setBackground(Color.lightGray);
		tradeCounterPanel.setBackground(Color.lightGray);

		tradeProps = new JComboBox();
		otherPlayer = new JComboBox();
		
		/**
		 * Switch to set current player in trade and setup combo box of other players to select from to trade with
		 */
		switch (RightPanel.getCurrentPlayer()) {

		case 1:
			tradeProps.addItem("No property");
			for (int i = 0; i < LeftPanel.getPlayer1().getPropertiesArray()
					.size(); i++) {
				tradeProps.addItem(LeftPanel.getPlayer1().getPropertiesArray()
						.get(i).getPropertyName());
			}
			tradeTitle.setText(LeftPanel.getPlayer1().getPlayerName() + "'s offer");
			otherPlayer.removeAllItems();
			otherPlayer.addItem("Select another player");
			if (p2Check()){otherPlayer.addItem(LeftPanel.getPlayer2().getPlayerName());}
			if (p3Check()){otherPlayer.addItem(LeftPanel.getPlayer3().getPlayerName());}
			if (p4Check()){otherPlayer.addItem(LeftPanel.getPlayer4().getPlayerName());}
			current = LeftPanel.getPlayer1();
			break;

		case 2:
			tradeProps.addItem("No property");
			for (int i = 0; i < LeftPanel.getPlayer2().getPropertiesArray()
					.size(); i++) {
				tradeProps.addItem(LeftPanel.getPlayer2().getPropertiesArray()
						.get(i).getPropertyName());
			}
			tradeTitle.setText(LeftPanel.getPlayer2().getPlayerName() + "'s offer");
			otherPlayer.removeAllItems();
			otherPlayer.addItem("Select another player");
			if (p1Check()){otherPlayer.addItem(LeftPanel.getPlayer1().getPlayerName());}
			if (p3Check()){otherPlayer.addItem(LeftPanel.getPlayer3().getPlayerName());}
			if (p4Check()){otherPlayer.addItem(LeftPanel.getPlayer4().getPlayerName());}
			current = LeftPanel.getPlayer2();
			break;

		case 3:
			tradeProps.addItem("No property");
			for (int i = 0; i < LeftPanel.getPlayer3().getPropertiesArray()
					.size(); i++) {
				tradeProps.addItem(LeftPanel.getPlayer3().getPropertiesArray()
						.get(i).getPropertyName());
			}
			tradeTitle.setText(LeftPanel.getPlayer3().getPlayerName() + "'s offer");
			otherPlayer.removeAllItems();
			otherPlayer.addItem("Select another player");
			if (p1Check()){otherPlayer.addItem(LeftPanel.getPlayer1().getPlayerName());}
			if (p2Check()){otherPlayer.addItem(LeftPanel.getPlayer2().getPlayerName());}
			if (p4Check()){otherPlayer.addItem(LeftPanel.getPlayer4().getPlayerName());}
			current = LeftPanel.getPlayer3();
			break;

		case 4:
			tradeProps.addItem("No property");
			for (int i = 0; i < LeftPanel.getPlayer4().getPropertiesArray()
					.size(); i++) {
				tradeProps.addItem(LeftPanel.getPlayer4().getPropertiesArray()
						.get(i).getPropertyName());
			}
			tradeTitle.setText(LeftPanel.getPlayer4().getPlayerName() + "'s offer");
			otherPlayer.removeAllItems();
			otherPlayer.addItem("Select another player");
			if (p1Check()){otherPlayer.addItem(LeftPanel.getPlayer1().getPlayerName());}
			if (p2Check()){otherPlayer.addItem(LeftPanel.getPlayer2().getPlayerName());}
			if (p3Check()){otherPlayer.addItem(LeftPanel.getPlayer3().getPlayerName());}
			current = LeftPanel.getPlayer4();
			break;
		}

		tradeOfferPanel.setLayout(new GridBagLayout());
		tradeCounterPanel.setLayout(new GridBagLayout());
		
	
		addMain();
	}
	
	/**
	 * Setting up the offer panel layout
	 */
	private void addOffer(){
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		
		offerProperty = new JLabel("Property: ",SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeOfferPanel.add(offerProperty, c);
		
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeOfferPanel.add(tradeProps, c);
		
		offerCash = new JLabel("Cash: ",SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeOfferPanel.add(offerCash, c);
		
	
               SpinnerNumberModel numberModel = new SpinnerNumberModel(
                    new Integer(0), // value
                    new Integer(0), // min
                    new Integer(current.getPlayerMoney()), // max
                    new Integer(10) // step
                    );
                numberChooser = new JSpinner(numberModel);
      
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeOfferPanel.add(numberChooser, c);
		
		tradeOfferPanel.setBorder(new EmptyBorder(40,15,15,15));
    }
	
    /**
     * Setting up the counter offer panel
     */
	private void addCounter(){
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTHWEST;
		
		offerProperty = new JLabel("Property: ",SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeCounterPanel.add(offerProperty, c);
		
		offerCash = new JLabel("Cash: ",SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.5;
		c.weighty = 0.3;
		tradeCounterPanel.add(offerCash, c);
		
		 final SpinnerNumberModel numberModel = new SpinnerNumberModel(
                 new Integer(0), // value
                 new Integer(0), // min
                 new Integer(9999), // max
                 new Integer(10) // step
                 );
		 numberChooser2 = new JSpinner(numberModel);
		 
			c.gridx = 1;
			c.gridy = 1;
			c.weightx = 0.5;
			c.weighty = 0.3;
			tradeCounterPanel.add(numberChooser2, c);
		
			
			tradeCounterPanel.setBorder(new EmptyBorder(40,15,15,15));
			
			counterProps = new JComboBox();
			otherPlayer.addActionListener (new ActionListener () {

				public void actionPerformed(ActionEvent e) {
			        if (otherPlayer.getSelectedItem() == LeftPanel.getPlayer1().getPlayerName()){
			        	counterProps.removeAllItems();
			        	counterProps.addItem("No property");
			        	for (int i = 0; i < LeftPanel.getPlayer1().getPropertiesArray()
								.size(); i++) {
							counterProps.addItem(LeftPanel.getPlayer1().getPropertiesArray()
									.get(i).getPropertyName());
							
						}
			        	tradeTo = LeftPanel.getPlayer1();
			        }
			        if (otherPlayer.getSelectedItem() == LeftPanel.getPlayer2().getPlayerName()){
			        	counterProps.removeAllItems();
			        	counterProps.addItem("No property");
			        	for (int i = 0; i < LeftPanel.getPlayer2().getPropertiesArray()
								.size(); i++) {
							counterProps.addItem(LeftPanel.getPlayer2().getPropertiesArray()
									.get(i).getPropertyName());
							
						}
			        	tradeTo = LeftPanel.getPlayer2();
			        }
			        if (otherPlayer.getSelectedItem() == LeftPanel.getPlayer3().getPlayerName()){
			        	counterProps.removeAllItems();
			        	counterProps.addItem("No property");
			        	for (int i = 0; i < LeftPanel.getPlayer3().getPropertiesArray()
								.size(); i++) {
							counterProps.addItem(LeftPanel.getPlayer3().getPropertiesArray()
									.get(i).getPropertyName());
							
						}
			        	tradeTo = LeftPanel.getPlayer3();
			        }
			        if (otherPlayer.getSelectedItem() == LeftPanel.getPlayer4().getPlayerName()){
			        	counterProps.removeAllItems();
			        	counterProps.addItem("No property");
			        	for (int i = 0; i < LeftPanel.getPlayer4().getPropertiesArray()
								.size(); i++) {
							counterProps.addItem(LeftPanel.getPlayer4().getPropertiesArray()
									.get(i).getPropertyName());
						}
			        	tradeTo = LeftPanel.getPlayer4();
			        }
			    }
			});
			
			c.gridx = 1;
			c.gridy = 0;
			c.weightx = 0.5;
			c.weighty = 0.3;
			tradeCounterPanel.add(counterProps, c);
			
	}
	
	/**
	 * Adding the panels, title and buttons to the main window
	 */
	private void addMain() {
		addOffer();
		addCounter();
		setupButtons();
		
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;

		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 0.5;
		c.weighty = 0.1;
		add(tradeTitle, c);
	

		c.gridy = 1;
		c.gridx = 0;
		c.weightx = 0.5;
		c.weighty = 0.9;
		add(tradeOfferPanel, c);
		
		c.gridy = 0;
		c.gridx = 1;
		c.weightx = 0.5;
		c.weighty = 0.1;
		add(otherPlayer, c);
		
		c.gridy = 1;
		c.gridx = 1;
		c.weightx = 0.5;
		c.weighty = 0.9;
		add(tradeCounterPanel, c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 2;
		add(confirmButton, c);
		
		c.weightx = 0.5;
		c.weighty = 0.1;
		c.gridx = 1;
		c.gridy = 2;
		add(cancelButton, c);
	}
	
	/**
	 * Setting up the buttons
	 */
	private void setupButtons(){
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent build) {
				setVisible(false);
			}
		});
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent build) {
				if (otherPlayer.getSelectedItem() != "Select another player"){
					if (current.getPlayerMoney() >= (int)numberChooser.getValue() && tradeTo.getPlayerMoney() >= (int)numberChooser2.getValue()){	
				current.setPlayerMoney(current.getPlayerMoney() + (int)numberChooser2.getValue()-(int)numberChooser.getValue());
				tradeTo.setPlayerMoney(tradeTo.getPlayerMoney() + (int)numberChooser.getValue()-(int)numberChooser2.getValue());
				for (int i = 0; i < current.getPropertiesArray()
						.size(); i++) {
					if (current.getPropertiesArray().get(i).getPropertyName() == tradeProps.getSelectedItem()){
						tradeTo.getPropertiesArray().add(current.getPropertiesArray().get(i));
						current.getPropertiesArray().remove(i);
					}
				}
				for (int i = 0; i < tradeTo.getPropertiesArray()
						.size(); i++) {
					if (tradeTo.getPropertiesArray().get(i).getPropertyName() == counterProps.getSelectedItem()){
						current.getPropertiesArray().add(tradeTo.getPropertiesArray().get(i));
						tradeTo.getPropertiesArray().remove(i);
					}
				}
				JOptionPane.showMessageDialog(null, "Trade successful!");
				setVisible(false);
				LeftPanel.getPlayer1Label().setText(LeftPanel.getPlayer1().getPlayerName() + " £"
						+ LeftPanel.getPlayer1().getPlayerMoney());
				LeftPanel.getPlayer2Label().setText(LeftPanel.getPlayer2().getPlayerName() + " £"
						+ LeftPanel.getPlayer2().getPlayerMoney());
				if(LeftPanel.getTotalPlayers() >= 3)
				{
					LeftPanel.getPlayer3Label().setText(LeftPanel.getPlayer3().getPlayerName() + " £"
							+ LeftPanel.getPlayer3().getPlayerMoney());
					if(LeftPanel.getTotalPlayers() == 4)
					{
						LeftPanel.getPlayer4Label().setText(LeftPanel.getPlayer4().getPlayerName() + " £"
								+ LeftPanel.getPlayer4().getPlayerMoney());
					}
				}
				}else JOptionPane.showMessageDialog(null, "Insufficient funds!");}
				else JOptionPane.showMessageDialog(null, "Select a player to trade with!");
			}
		});
	}
	
	/**
	 * Checking if players are active in the game
	 * @return true or false accordingly for each
	 */
	public boolean p1Check(){
		if((LeftPanel.getPlayer1().getPlayerMoney()>0 || !(LeftPanel.getPlayer1().getPropertiesArray().isEmpty())) && LeftPanel.getPlayer1().getSurrender()==false ){
			return true;
		}else return false;
	}
	public boolean p2Check(){
		if((LeftPanel.getPlayer2().getPlayerMoney()>0 || !(LeftPanel.getPlayer2().getPropertiesArray().isEmpty())) && LeftPanel.getPlayer2().getSurrender()==false ){
			return true;
		}else return false;
	}
	public boolean p3Check(){
		if((LeftPanel.getPlayer3().getPlayerMoney()>0 || !(LeftPanel.getPlayer3().getPropertiesArray().isEmpty())) && LeftPanel.getPlayer3().getSurrender()==false && LeftPanel.getPlayer3().getPlayerName() != "P3" ){
			return true;
		}else return false;
	}
	public boolean p4Check(){
		if((LeftPanel.getPlayer4().getPlayerMoney()>0 || !(LeftPanel.getPlayer4().getPropertiesArray().isEmpty())) && LeftPanel.getPlayer4().getSurrender()==false && LeftPanel.getPlayer4().getPlayerName() != "P4" ){
			return true;
		}else return false;
	}
	public static void startTrade(){
		@SuppressWarnings("unused")
		TradeWindow trade = new TradeWindow();
	}
}
