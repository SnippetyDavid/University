package encryption;

import java.util.Arrays;
import java.util.logging.Logger;

public class HA2 {

    private final static Logger LOGGER = Logger.getLogger(HA2.class.getName());

    private final static int IV = 76;

    public static int encrypt(String plaintext, int iv){
        int[] converted = convertToNum(plaintext);
        int hashed = 0;
        for(int i=0; i<plaintext.length(); i++){
            hashed = addChainingValue(iv, converted[i]);
            hashed = multiplyChainingValue(hashed);
            hashed = reverseDigits(hashed);
            hashed = addInitialToNew(iv, hashed);

            iv = hashed;
        }
        LOGGER.info("End Hash Value: " + hashed);

        return hashed;
    }


    private static int[] convertToNum(String message){
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       int[] ascii = new int[message.length()];
       for (int i=0; i<message.length(); i++){
           ascii[i] = (alphabet.indexOf(message.toLowerCase().charAt(i)));
           LOGGER.info("Char: " + ascii[i]);
       }
       return ascii;
    }

    private static int addChainingValue(int AB, int msgblock){
        return (AB + msgblock) % 100;
    }

    private static int multiplyChainingValue(int cValue){
        return (cValue * 7) % 100;
    }

    private static int reverseDigits(int digits){
        String digitString;
        digitString = Integer.toString(digits);
        digitString = new StringBuffer(digitString).reverse().toString();

        return Integer.parseInt(digitString);
    }

    private static int addInitialToNew(int iv, int newValue){
        return (iv + newValue) % 100;
    }

    public static void main(String[] args) {

        //Testing conversing to number corresponding to letters
        String testText = "hi";
        int[] convertResult = convertToNum(testText);
        assert (Arrays.equals(convertResult, new int[]{7,8}));

        //Testing add chaining value
        int initial = 12;
        assert (addChainingValue(initial, IV) == 88);

        //Testing multiplication method
        int testInt = 7;
        int multiplyResult = multiplyChainingValue(testInt);
        assert (multiplyResult == 49);

        //Testing reversal
        int value = 123;
        int reversed = reverseDigits(value);
        assert (reversed == 321);

        //Testing add of initial value to new result
        int newValue = 107;
        assert (addInitialToNew(IV, newValue) == 83);

        //Testing entire method with plaintext 'ha'
        String plain = "ha";
        int finalResult = encrypt(plain, IV);
        assert (finalResult == 79);

        // Second test string
        String testTwo = "HellomynameIsAlice";
        int resultTwo = encrypt(testTwo, IV);
        assert(resultTwo == 52);

        //Running actual encryption
        String plaintext = "markfrequency";
        encrypt(plaintext, IV);
        System.out.println();
    }

}




