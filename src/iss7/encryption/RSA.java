package encryption;

import java.math.*;
import java.util.*;

public class RSA {

    private static final int P = 41;
    private static final int Q = 67;
    private static final int D = 83;
    private static final int N = P*Q;
    private static final int W = (P-1)*(Q-1);
    
    private static final String PLAINTEXT="mark frequency";
    private static PrivateKeyRSA privateKey = new PrivateKeyRSA(D,N);

    
    public static class PublicKeyRSA{
    	public int partOne,partTwo;
    	public PublicKeyRSA(int e, int n){
            this.partOne = e;
            this.partTwo = n;
        }
    }    
    
    private static class PrivateKeyRSA{
        private int partOne,partTwo;
        private PrivateKeyRSA(int d, int n){
            this.partOne = d;
            this.partTwo = n;
        }
    }
    
    
    // Calculates the value of e using Extended Euclids 
    // and returns the values (e,d,n) that make the public / private key
    private static PublicKeyRSA genPublicKey(int d, int w){
    	
    	// used in finding the remainder and the number of divides of the two previous values in the r array
        int remainder, divs;
        
        // used in iterating through extended euclids to come to the value of 'e' 
        int temp, x, y, prevx, prevy;
        int e;
        
        // Arraylists + variables used in mimicking the extended euclids table
        ArrayList<Integer> r = new ArrayList<Integer>();
        ArrayList<Integer> vi = new ArrayList<Integer>();
        x = temp = prevy = 0;
        y = prevx = 1;

        r.add(0,w); // adding R1
        r.add(1,d); // adding R2
        r.add(2,1); //needed to enter for loop - later removed
        vi.add(0,0);
        vi.add(1,0);
        vi.add(2,0); //needed to enter for loop - later removed

        for (int i = 2; r.get(i-1) > 0; i++) {

            remainder = r.get(i - 2) % r.get(i - 1);
            divs = r.get(i - 2) / r.get(i - 1);

            temp = x;
            x = prevx - divs * x;
            prevx = temp;

            temp = y;
            y = prevy - divs * y;
            prevy = temp;

            r.add(i, remainder);
            vi.add(i, divs);
        }

        r.remove(r.size()-1);
        vi.remove(vi.size()-1);

        e=prevy;

        return new PublicKeyRSA(e,N);
    }
    
    

    // Encrypting using Exponentiation by Squaring and Dividing 
    public static String encrypt(String plaintext){

    	//Generating public key
    	PublicKeyRSA publicKey = genPublicKey(D,W);

    	//converting the plaintext to numbers and pairing
        String[] asciiPaired = convertToNum(plaintext);
        int[] asciiPairedInt = new int[asciiPaired.length];
        for(int k=0; k<asciiPaired.length; k++){
        	asciiPairedInt[k] = Integer.valueOf(asciiPaired[k]);
        }
        
        int[] cipherIntArray = new int[asciiPairedInt.length];
        String binaryE = Integer.toBinaryString(publicKey.partOne);


        for(int j=0; j<asciiPairedInt.length; j++){
            int c = 1;
            for (int i=0; i<binaryE.length(); i++){
                char bitE = binaryE.charAt(i);
                c = (c*c)%publicKey.partTwo;
                if (bitE=='1'){
                    c = (c*asciiPairedInt[j])%publicKey.partTwo;
                }
            }
            cipherIntArray[j] = c;
        }
        
        //converting the cipherIntArray to a String
        String[] cipherStringArray = new String[cipherIntArray.length];
        String ciphertext = "";
        for ( int k=0; k<cipherIntArray.length; k++){
        	cipherStringArray[k] = String.valueOf(cipherIntArray[k]);
        	for(int l=cipherStringArray[k].length(); l<4; l++){
        		cipherStringArray[k] = "0" + cipherStringArray[k];
        	}
        	ciphertext += cipherStringArray[k];
        }
        return ciphertext;
    }

    
    
    public static String decrypt(String ciphertext){

    	BigInteger[] cipherBigIntArray = new BigInteger[(int)Math.ceil((double)PLAINTEXT.length()/2)];
    	for ( int j=0, k=0; j<ciphertext.length(); j+=4, k++){
    		cipherBigIntArray[k] = BigInteger.valueOf(Long.valueOf((ciphertext.substring(j, Math.min(ciphertext.length(), j+4)))));
    	}
    	
        BigInteger[] decrypted = new BigInteger[cipherBigIntArray.length];
        BigInteger m;

        for(int i=0; i<cipherBigIntArray.length; i++){
            m = cipherBigIntArray[i].pow(privateKey.partOne);
            m = m.remainder(BigInteger.valueOf(privateKey.partTwo));
            decrypted[i]=m;
        }

        String[] decryptedPlaintextSplit = convertToChar(decrypted);
        
        String decryptedPlaintext = "";
        for (int i=0; i<decryptedPlaintextSplit.length; i++){
        	decryptedPlaintext += decryptedPlaintextSplit[i]; 
        }
        
        return decryptedPlaintext;
    }

    
    // converts each character of the plaintext to a number then pairs the numbers in twos
    private static String[] convertToNum(String plaintext){
    	plaintext = plaintext.toLowerCase();
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String[] ascii = new String[plaintext.length()];
        for (int i=0; i<plaintext.length(); i++){
            ascii[i] = Integer.toString((alphabet.indexOf(plaintext.charAt(i))));
            if (ascii[i].length()==1){
            	ascii[i] = "0" + ascii[i];
            }
        }

        // combines the values as pairs 
        String[] asciiPaired = new String[(int)Math.ceil((double)plaintext.length()/2)];
        for (int j=0; j<ascii.length; j++){
        	if ( j%2==0 ){
        		asciiPaired[j/2] = ascii[j]; 
        	} else {
        		asciiPaired[j/2] += ascii[j];
        	}
        }
     
        return asciiPaired;
    }
    
    
    // Splits the paired-BigInteger array then converts each to a letter 
    private static String[] convertToChar(BigInteger[] paired){
    	BigInteger[] unpaired = new BigInteger[PLAINTEXT.length()];
    	
    	for (int i=0, j=0; i<paired.length; i++, j+=2){
    		//gets length to determine whether there is a space or a null in the pair
    		int length = String.valueOf(paired[i]).length();
    		if (j>=unpaired.length-1){
    			// handles plaintext of odd length where there are not two numbers to split
    			unpaired[j]=paired[i];
    		} else if (length <=2){
    			// handles when the first half of the split is a space 
    			unpaired[j]=BigInteger.valueOf(0);
    			unpaired[j+1]=paired[i];
    		} else if (length >=3){
    			// splitting the pair of numbers
    			String toSplit = String.valueOf(paired[i]);
    			String split1 = toSplit.substring(0, toSplit.length()-2);
    		    String split2 = toSplit.substring(toSplit.length()-2, toSplit.length());
    		    unpaired[j]= new BigInteger(split1);
    		    unpaired[j+1]= new BigInteger(split2);
    		}
    	}
    	
    	// converting the number to a character 
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String[] decryptedPlaintextSplit = new String[PLAINTEXT.length()];
        for (int i=0; i<PLAINTEXT.length(); i++){
        	decryptedPlaintextSplit[i] = String.valueOf(alphabet.charAt(unpaired[i].intValue()));
        }
        
		return decryptedPlaintextSplit;
    }

    
    public static void main(String [] args){
    	
        PublicKeyRSA publicKey = genPublicKey(D,W);
        System.out.println("Public Key: <" + publicKey.partOne + "," + publicKey.partTwo + ">");
        System.out.println("Private Key: <" + D + "," + N + ">");
        
        System.out.println("");
        System.out.println("Plaintext:");
        System.out.println(PLAINTEXT);
        
        String ciphertext = encrypt(PLAINTEXT);
        System.out.println("");
        System.out.println("Ciphertext:");
        System.out.println(ciphertext);
        
        String decrypted = decrypt(ciphertext);
        System.out.println("");
        System.out.println("Decrypted Ciphertext:");
        System.out.println(decrypted);

    	
    	// Testing the correct values for the public key are generated
        PublicKeyRSA testPublicKey = genPublicKey(D,W);
        assert(testPublicKey.partOne==827);
        assert(testPublicKey.partTwo==2747);
        
        // TEST: Converting the plaintext to numbers and pairing
        String testPlaintext = "mark frequency";
        String testBinaryE = Integer.toBinaryString(testPublicKey.partOne);
        String[] testAsciiPlaintextOutput = convertToNum(testPlaintext);
        String[] testAsciiPlaintext = {"1301","1811","0006","1805","1721","0514","0325"};
        assert(Arrays.equals(testAsciiPlaintext,testAsciiPlaintextOutput));
        assert(testBinaryE.equals("1100111011"));
        
        // TEST: the plaintext is encrypted 
        String testCiphertext = "2700133612421190217225311039";
        String testCiphertextOutput = encrypt(testPlaintext);
        assert(testCiphertext.equals(testCiphertextOutput));
        
        // TEST: the ciphertext is decrypted
        String testDecrypted = decrypt(testCiphertext);
        assert(testPlaintext.equals(testDecrypted));
   
        // TEST: the unpaired numbers are split and converted back to letters
        BigInteger[] testUnpaired = {BigInteger.valueOf(1301),BigInteger.valueOf(1811),BigInteger.valueOf(6),
        		BigInteger.valueOf(1805),BigInteger.valueOf(1721),BigInteger.valueOf(514),BigInteger.valueOf(325)};
        String[] testConvertedUnpaired = convertToChar(testUnpaired);
        String[] testText = {"m","a","r","k"," ","f","r","e","q","u","e","n","c","y"};
        assert(Arrays.equals(testText,testConvertedUnpaired));

    }

}