package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;

import mainGame.Questions;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;


public class QuestionTest {
	
	ArrayList<String> playerNames = new ArrayList<String>();
	private Questions trueQuestion;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	
	@Before
	public void setup() {
		playerNames.add("1234");
		playerNames.add("Norman");
		playerNames.add("John Doe");
		playerNames.add("");
		
		leftPanel = new LeftPanel(playerNames);
		rightPanel = new RightPanel();
		trueQuestion = new Questions("Answer True",0);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testQuestion() {
		rightPanel.setCurrentPlayer(1);
		assertEquals(1000, leftPanel.getPlayer1().getPlayerMoney());
		Object[] trueOrFalse = { "True", "False" };
		int selection = JOptionPane.showOptionDialog(null,
				trueQuestion.getQuestionDes(),
				"Question Time!", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, trueOrFalse, "True");
		
		if(selection == trueQuestion.getAnswer())
		{
			trueQuestion.correctResult();
			assertEquals(1100,leftPanel.getPlayer1().getPlayerMoney());
		}
		else
		{
			trueQuestion.wrongResult();
			assertEquals(800,leftPanel.getPlayer1().getPlayerMoney());
		}
	}
}