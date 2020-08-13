import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Dwarfe> dwarfes = new ArrayList<Dwarfe>();
		
		Dwarfe Thorin = new Dwarfe("Thorin","LOTR","Thorin.png");
		dwarfes.add(Thorin);
		Dwarfe Fili = new Dwarfe("Fili","LOTR","Fili.png");
		dwarfes.add(Fili);
		Dwarfe Kili = new Dwarfe("Kili","LOTR","Kili.png");
		dwarfes.add(Kili);
		Dwarfe Oin = new Dwarfe("Oin","LOTR","Oin.png");
		dwarfes.add(Oin);
		Dwarfe Gloin = new Dwarfe("Gloin","LOTR","Gloin.png");
		dwarfes.add(Gloin);
		Dwarfe Balin = new Dwarfe("Balin","LOTR","Balin.png");
		dwarfes.add(Balin);
		Dwarfe Dwalin = new Dwarfe("Dwalin","LOTR","Dwalin.png");
		dwarfes.add(Dwalin);
		Dwarfe Ori = new Dwarfe("Ori","LOTR","Ori.png");
		dwarfes.add(Ori);
		Dwarfe Dori = new Dwarfe("Dori","LOTR","Dori.png");
		dwarfes.add(Dori);
		Dwarfe Nori = new Dwarfe("Nori","LOTR","Nori.png");
		dwarfes.add(Nori);
		Dwarfe Bifur = new Dwarfe("Bifur","LOTR","Bifur.png");
		dwarfes.add(Bifur);
		Dwarfe Bofur = new Dwarfe("Bofur","LOTR","Bofur.png");
		dwarfes.add(Bofur);
		Dwarfe Bombur = new Dwarfe("Bombur","LOTR","Bombur.png");
		dwarfes.add(Bombur);
		
		Dwarfe Dopey = new Dwarfe("Dopey","Disney","Dopey.png");
		dwarfes.add(Dopey);
		Dwarfe Doc = new Dwarfe("Doc","Disney","Doc.png");
		dwarfes.add(Doc);
		Dwarfe Grumpy = new Dwarfe("Grumpy","Disney","Grumpy.png");
		dwarfes.add(Grumpy);
		Dwarfe Bashful = new Dwarfe("Bashful","Disney","Bashful.png");
		dwarfes.add(Bashful);
		Dwarfe Sneezy = new Dwarfe("Sneezy","Disney","Sneezy.png");
		dwarfes.add(Sneezy);
		Dwarfe Sleepy = new Dwarfe("Sleepy","Disney","Sleepy.png");
		dwarfes.add(Sleepy);
		Dwarfe Happy = new Dwarfe("Happy","Disney","Happy.png");
		dwarfes.add(Happy);
		
		for(int i=0; i<dwarfes.size();i++) {
			if(dwarfes.get(i).getAuthor().equals("LOTR")){
				System.out.println("LOTR Dwarves are : " + dwarfes.get(i).getName());
			} else {
				System.out.println("Disney Dwarves are : " + dwarfes.get(i).getName());
			}
		}
		
	}
}
