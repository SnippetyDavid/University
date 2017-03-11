import java.util.ArrayList;

public class RSA {

    private static final String plaintext="abc";
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


    private static int[] encrypt(Key publicKey, int[] asciiPlaintext){

        int[] cipher = new int[asciiPlaintext.length];
        String binaryE = Integer.toBinaryString(publicKey.partOne);

        System.out.println(binaryE);

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

    private static double[] decrypt(Key privateKey, int[] ciphertext){

        double[] decrypted = new double[ciphertext.length];
        double m;

        for(int i=0; i<ciphertext.length; i++){
            m = Math.pow(ciphertext[i],privateKey.partOne);
            m = m % privateKey.partTwo;
            decrypted[i]=m;
        }

        return decrypted;
    }

    private static int[] convertToNum(String plaintext){
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        int[] ascii = new int[plaintext.length()];
        for (int i=0; i<plaintext.length(); i++){
            ascii[i] = (alphabet.indexOf(plaintext.charAt(i)));
        }
        return ascii;
    }

    private static void EncDecB(Key publicKey, Key privateKey){
        int asii=2; //B

        String binaryE = Integer.toBinaryString(publicKey.partOne);
        System.out.println(binaryE); //correct

        int c = 1;
        for (int i=0; i<binaryE.length(); i++){
            char bitE = binaryE.charAt(i);
            c = c * c;
            c = c % publicKey.partTwo;
            if (bitE=='1'){
                c = (c*2)%publicKey.partTwo;
            }
        }

        int cipher = c;
        System.out.println("");
        System.out.println(cipher);

        double result;
//        result = Math.pow(cipher,83);
//        System.out.println(result);
//        result = result%privateKey.partTwo;
//        System.out.println(result);
        result = Math.pow(14,31);
        System.out.println(result);
        result = result%133;
        System.out.println(result);
    }

    public static void main(String [] args){

        KeyValues keyValues = genKeyValues(d,w);
        Key publicKey = new Key(keyValues.e,keyValues.n);
        Key privateKey = new Key(keyValues.d,keyValues.n);
        System.out.println("Public Key: <" + publicKey.partOne + "," + publicKey.partTwo + ">");
        System.out.println("Private Key: <" + privateKey.partOne + "," + privateKey.partTwo + ">");

//        int[] asciiPlaintext = convertToNum(plaintext);
//
//        int[] ciphertext = encrypt(publicKey, asciiPlaintext);
//
//        double[] decrypted = decrypt(privateKey, ciphertext);

        //testing which is broke, enc or dec
        EncDecB(publicKey, privateKey);




    }

}

