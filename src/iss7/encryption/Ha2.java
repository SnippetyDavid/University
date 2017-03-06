package encryption;

import java.util.Arrays;
import java.util.logging.Logger;

public class Ha2 {

    private final static Logger LOGGER = Logger.getLogger(Ha2.class.getName());


    public static int[] encrypt(String plaintext, int iv){
        int[] converted = convertToNum(plaintext);
        int[] hashed = new int[converted.length];
        for(int i=0; i<plaintext.length(); i++){
            hashed[i] = addChainingValue(iv, converted[i]);
            hashed[i] = multiplyChainingValue(hashed[i]);
            hashed[i] = reverseDigits(hashed[i]);
            hashed[i] = addInitialToNew(iv, hashed[i]);
        }
        LOGGER.info("Hashed: " + Arrays.toString(hashed));

        return hashed;
    }


    private static int[] convertToNum(String message){
       String alphabet = "abcdefghijklmnopqrstuvwxyz";
       int[] ascii = new int[message.length()];
       for (int i=0; i<message.length(); i++){
           ascii[i] = (alphabet.indexOf(message.charAt(i)));
           LOGGER.info("Char: " + ascii[i]);
       }
       return ascii;
    }

    private static int addChainingValue(int AB, int msgblock){
        int newValue = AB + msgblock;
        newValue = newValue % 100;

        return newValue;
    }

    private static int multiplyChainingValue(int cValue){
        return (cValue * 7) % 100;
    }

    private static int reverseDigits(int digits){
        String digitString;
        digitString = Integer.toString(digits);
        digitString = new StringBuffer(digitString).reverse().toString();

        digits =  Integer.parseInt(digitString);
        return digits;
    }

    private static int addInitialToNew(int iv, int newValue){
        return (iv + newValue) % 100;
    }

    public static void main(String[] args) {

        //Harcoded IV for now to one used in lecture slides
        int iv = 76;
        String plaintext = "markfrequency";

        encrypt(plaintext, iv);

    }

}




