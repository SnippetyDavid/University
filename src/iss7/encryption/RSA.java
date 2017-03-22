package encryption;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class RSA {

    private static final String plaintext="mark frequency";
    private static final int p = 41;
    private static final int q = 67;
    private static final int d = 83;
    private static final int n = p*q;
    private static final int w = (p-1)*(q-1);

    private static class Key{
        private int partOne,partTwo;
        private Key(int d_e, int n){
            this.partOne = d_e;
            this.partTwo = n;
        }
    }

    private static class KeyValues{
        private int e,d,n;
        private KeyValues(int e, int d, int n){
            this.e = e;
            this.d = d;
            this.n = n;
        }
    }

    private static KeyValues genKeyValues(int d, int w){

        int remainder , divs, e, v, temp, x, y, prevx, prevy;
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

        //KeyValues keyValues = new KeyValues(e,d,n);
        return new KeyValues(e,d,n);

    }


    public static int[] encrypt(Key publicKey, int[] asciiPlaintext){

        int[] cipher = new int[asciiPlaintext.length];
        String binaryE = Integer.toBinaryString(publicKey.partOne);

        System.out.println("");
        System.out.println("E("+publicKey.partOne+") as binary: " + binaryE);

        for(int j=0; j<asciiPlaintext.length; j++){
            int c = 1;
            for (int i=0; i<binaryE.length(); i++){
                char bitE = binaryE.charAt(i);
                c = (c*c)%publicKey.partTwo;
                if (bitE=='1'){
                    c = (c*asciiPlaintext[j])%publicKey.partTwo;
                }
            }
            cipher[j] = c;
        }
        return cipher;
    }

    public static BigInteger[] decrypt(Key privateKey, int[] ciphertext){

        BigInteger[] decrypted = new BigInteger[ciphertext.length];
        BigInteger m;

        for(int i=0; i<ciphertext.length; i++){
            BigInteger cipher = BigInteger.valueOf(ciphertext[i]);
            m = cipher.pow(privateKey.partOne);
            m = m.remainder(BigInteger.valueOf(privateKey.partTwo));
            decrypted[i]=m;
        }

        return decrypted;
    }

    private static int[] convertToNum(String plaintext){
    	
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        String[] ascii = new String[plaintext.length()];
        for (int i=0; i<plaintext.length(); i++){
            ascii[i] = Integer.toString((alphabet.indexOf(plaintext.charAt(i))));
            if (ascii[i].length()==1){
            	ascii[i] = "0" + ascii[i];
            }
        }

        System.out.print("Plaintext in ASCII: ");
        for(int i=0; i<ascii.length; i++){
            System.out.print(ascii[i]);
            System.out.print(",");
        }
        System.out.println("");

        String[] asciiPaired = new String[(int)Math.ceil((double)plaintext.length()/2)];
        for (int j=0, k=0; k<ascii.length; j++, k+=2){
        	asciiPaired[j] = ascii[k] + ascii[k+1]; 
        }
        
        int[] asciiPairedInt = Arrays.stream(asciiPaired).mapToInt(Integer::parseInt).toArray();

        return asciiPairedInt;
    }
    
    private static BigInteger[] unpair(BigInteger[] paired){
    	BigInteger[] unpaired = new BigInteger[plaintext.length()];
    	
    	for (int i=0, j=0; i<paired.length; i++, j+=2){
    		int length = String.valueOf(paired[i]).length();
    		if (length <=2){
    			unpaired[j]=BigInteger.valueOf(0);
    			unpaired[j+1]=paired[i];
    		} else if (length >=3){
    			String toSplit = String.valueOf(paired[i]);
    			String split1 = toSplit.substring(0, toSplit.length()-2);
    		    String split2 = toSplit.substring(toSplit.length()-2, toSplit.length());
    		    unpaired[j]= new BigInteger(split1);
    		    unpaired[j+1]= new BigInteger(split2);
    		}
    	}
    	return unpaired;
    }


    public static void main(String [] args){

        KeyValues keyValues = genKeyValues(d,w);
        Key publicKey = new Key(keyValues.e,keyValues.n);
        Key privateKey = new Key(keyValues.d,keyValues.n);
        System.out.println("Public Key: <" + publicKey.partOne + "," + publicKey.partTwo + ">");
        System.out.println("Private Key: <" + privateKey.partOne + "," + privateKey.partTwo + ">");
        System.out.println("");

        System.out.println("Plaintext: " + plaintext);
        int[] asciiPlaintext = convertToNum(plaintext);
        System.out.print("Plaintext in ASCII Paired: ");
        for(int i=0; i<asciiPlaintext.length; i++){
            System.out.print(asciiPlaintext[i]);
            System.out.print(",");
        }

        int[] ciphertext = encrypt(publicKey, asciiPlaintext);
        System.out.println("");
        System.out.println("Encrypted :");
        for (int j=0; j<ciphertext.length; j++){
            System.out.print(ciphertext[j]);
            System.out.print(",");
        }

        BigInteger[] decrypted = decrypt(privateKey, ciphertext);
        System.out.println("");
        System.out.println("");
        System.out.println("Decrypted:");
        for (int k=0; k<decrypted.length; k++){
            System.out.print(decrypted[k]);
            System.out.print(",");
        }
        
        BigInteger[] unpaired = unpair(decrypted);
        System.out.println("");
        System.out.println("");
        System.out.println("Decrypted & Unpaired:");
        for (int l=0; l<unpaired.length; l++){
            System.out.print(unpaired[l]);
            System.out.print(",");
        }

    }

}

