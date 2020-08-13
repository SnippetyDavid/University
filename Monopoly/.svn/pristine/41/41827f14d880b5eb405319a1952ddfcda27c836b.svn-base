package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mainGame.PECParking;
import mainGame.RentAndLoans;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the rent and loans class
 * 
 * @author Brogrammers
 */
public class RentLoansTest {
	private ArrayList<String> players;
	LeftPanel leftPanel;
	RightPanel rightPanel;
	
	@Before
	public void setup() {
		players = new ArrayList<String>();
		players.add("player1");
		players.add("player2");
		players.add("player3");
		players.add("player4");
		leftPanel = new LeftPanel(players);
		rightPanel = new RightPanel();
	}
	
	@Test
	public void testSetPoolMoney() {
		RentAndLoans.setParkingPoolMoney(0);
		assertEquals(0, RentAndLoans.getParkingPoolMoney());
		RentAndLoans.setParkingPoolMoney(100);
		assertEquals(100, RentAndLoans.getParkingPoolMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPayRent() {
		RentAndLoans.setParkingPoolMoney(0);
		int monthlyRentPos=4;
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		RentAndLoans.payRent();
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		leftPanel.getPlayer1().setPlayerPos(monthlyRentPos);
		RentAndLoans.payRent();
		assertEquals(200,RentAndLoans.getParkingPoolMoney());
		assertEquals(800,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		leftPanel.getPlayer2().setPlayerPos(monthlyRentPos);
		RentAndLoans.payRent();
		assertEquals(400,RentAndLoans.getParkingPoolMoney());
		assertEquals(600,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		RentAndLoans.payRent();
		assertEquals(600,RentAndLoans.getParkingPoolMoney());
		assertEquals(600,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		leftPanel.getPlayer3().setPlayerPos(monthlyRentPos);
		RentAndLoans.payRent();
		assertEquals(800,RentAndLoans.getParkingPoolMoney());
		assertEquals(600,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		leftPanel.getPlayer4().setPlayerPos(monthlyRentPos);
		RentAndLoans.payRent();
		assertEquals(1000,RentAndLoans.getParkingPoolMoney());
		assertEquals(600,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(800,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPayLoan() {
		RentAndLoans.setParkingPoolMoney(0);
		int loanPos=38;
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		RentAndLoans.payLoan();
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		leftPanel.getPlayer1().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(100,RentAndLoans.getParkingPoolMoney());
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer2().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(200,RentAndLoans.getParkingPoolMoney());
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		leftPanel.getPlayer3().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(300,RentAndLoans.getParkingPoolMoney());
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		leftPanel.getPlayer4().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(400,RentAndLoans.getParkingPoolMoney());
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCollectParkingMoney() {
		RentAndLoans.setParkingPoolMoney(0);
		int loanPos=38;
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		leftPanel.getPlayer1().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(100,RentAndLoans.getParkingPoolMoney());
		
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer2().setPlayerPos(loanPos);
		RentAndLoans.payLoan();
		assertEquals(200,RentAndLoans.getParkingPoolMoney());
		
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		
		int monthlyRentPos=4;
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(monthlyRentPos);
		RentAndLoans.payRent();
		assertEquals(400,RentAndLoans.getParkingPoolMoney());
		
		assertEquals(700,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		
		int pecParkingPos = 20;
		
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(pecParkingPos);
		PECParking.collectParkingPoolMoney();
		assertEquals(0,RentAndLoans.getParkingPoolMoney());
		
		assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
	}
}