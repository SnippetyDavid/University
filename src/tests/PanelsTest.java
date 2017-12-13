package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mainWindow.Building;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the panels in the mainGame
 * 
 * @author Brogrammers
 *
 */
public class PanelsTest {
	
	ArrayList<String> playerNames = new ArrayList<String>();

	private LeftPanel leftPanel;
	private RightPanel rightPanel;

	@SuppressWarnings("static-access")
	@Before
	public void setup() {
		
		playerNames.add("1234");
		playerNames.add("Norman");
		playerNames.add("John Doe");
		playerNames.add("");

		leftPanel = new LeftPanel(playerNames);
		rightPanel = new RightPanel();
		rightPanel.setCurrentPlayer(1);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberPlayers() {
		Assert.assertEquals(4, leftPanel.getTotalPlayers());
		leftPanel.setTotalPlayers(2);
		Assert.assertEquals(2, leftPanel.getTotalPlayers());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPlayers(){
		assertEquals("1234", leftPanel.getPlayer1().getPlayerName());
		assertEquals(0, leftPanel.getPlayer1().getPlayerPos());
		assertEquals(1000, leftPanel.getPlayer1().getPlayerMoney());
		assertEquals(1, leftPanel.getPlayer1().getPlayerNum());
		assertEquals("Norman", leftPanel.getPlayer2().getPlayerName());
		assertEquals(0, leftPanel.getPlayer2().getPlayerPos());
		assertEquals(1000, leftPanel.getPlayer2().getPlayerMoney());
		assertEquals(2, leftPanel.getPlayer2().getPlayerNum());
		assertEquals("John Doe", leftPanel.getPlayer3().getPlayerName());
		assertEquals(0, leftPanel.getPlayer3().getPlayerPos());
		assertEquals(1000, leftPanel.getPlayer3().getPlayerMoney());
		assertEquals(3, leftPanel.getPlayer3().getPlayerNum());
		assertEquals("", leftPanel.getPlayer4().getPlayerName());
		assertEquals(0, leftPanel.getPlayer4().getPlayerPos());
		assertEquals(1000, leftPanel.getPlayer4().getPlayerMoney());
		assertEquals(4, leftPanel.getPlayer4().getPlayerNum());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLabels() {
		Assert.assertEquals("1234 £1000", leftPanel.getPlayer1Label().getText());
		Assert.assertEquals("Norman £1000", leftPanel.getPlayer2Label().getText());
		Assert.assertEquals("John Doe £1000", leftPanel.getPlayer3Label().getText());
		Assert.assertEquals(" £1000", leftPanel.getPlayer4Label().getText());
		
		leftPanel.getPlayer1().setPlayerName("Joe");
		leftPanel.getPlayer2().setPlayerName("Bill");
		leftPanel.getPlayer3().setPlayerName("Bob");
		leftPanel.getPlayer4().setPlayerName("Mary");

		leftPanel.getPlayer1().setPlayerMoney(100);
		leftPanel.getPlayer2().setPlayerMoney(110);
		leftPanel.getPlayer3().setPlayerMoney(120);
		leftPanel.getPlayer4().setPlayerMoney(130);
		Building.updateLabels();

		Assert.assertEquals("Joe £100", leftPanel.getPlayer1Label().getText());
		Assert.assertEquals("Bill £110", leftPanel.getPlayer2Label().getText());
		Assert.assertEquals("Bob £120", leftPanel.getPlayer3Label().getText());
		Assert.assertEquals("Mary £130", leftPanel.getPlayer4Label().getText());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLogArea() {
		Assert.assertEquals("Welcome to Monopoly", rightPanel.getLogArea().getText());
		rightPanel.getLogArea().append("\nHello");
		Assert.assertEquals("Welcome to Monopoly\nHello", rightPanel.getLogArea().getText());

	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGetCurrentPlayer() {
		Assert.assertEquals(1, rightPanel.getCurrentPlayer());
		rightPanel.setCurrentPlayer(3);
		Assert.assertEquals(3, rightPanel.getCurrentPlayer());
	}
}
