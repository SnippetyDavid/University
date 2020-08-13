package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import mainGame.PropertySetup;
import mainGame.Warping;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

/**
 * This class is used to test the warp class
 * 
 * @author Brogrammers
 */
public class WarpTest {
	
	ArrayList<String> playerNames = new ArrayList<String>();

	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	
	@Before
	public void setup() {
		
		playerNames.add("Player1");
		playerNames.add("Player2");
		playerNames.add("Player3");
		playerNames.add("Player4");

		leftPanel = new LeftPanel(playerNames);
		rightPanel = new RightPanel();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testWarpP1() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1, rightPanel.getCurrentPlayer());
		
		leftPanel.getPlayer1().setPlayerPos(PropertySetup.getWarp().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		
		leftPanel.getPlayer1().setPlayerPos(PropertySetup.getWarp2().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		
		leftPanel.getPlayer1().setPlayerPos(PropertySetup.getWarp3().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer1().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testWarpP2() {
		rightPanel.setCurrentPlayer(2);
		assertEquals(2, rightPanel.getCurrentPlayer());
		
		leftPanel.getPlayer2().setPlayerPos(PropertySetup.getWarp().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		
		leftPanel.getPlayer2().setPlayerPos(PropertySetup.getWarp2().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		
		leftPanel.getPlayer2().setPlayerPos(PropertySetup.getWarp3().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer2().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testWarpP3() {
		rightPanel.setCurrentPlayer(3);
		assertEquals(3, rightPanel.getCurrentPlayer());
		
		leftPanel.getPlayer3().setPlayerPos(PropertySetup.getWarp().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		
		leftPanel.getPlayer3().setPlayerPos(PropertySetup.getWarp2().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		
		leftPanel.getPlayer3().setPlayerPos(PropertySetup.getWarp3().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer3().getPlayerPos());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testWarpP4() {
		rightPanel.setCurrentPlayer(4);
		assertEquals(4, rightPanel.getCurrentPlayer());
		
		leftPanel.getPlayer4().setPlayerPos(PropertySetup.getWarp().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		
		leftPanel.getPlayer4().setPlayerPos(PropertySetup.getWarp2().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		
		leftPanel.getPlayer4().setPlayerPos(PropertySetup.getWarp3().getPropPos());
		Warping.testWarp();
		assertNotSame(PropertySetup.getWarp().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp2().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
		assertNotSame(PropertySetup.getWarp3().getPropPos(), leftPanel.getPlayer4().getPlayerPos());
	}
}