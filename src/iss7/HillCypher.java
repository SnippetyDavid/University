package iss7;

public class HillCypher {

	public static void main(String [] args) {
		float[][] key = {
				{15, 10, 14},
				{8, 17, 23},
				{19, 13, 5}
		};
		String p = "MARKFREQUENC";
		float[] vector;
		String ciphertext = "";
		
		// A = 65
		
		for (int i=0; i< p.length(); i+=3) {
			String sub = p.substring(i, i+3);
			vector = new float[3];
			char[] result = new char[3];
			
			for (int j=0; j<3; j++) {
				vector[j] = sub.charAt(j) - 65;
			}
			
			for (int k = 0; k < result.length; k++) {
				float counter = 0;
				for (int l = 0; l < 3; l++) {
					counter += key[k][l]*vector[l];
				}
				result[k] = (char)((counter % 26) + 65);
			}
			System.out.println(result);
			ciphertext += new String(result);
		}
		System.out.println(ciphertext);
		
		
	}

}
