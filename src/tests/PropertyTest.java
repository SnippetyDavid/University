package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import mainGame.Dice;
import mainGame.Properties;
import mainGame.PropertySetup;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test the property class
 * 
 * @author Brogrammers
 */
public class PropertyTest {

	private ArrayList<String> players;
	private Properties myProperty;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	Dice dice;
	
	@Before
	public void setup() {
		myProperty = new Properties("Belfast", 5, 100, 50, 25, true, 50, 50, "Black");
		players = new ArrayList<String>();
		players.add("player1");
		players.add("player2");
		players.add("player3");
		players.add("player4");
		leftPanel = new LeftPanel(players);
		rightPanel = new RightPanel();
		dice = new Dice();
	}
	
	@Test
	public void testGetters() {
		assertEquals(PropertySetup.getProps().get(0),PropertySetup.getGo()); 
		assertEquals(PropertySetup.getProps().get(1),PropertySetup.getAgincourtAve()); 
		assertEquals(PropertySetup.getProps().get(2),PropertySetup.getShotCard()); 
		assertEquals(PropertySetup.getProps().get(3),PropertySetup.getTatesAve()); 
		assertEquals(PropertySetup.getProps().get(4),PropertySetup.getMonthlyRent()); 
		assertEquals(PropertySetup.getProps().get(5),PropertySetup.getAdelaideTrain()); 
		assertEquals(PropertySetup.getProps().get(6),PropertySetup.getBcbRubble()); 
		assertEquals(PropertySetup.getProps().get(7),PropertySetup.getWarp()); 
		assertEquals(PropertySetup.getProps().get(8),PropertySetup.getDunluceAve()); 
		assertEquals(PropertySetup.getProps().get(9),PropertySetup.getMaloneAve()); 
		assertEquals(PropertySetup.getProps().get(10),PropertySetup.getJail()); 
		assertEquals(PropertySetup.getProps().get(11),PropertySetup.getSoca()); 
		assertEquals(PropertySetup.getProps().get(12),PropertySetup.getNie()); 
		assertEquals(PropertySetup.getProps().get(13),PropertySetup.getTheologyCentre()); 
		assertEquals(PropertySetup.getProps().get(14),PropertySetup.getMaloneRoad()); 
		assertEquals(PropertySetup.getProps().get(15),PropertySetup.getCityHospitalTrain()); 
		assertEquals(PropertySetup.getProps().get(16),PropertySetup.getFitzwilliamStreet()); 
		assertEquals(PropertySetup.getProps().get(17),PropertySetup.getShotCard2()); 
		assertEquals(PropertySetup.getProps().get(18),PropertySetup.getGeographyBuilding()); 
		assertEquals(PropertySetup.getProps().get(19),PropertySetup.getEcsBuilding()); 
		assertEquals(PropertySetup.getProps().get(20),PropertySetup.getParking()); 
		assertEquals(PropertySetup.getProps().get(21),PropertySetup.getBoojum()); 
		assertEquals(PropertySetup.getProps().get(22),PropertySetup.getWarp2()); 
		assertEquals(PropertySetup.getProps().get(23),PropertySetup.getPec()); 
		assertEquals(PropertySetup.getProps().get(24),PropertySetup.getAshbyBuilding()); 
		assertEquals(PropertySetup.getProps().get(25),PropertySetup.getBotanicTrain()); 
		assertEquals(PropertySetup.getProps().get(26),PropertySetup.getMcClayLibrary()); 
		assertEquals(PropertySetup.getProps().get(27),PropertySetup.getPeterFroggatCentre()); 
		assertEquals(PropertySetup.getProps().get(28),PropertySetup.getAir()); 
		assertEquals(PropertySetup.getProps().get(29),PropertySetup.getMbc()); 
		assertEquals(PropertySetup.getProps().get(30),PropertySetup.getGotoLecture()); 
		assertEquals(PropertySetup.getProps().get(31),PropertySetup.getWhitlaHall()); 
		assertEquals(PropertySetup.getProps().get(32),PropertySetup.getDkb()); 
		assertEquals(PropertySetup.getProps().get(33),PropertySetup.getShotCard3()); 
		assertEquals(PropertySetup.getProps().get(34),PropertySetup.getStudentUnion()); 
		assertEquals(PropertySetup.getProps().get(35),PropertySetup.getCentralTrain()); 
		assertEquals(PropertySetup.getProps().get(36),PropertySetup.getWarp3()); 
		assertEquals(PropertySetup.getProps().get(37),PropertySetup.getBotanicGardens()); 
		assertEquals(PropertySetup.getProps().get(38),PropertySetup.getLoan()); 
		assertEquals(PropertySetup.getProps().get(39),PropertySetup.getLanyonBuilding()); 
	}
	
	@Test
	public void testSetName() {
		Assert.assertEquals("Belfast", myProperty.getPropertyName());
		myProperty.setPropertyName("Dublin");
		Assert.assertEquals("Dublin", myProperty.getPropertyName());
	}
	
	@Test
	public void testSetPropCost() {
		Assert.assertEquals(100, myProperty.getPropertyCost());
		myProperty.setPropertyCost(150);
		Assert.assertEquals(150, myProperty.getPropertyCost());
	}
	
	@Test
	public void testSetMortgage() {
		Assert.assertEquals(50, myProperty.getMortgageValue());
		myProperty.setMortgageValue(75);
		Assert.assertEquals(75, myProperty.getMortgageValue());
	}
	
	@Test
	public void testSetCostFlat() {
		Assert.assertEquals(50, myProperty.getCostBuyFlat());
		myProperty.setCostBuyFlat(85);
		Assert.assertEquals(85, myProperty.getCostBuyFlat());
	}
	
	@Test
	public void testSetCostHall() {
		Assert.assertEquals(50, myProperty.getCostBuyHalls());
		myProperty.setCostBuyHall(90);
		Assert.assertEquals(90, myProperty.getCostBuyHalls());
	}

	@Test
	public void testSetRent() {
		Assert.assertEquals(25, myProperty.getRent());
		myProperty.setRent(10);
		Assert.assertEquals(10, myProperty.getRent());
	}
	
	@Test
	public void testSetFlats() {
		Assert.assertEquals(0, myProperty.getFlats());
		myProperty.setFlats(10);
		Assert.assertEquals(10, myProperty.getFlats());
	}
	
	@Test
	public void testsetHalls() {
		Assert.assertEquals(0, myProperty.getHalls());
		myProperty.setHalls(17);
		Assert.assertEquals(17, myProperty.getHalls());
	}
	
	@Test
	public void testSetColor() {
		Assert.assertEquals("Black", myProperty.getPropColour());
		myProperty.setPropColour("Blue");
		Assert.assertEquals("Blue", myProperty.getPropColour());
	}
	
	@Test
	public void testPropPos() {
		Assert.assertEquals(5, myProperty.getPropPos());
		myProperty.setPropPos(1);
		Assert.assertEquals(1, myProperty.getPropPos());
	}
	
	@Test
	public void testGetRent() {
		assertEquals(25, myProperty.getRent());
		myProperty.setFlats(3);
		assertEquals(175, myProperty.getRent());
		myProperty.setFlats(0);
		assertEquals(25, myProperty.getRent());
		myProperty.setHalls(4);
		assertEquals(425, myProperty.getRent());
		myProperty.setHalls(0);
		assertEquals(25, myProperty.getRent());
		myProperty.setFlats(2);
		myProperty.setHalls(2);
		assertEquals(325, myProperty.getRent());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBuy() {
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(1);
		PropertySetup.buyProperty();
		if(!leftPanel.getPlayer1().getPropertiesArray().isEmpty())
		{
			assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
			assertFalse(PropertySetup.getAgincourtAve().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
			assertTrue(PropertySetup.getAgincourtAve().isBuyable());
		}
		
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer2().setPlayerPos(3);
		PropertySetup.buyProperty();
		if(!leftPanel.getPlayer2().getPropertiesArray().isEmpty())
		{
			assertEquals(960,leftPanel.getPlayer2().getPlayerMoney());
			assertFalse(PropertySetup.getTatesAve().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
			assertTrue(PropertySetup.getTatesAve().isBuyable());
		}
		
		rightPanel.setCurrentPlayer(3);
		leftPanel.getPlayer3().setPlayerPos(6);
		PropertySetup.buyProperty();
		if(!leftPanel.getPlayer3().getPropertiesArray().isEmpty())
		{
			assertEquals(900,leftPanel.getPlayer3().getPlayerMoney());
			assertFalse(PropertySetup.getBcbRubble().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer3().getPlayerMoney());
			assertTrue(PropertySetup.getBcbRubble().isBuyable());
		}
		
		rightPanel.setCurrentPlayer(4);
		leftPanel.getPlayer4().setPlayerPos(8);
		PropertySetup.buyProperty();
		if(!leftPanel.getPlayer4().getPropertiesArray().isEmpty())
		{
			assertEquals(900,leftPanel.getPlayer4().getPlayerMoney());
			assertFalse(PropertySetup.getDunluceAve().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer4().getPlayerMoney());
			assertTrue(PropertySetup.getDunluceAve().isBuyable());
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRent() {
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer2().setPlayerPos(PropertySetup.getAshbyBuilding().getPropPos());
		PropertySetup.buyProperty();
		
		if(!leftPanel.getPlayer2().getPropertiesArray().isEmpty())
		{
			assertEquals(760,leftPanel.getPlayer2().getPlayerMoney());
			assertFalse(PropertySetup.getAshbyBuilding().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
			assertTrue(PropertySetup.getAshbyBuilding().isBuyable());
		}
		
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(PropertySetup.getAshbyBuilding().getPropPos());
		PropertySetup.rent();
		
		if(!leftPanel.getPlayer2().getPropertiesArray().isEmpty())
		{
			assertEquals(980,leftPanel.getPlayer1().getPlayerMoney());
			assertEquals(780,leftPanel.getPlayer2().getPlayerMoney());		
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
			assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());		
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUtilityRent() {
		
		rightPanel.setCurrentPlayer(2);
		leftPanel.getPlayer2().setPlayerPos(PropertySetup.getAir().getPropPos());
		PropertySetup.buyProperty();
		
		if(!leftPanel.getPlayer2().getPropertiesArray().isEmpty())
		{
			assertEquals(850,leftPanel.getPlayer2().getPlayerMoney());
			assertFalse(PropertySetup.getAir().isBuyable());
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
			assertTrue(PropertySetup.getAir().isBuyable());
		}
		
		rightPanel.setCurrentPlayer(1);
		leftPanel.getPlayer1().setPlayerPos(PropertySetup.getAir().getPropPos());
		dice.setDice(5, 5);
		PropertySetup.payUtilityRent();
		
		if(!leftPanel.getPlayer2().getPropertiesArray().isEmpty())
		{
			assertEquals(960,leftPanel.getPlayer1().getPlayerMoney());
			assertEquals(890,leftPanel.getPlayer2().getPlayerMoney());
			
			rightPanel.setCurrentPlayer(2);
			leftPanel.getPlayer2().setPlayerPos(PropertySetup.getNie().getPropPos());
			PropertySetup.buyProperty();
			rightPanel.setCurrentPlayer(1);
			leftPanel.getPlayer1().setPlayerPos(PropertySetup.getNie().getPropPos());
			dice.setDice(6, 6);
			PropertySetup.payUtilityRent();		
			if(!leftPanel.getPlayer2().getPropertiesArray().contains(PropertySetup.getNie()))
			{
				assertEquals(960,leftPanel.getPlayer1().getPlayerMoney());
				assertEquals(890,leftPanel.getPlayer2().getPlayerMoney());
			}
			else
			{
				assertEquals(840,leftPanel.getPlayer1().getPlayerMoney());
				assertEquals(860,leftPanel.getPlayer2().getPlayerMoney());
			}
		}
		else
		{
			assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
			assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
			
			rightPanel.setCurrentPlayer(2);
			leftPanel.getPlayer2().setPlayerPos(PropertySetup.getNie().getPropPos());
			PropertySetup.buyProperty();
			rightPanel.setCurrentPlayer(1);
			leftPanel.getPlayer1().setPlayerPos(PropertySetup.getNie().getPropPos());
			dice.setDice(6, 6);
			PropertySetup.payUtilityRent();		
			if(!leftPanel.getPlayer2().getPropertiesArray().contains(PropertySetup.getNie()))
			{
				assertEquals(1000,leftPanel.getPlayer1().getPlayerMoney());
				assertEquals(1000,leftPanel.getPlayer2().getPlayerMoney());
			}
			else
			{
				assertEquals(952,leftPanel.getPlayer1().getPlayerMoney());
				assertEquals(898,leftPanel.getPlayer2().getPlayerMoney());
			}
		}
	}
}