import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<String> dwarves = new ArrayList<String>();
		dwarves.add("Thorin");
		dwarves.add("Dwalin");
		dwarves.add("Balin");
		dwarves.add("Gloin");
		dwarves.add("Kili");
		dwarves.add("Fili");
		dwarves.add("Dori");
		dwarves.add("Nori");
		dwarves.add("Ori");
		dwarves.add("Oin");
		dwarves.add("Bifur");
		dwarves.add("Bombur");
		dwarves.add("Bofur");
		System.out.println("The LOTR dwarves are: ");
		for(int i = 0; i<dwarves.size();i++) {
			System.out.println(dwarves.get(i));
		}
		
		System.out.println();

		ArrayList<String> dwarfs = new ArrayList<String>();
		dwarfs.add("Doc");
		dwarfs.add("Grumpy");
		dwarfs.add("Happy");
		dwarfs.add("Sleepy");
		dwarfs.add("Dopey");
		dwarfs.add("Bashful");
		dwarfs.add("Sneezy");
		System.out.println("The Disney dwarfs are: ");
		for(int i = 0; i<dwarfs.size();i++) {
			System.out.println(dwarfs.get(i));
		}
		
	}
}
