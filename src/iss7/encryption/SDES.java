
public class SDES {
	
	/**
	 * Permutation and Substitution arrays
	 */	
	private static final int[] P10 = {3,5,2,7,4,10,1,9,8,6};
	private static final int[] P8 = {6,3,7,4,8,5,10,9};
	private static final int[] P4 = {2,4,3,1};
	private static final int[] IP = {2,6,3,1,4,8,5,7};
	private static final int[] EP = {4,1,2,3,2,3,4,1};
	private static final int[] INVERSE_P = {4,1,3,5,7,2,8,6};
	private static final int[][] S_BOX_0 = {
		{1,0,3,2},
		{3,2,1,0},
		{0,2,1,3},
		{3,1,3,2},
		};
	private static final int[][] S_BOX_1 = {
		{0,1,2,3},
		{2,0,1,3},
		{3,0,1,0},
		{2,1,0,3},
		};
		
	/**
	 * Empty constructor to prevent instantiation
	 */
	private SDES(){}
	
	
	/**
	 * This class is used to store the keys used in encryption
	 * having it as an inner class rather than a global variable
	 * is more secure as the keys live/die in the class and are not 
	 * visible on the stack.
	 *
	 */
	private static class KeyWrapper{
		private String key1,key2;
		private KeyWrapper(String k1, String k2){
			this.key1 = k1;
			this.key2 = k2;
		}
	}
	
	/**
	 * Shifts String to the left a given number of times
	 * @param num The amount of times to shift left
	 * @param bits String you want to shift left
	 * @return The shifted string
	 */
	private static String shiftLeft(int num, String bits){
		assert(bits.length() == 10);
		String temp1 = bits;
		String leftBits,rightBits;
		char tempChar;
		for(int x = 0; x < num; x++){
			tempChar = temp1.charAt(0);
			leftBits = temp1.substring(1, 5) + tempChar;
			tempChar = temp1.charAt(5);
			rightBits = temp1.substring(6,10) + tempChar;
			temp1 = leftBits + rightBits;
		}
		
		return temp1;
	}
	
	
	/**
	 * This method uses the 10 bit source key to generate two
	 * 8 bit sub keys to be used in the encryption method.
	 * @return The Keywrapper object with the two keys
	 */
	private static KeyWrapper generateKeys(){
		String p10Transformed;
		String key1,key2;
		final String SOURCE_KEY = "1111011000"; 
		//KEY 1
		p10Transformed = permutation(P10,SOURCE_KEY);
		key1 = shiftLeft(1,p10Transformed);
		key1 = permutation(P8,key1);
		
		//KEY 2
		key2 = shiftLeft(3,p10Transformed);
		key2 = permutation(P8,key2);
		
		return new KeyWrapper(key1,key2);
	}
	
	/**
	 * This method first call "GenerateKeys" to retrieve required keys for encryption
	 * The plaintext is converted to its ASCII representation and stored in a byte array
	 * The ASCII code is then broken down into groups of 8 and converted to its binary representation
	 * 0s are added if padding is necessary then stored in a String array.
	 * Each element in the binary array is then modified by P10 Permutation, FFunction with Key 1,
	 * the first four and last four bits are then swapped, put through the FFunction with Key 2
	 * and then finally Inverse Permutation is applied.
	 * Each iteration gets added to the StringBuilder cipher and gets converted to a String and stored.
	 * @param plaintext String to be encrypted
	 * @return The ciphertext
	 */
	public static String encrypt(String plaintext){
		assert(plaintext != null);
		StringBuilder sbCipher = new StringBuilder();
		KeyWrapper keys = generateKeys();
		//Breaking text into Ascii then getting the binary version
		//Adding 0s if it's not 8 bits long.
		byte[] ascii = plaintext.getBytes();
		String[] binary = new String[ascii.length];
		for(int x = 0; x < ascii.length; x++){
			binary[x] = Integer.toBinaryString(ascii[x]);
			//Padding
			binary[x] = "00000000".substring(binary[x].length()) + binary[x];
		}		
		for(int x = 0; x < binary.length; x++){	
			//IP
			binary[x] = permutation(IP,binary[x]);
			//F with Key 1
			binary[x] = fFunction(binary[x], keys.key1);
			//Swap
			binary[x] = swap8(binary[x]);
			//F with Key 2
			binary[x] = fFunction(binary[x], keys.key2);
			//Inverse P
			binary[x] = permutation(INVERSE_P,binary[x]);
			//Add to ciphertext
			sbCipher.append(binary[x]);
		}
		return sbCipher.toString();
	}
	
	/**
	 * This method swaps the first four and the last four bits
	 * @param bits The String of bits you want swapped
	 * @return swapped bits string
	 */
	private static String swap8(String bits){
		assert(bits.length() == 8);
		return bits.substring(4, 8) + bits.substring(0, 4);
	}
	
	/**
	 * This method is used to perform s-box transforms on enterted text.
	 * The binary characters at position 0 + 3 are combined at converted 
	 * to integers which represent the row for the sBox and the binary characters at
	 * 1 + 4 are used for the column. The integer value at the specified S-Box location
	 * is then converted to its binary representation. If there is only 1 bit required
	 * then a 0 is added for padding.  
	 * @param sBox The subtitution box to be used
	 * @param bits The bits to be S-Box transformed
	 * @return Transformed bit String
	 */
	private static String sBOXTransform(int[][] sBox, String bits){
		
		assert(bits.length() == 4);
		StringBuilder sb = new StringBuilder();
		int row,column, val;
		String temp;
		
		sb.append(bits.charAt(0));
		sb.append(bits.charAt(3));
		row = Integer.parseInt(sb.toString(),2);
		sb.delete(0, sb.length());
		sb.append(bits.charAt(1));
		sb.append(bits.charAt(2));
		column = Integer.parseInt(sb.toString(),2);
		
		val = sBox[row][column];
		temp = Integer.toBinaryString(val);
		
		//Pad with 0 if less than 2 bits
		if(temp.length() < 2){
			temp = "0" + temp; 
		}
		return temp;
	}
	
	/**
	 * This method rearranges the given string by the given permutation 
	 * @param p The permutation
	 * @param bits The string to be permuted
	 * @return Permuted String
	 */
	private static String permutation(int[] p, String bits){
		assert(!(p==null) && !(bits==null));
		StringBuilder sb = new StringBuilder();
		for(int x = 0; x < p.length; x++){
			sb.append(bits.charAt(p[x]-1));
		}
		return sb.toString();
	}
	
	/**
	 * This method performs an Exclusive OR operation on two Strings
	 * and returns the result.
	 * @param one First string to be XOR'd
	 * @param two Second String to be XOR'd
	 * @return XOR'd result
	 */
	private static String xor(String one, String two){
		assert(one.length() == two.length());
		StringBuilder xor = new StringBuilder();
		for(int y = 0; y < one.length(); y++){
			xor.append(one.charAt(y) ^ two.charAt(y));
		}
		return xor.toString();
	}
	
	/**
	 * This method takes a binary representation String and a Key.
	 * The string is split into the 4 left bits and 4 right bits.
	 * An EP permutation is applied to the right 4 bits. The result
	 * is then XOR'd with a Key and then split again into 4 left 
	 * and 4 right bits. The left bits are put through an S-Box transform
	 * and the right bits are put through a different S-Box transform. The 
	 * two results are combined into a 4 bit string and put through a P4 
	 * Permutation and then XOR'd with the original leftBits and finally
	 * combined with the original right bits then returned.
	 * @param binary String Binary representation. 
	 * @param key The key used for the XOR function.
	 * @return String of bits that have been modified by the FFunction
	 */
	private static String fFunction(String binary, String key){
		assert(binary.length() == 8);
		String fResult, fLeft,fRight,leftBits,rightBits;
		//Split 8 bits into left and right
		leftBits = binary.substring(0, 4);
		rightBits = binary.substring(4, 8);
		
		//EP on right bits
		fResult = permutation(EP,rightBits);
		
		//XOR Key + EP Transformed right bits
		fResult = xor(fResult,key);
		
		//sBox transforms
		fLeft = fResult.substring(0, 4);
		fRight = fResult.substring(4, 8);
		fLeft = sBOXTransform(S_BOX_0,fLeft);		
		fRight = sBOXTransform(S_BOX_1,fRight);
		fResult = fLeft + fRight;
		
		//P4 Transform
		fResult = permutation(P4,fResult);
		
		//XOR with Left bits + FResult
		return xor(leftBits,fResult) + rightBits;
	}
	
	public static void main(String[] args) {
		String testAns = "10001111";
		String cipher = (encrypt("T"));
		System.out.println(cipher);
		assert(testAns.equals(cipher));
		
	}
}


