package mainGame;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import mainWindow.Building;
import mainWindow.LeftPanel;
import mainWindow.RightPanel;

public class Questions {
	
	private static ArrayList<Questions>questions = new ArrayList<>();
	private String questionDes;
	private int answer;
	
	/**
	 * Questions from:
	 * http://www.dreamincode.net
	 * http://www.proprofs.com/
	 */
	//1 = false , 0 =true;
	static Questions one = new Questions("It is impossible to run a program if its total memory requirements exceed available RAM", 1);
	static Questions two = new Questions("Inside a computer, data is stored in binary form.",0);
	static Questions three = new Questions("A disk drive is a direct access storage device",0);
	static Questions four = new Questions("A disk drive is an example of a secondary storage device", 0);
	static Questions five = new Questions("Cache memory helps to prevent bottlenecks between a CPU and random access memory", 0);
	static Questions six = new Questions("Multitasking requires multiple processors", 1);
	static Questions seven = new Questions("Multiprocessing requires multiple processors", 0);
	static Questions eight= new Questions("Software uses hardware to perform tasks related to input", 0);

	public Questions(String qQuestionDes, int qAnswer){
		questionDes = qQuestionDes;
		answer = qAnswer;
	}
	
	
	public static ArrayList<Questions> questionArray(){
		questions.add(one);
		questions.add(two);
		questions.add(three);
		questions.add(four);
		questions.add(five);
		questions.add(six);
		questions.add(seven);
		questions.add(eight);
		
		return questions;
	}
	
	public static void chooseQuestion(){
		Random random = new Random();
		int Low = 0;
		int High = 7;
		int i = random.nextInt(High) + Low; 
	Object[] trueOrFalse = { "True", "False" };

	if(i>=questionArray().size() ){
		JOptionPane.showMessageDialog(null, "Sorry there are no more questions to ask!");
	}
	else{
	
	int selection = JOptionPane.showOptionDialog(null,
			questionArray().get(i).getQuestionDes(),
			"Question Time!", JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE, null, trueOrFalse, "False");
	
	if(questionArray().get(i).getAnswer() == selection){
		JOptionPane.showMessageDialog(null, "You have answered correctly! £100 will be added to your pot");
		correctResult();
	}
	
	else {
		JOptionPane.showMessageDialog(null, "You have answered incorrectly! £200 will be deducted from your pot");
		wrongResult();
	}
	questionArray().remove(i);
	}
	Building.updateLabels();
	
	}


	public String getQuestionDes() {
		return questionDes;
	}


	public int getAnswer() {
		return answer;
	}
	
	public static void correctResult() {
		if(LeftPanel.getPlayer1().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer1().setPlayerMoney(LeftPanel.getPlayer1().getPlayerMoney() + 100);
		}
		else if(LeftPanel.getPlayer2().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer2().setPlayerMoney(LeftPanel.getPlayer2().getPlayerMoney() + 100);
		}
		else if(LeftPanel.getPlayer3().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer3().setPlayerMoney(LeftPanel.getPlayer3().getPlayerMoney() + 100);
		}
		else if(LeftPanel.getPlayer4().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer4().setPlayerMoney(LeftPanel.getPlayer4().getPlayerMoney() + 100);
		}
	}
	
	public static void wrongResult() {
		if(LeftPanel.getPlayer1().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer1().setPlayerMoney(LeftPanel.getPlayer1().getPlayerMoney() - 200);
		}
		else if(LeftPanel.getPlayer2().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer2().setPlayerMoney(LeftPanel.getPlayer2().getPlayerMoney() - 200);
		}
		else if(LeftPanel.getPlayer3().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer3().setPlayerMoney(LeftPanel.getPlayer3().getPlayerMoney() - 200);
		}
		else if(LeftPanel.getPlayer4().getPlayerNum() == RightPanel.getCurrentPlayer()){
			LeftPanel.getPlayer4().setPlayerMoney(LeftPanel.getPlayer4().getPlayerMoney() - 200);
		}
	}
}
