package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
















import mainGame.PropertySetup;
import mainGame.ShotCards;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the shot card class. The reason for the test advance methods is
 * because of the middle panel throwing up null pointer exceptions for moving the player images.
 * The test methods are exactly the same as the normal method except with no reference to the 
 * middle panel
 * 
 * @author Brogrammers
 */
public class ShotCardTest {
	
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
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdvanceBoojum() {
		int boojumPos = 21;
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		ShotCards.testAdvanceBoojum();
		assertEquals(boojumPos,leftPanel.getPlayer1().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		rightPanel.setCurrentPlayer(2);
		ShotCards.testAdvanceBoojum();
		assertEquals(boojumPos,leftPanel.getPlayer1().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer2().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		leftPanel.getPlayer1().setPlayerPos(0);
		rightPanel.setCurrentPlayer(3);
		ShotCards.testAdvanceBoojum();
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer2().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer3().getPlayerPos());
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		rightPanel.setCurrentPlayer(4);
		ShotCards.testAdvanceBoojum();
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer2().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer3().getPlayerPos());
		assertEquals(boojumPos,leftPanel.getPlayer4().getPlayerPos());	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdvanceGo() {
		int goPos = PropertySetup.getGo().getPropPos();
		assertEquals(0,goPos);
		
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(10);
		assertEquals(10,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceGo();
		assertEquals(goPos,leftPanel.getPlayer1().getPlayerPos());
		
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer1().setPlayerPos(17);
		assertEquals(17,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceGo();
		assertEquals(goPos,leftPanel.getPlayer2().getPlayerPos());
		
		rightPanel.setCurrentPlayer(3);
		leftPanel.getPlayer1().setPlayerPos(20);
		assertEquals(20,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceGo();
		assertEquals(goPos,leftPanel.getPlayer3().getPlayerPos());
		
		rightPanel.setCurrentPlayer(4);
		leftPanel.getPlayer1().setPlayerPos(34);
		assertEquals(34,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceGo();
		assertEquals(goPos,leftPanel.getPlayer4().getPlayerPos());

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdvanceBotanic() {
		int botPos = PropertySetup.getBotanicTrain().getPropPos();
		assertEquals(25, botPos);
		
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceBotanic();
		assertEquals(botPos,leftPanel.getPlayer1().getPlayerPos());
		
		rightPanel.setCurrentPlayer(2);
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		ShotCards.testAdvanceBotanic();
		assertEquals(botPos,leftPanel.getPlayer2().getPlayerPos());
		
		rightPanel.setCurrentPlayer(3);
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		ShotCards.testAdvanceBotanic();
		assertEquals(botPos,leftPanel.getPlayer3().getPlayerPos());
		
		rightPanel.setCurrentPlayer(4);
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		ShotCards.testAdvanceBotanic();
		assertEquals(botPos,leftPanel.getPlayer4().getPlayerPos());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testAdvanceLanyon() {
		int lanyonPos = PropertySetup.getLanyonBuilding().getPropPos();
		assertEquals(39, lanyonPos);
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceLanyon();
		assertEquals(lanyonPos,leftPanel.getPlayer1().getPlayerPos());
		
		rightPanel.setCurrentPlayer(2);
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		ShotCards.testAdvanceLanyon();
		assertEquals(lanyonPos,leftPanel.getPlayer2().getPlayerPos());
		
		rightPanel.setCurrentPlayer(3);
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		ShotCards.testAdvanceLanyon();
		assertEquals(lanyonPos,leftPanel.getPlayer3().getPlayerPos());
		
		rightPanel.setCurrentPlayer(4);
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		ShotCards.testAdvanceLanyon();
		assertEquals(lanyonPos,leftPanel.getPlayer4().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdvanceJail(){
		int jailPos = PropertySetup.getGotoLecture().getPropPos();
		assertEquals(30,jailPos);
		
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testAdvanceJail();
		assertEquals(jailPos,leftPanel.getPlayer1().getPlayerPos());
		
		rightPanel.setCurrentPlayer(2);
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		ShotCards.testAdvanceJail();
		assertEquals(jailPos,leftPanel.getPlayer2().getPlayerPos());
		
		rightPanel.setCurrentPlayer(3);
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		ShotCards.testAdvanceJail();
		assertEquals(jailPos,leftPanel.getPlayer3().getPlayerPos());
		
		rightPanel.setCurrentPlayer(4);
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		ShotCards.testAdvanceJail();
		assertEquals(jailPos,leftPanel.getPlayer4().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBackThreeSpaces() {
		int back3fromGo = PropertySetup.getBotanicGardens().getPropPos();
		assertEquals(37, back3fromGo);
		
		rightPanel.setCurrentPlayer(1);
		assertEquals(0,leftPanel.getPlayer1().getPlayerPos());
		ShotCards.testBackThreeSpaces();
		assertEquals(back3fromGo, leftPanel.getPlayer1().getPlayerPos());
		
		rightPanel.setCurrentPlayer(2);
		assertEquals(0,leftPanel.getPlayer2().getPlayerPos());
		ShotCards.testBackThreeSpaces();
		assertEquals(back3fromGo,leftPanel.getPlayer2().getPlayerPos());
		
		rightPanel.setCurrentPlayer(3);
		assertEquals(0,leftPanel.getPlayer3().getPlayerPos());
		ShotCards.testBackThreeSpaces();
		assertEquals(back3fromGo,leftPanel.getPlayer3().getPlayerPos());
		
		rightPanel.setCurrentPlayer(4);
		assertEquals(0,leftPanel.getPlayer4().getPlayerPos());
		ShotCards.testBackThreeSpaces();
		assertEquals(back3fromGo,leftPanel.getPlayer4().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCollectBursary() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.collectBursary();
		assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.collectBursary();
		assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.collectBursary();
		assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.collectBursary();
		assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1100,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCollectPlacement() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.collectPlacement();
		assertEquals(1500,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.collectPlacement();
		assertEquals(1500,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.collectPlacement();
		assertEquals(1500,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.collectPlacement();
		assertEquals(1500,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1500,leftPanel.getPlayer4().getPlayerMoney());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testCollectQuiz() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.collectQuiz();
		assertEquals(1025,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.collectQuiz();
		assertEquals(1025,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.collectQuiz();
		assertEquals(1025,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.collectQuiz();
		assertEquals(1025,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1025,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSubtractSpeeding() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.subtractSpeeding();
		assertEquals(985,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.subtractSpeeding();
		assertEquals(985,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.subtractSpeeding();
		assertEquals(985,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.subtractSpeeding();
		assertEquals(985,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(985,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSubtractTextbooks() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.subtractTextbooks();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.subtractTextbooks();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.subtractTextbooks();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.subtractTextbooks();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer4().getPlayerMoney());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testSubtractBills() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.subtractBills();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.subtractBills();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.subtractBills();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.subtractBills();
		assertEquals(900,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(900,leftPanel.getPlayer4().getPlayerMoney());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSubtractDrinks() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		ShotCards.subtractDrinks();
		assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(2);
		ShotCards.subtractDrinks();
		assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(3);
		ShotCards.subtractDrinks();
		assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
		rightPanel.setCurrentPlayer(4);
		ShotCards.subtractDrinks();
		assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(980,leftPanel.getPlayer4().getPlayerMoney());
	}
}