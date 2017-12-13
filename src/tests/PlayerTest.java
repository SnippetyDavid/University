package tests;

import static org.junit.Assert.*;
import mainGame.Player;
import mainGame.PropertySetup;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the Player class
 * 
 * @author Brogrammers
 */
public class PlayerTest {

	private Player player;

	@Before
	public void setup() {
		player = new Player("John", 0, 1000, 1);
		player.setSurrender(false);
	}

	@Test
	public void testSetPos() {
		Assert.assertEquals(0, player.getPlayerPos());
		int diceRoll = 10;
		int diceRoll2 = 7;
		player.setPlayerPos(player.getPlayerPos() + diceRoll);
		Assert.assertEquals(10, player.getPlayerPos());
		Assert.assertEquals(1000, player.getPlayerMoney());
		player.setPlayerPos(player.getPlayerPos() + diceRoll);
		Assert.assertEquals(20, player.getPlayerPos());
		Assert.assertEquals(1000, player.getPlayerMoney());
		player.setPlayerPos(player.getPlayerPos() + diceRoll);
		Assert.assertEquals(30, player.getPlayerPos());
		Assert.assertEquals(1000, player.getPlayerMoney());
		player.setPlayerPos(player.getPlayerPos() + diceRoll);
		Assert.assertEquals(0, player.getPlayerPos());
		Assert.assertEquals(1200, player.getPlayerMoney());
		player.setPlayerPos(player.getPlayerPos() + diceRoll2);
		Assert.assertEquals(7, player.getPlayerPos());
		Assert.assertEquals(1200, player.getPlayerMoney());
	}
	
	@Test
	public void testSetName() {
		Assert.assertEquals("John",player.getPlayerName());
		player.setPlayerName("Bill");
		Assert.assertEquals("Bill",player.getPlayerName());
	}
	
	@Test
	public void testSetNum() {
		Assert.assertEquals(1,player.getPlayerNum());
		player.setPlayerNum(2);
		Assert.assertEquals(2, player.getPlayerNum());
	}

	@Test
	public void testSetMoney() {
		assertEquals(1000, player.getPlayerMoney());
		player.setPlayerMoney(1500);
		assertEquals(1500, player.getPlayerMoney());
		player.setPlayerMoney(-200);
		assertEquals(-200,player.getPlayerMoney());
	}
	
	@Test
	public void testBuyProp() {
		assertEquals(1000, player.getPlayerMoney());
		assertEquals(0,player.getPropertiesArray().size());
		assertTrue(PropertySetup.getAdelaideTrain().isBuyable());
		player.buyProperty(PropertySetup.getAdelaideTrain());
		assertFalse(PropertySetup.getAdelaideTrain().isBuyable());
		assertEquals(800, player.getPlayerMoney());
		assertEquals(1,player.getPropertiesArray().size());
		assertFalse(PropertySetup.getShotCard().isBuyable());
		player.buyProperty(PropertySetup.getShotCard());
		assertFalse(PropertySetup.getShotCard().isBuyable());
		assertEquals(800, player.getPlayerMoney());
		assertEquals(1,player.getPropertiesArray().size());
		assertTrue(PropertySetup.getAir().isBuyable());
		player.buyProperty(PropertySetup.getAir());
		assertFalse(PropertySetup.getAir().isBuyable());
		assertEquals(650, player.getPlayerMoney());
		assertEquals(2,player.getPropertiesArray().size());
	}
	
	@Test
	public void endGameTest() {
		player.getPropertiesArray().add(PropertySetup.getAdelaideTrain());
		assertFalse(player.getPropertiesArray().isEmpty());
		player.setSurrender(true);
		assertTrue(player.getSurrender());
		player.endGame();
		assertTrue(player.getPropertiesArray().isEmpty());
	}
	
	@Test
	public void autoMortgageTest() {
		player.getPropertiesArray().add(PropertySetup.getAdelaideTrain());
		assertFalse(player.getPropertiesArray().isEmpty());
		player.setPlayerMoney(-50);
		player.autoMortgage();
		assertTrue(player.getPropertiesArray().isEmpty());
		assertEquals(50,player.getPlayerMoney());
	}
	
	@Test
	public void checkMoneyTest() {
		player.getPropertiesArray().add(PropertySetup.getAdelaideTrain());
		assertFalse(player.getPropertiesArray().isEmpty());
		player.setPlayerMoney(-50);
		player.checkMoney();
		assertTrue(player.getPropertiesArray().isEmpty());
		assertEquals(50,player.getPlayerMoney());
		player.setPlayerMoney(-50);
		assertFalse(player.getSurrender());
		player.checkMoney();
		assertTrue(player.getSurrender());
	}
}