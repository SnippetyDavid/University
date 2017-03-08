import java.util.ArrayList;

public class RSA {

    private static final String plaintext="markfrequency";
    private static final int p = 41;
    private static final int q = 67;
    private static final int d = 83;
    private static final int n = p*q;
    private static final int w = (p-1)*(q-1);

    private static class Key{
        private int partOne,partTwo;
        private Key(int f, int n){
            this.partOne = f;
            this.partTwo = n;
        }
    }

    private static Key genPublicKey(int d, int w){

        int remainder , divs, e, v;
        ArrayList<Integer> r = new ArrayList<Integer>();
        ArrayList<Integer> vi = new ArrayList<Integer>();

        r.add(0,w); // adding R1
        r.add(1,d); // adding R2
        r.add(2,1); //needed to enter for loop - later removed
        vi.add(0,0);
        vi.add(1,0);
        vi.add(2,0); //needed to enter for loop - later removed

        try {
            for (int i = 2; r.get(i-1) > 0; i++) {
                remainder = r.get(i - 2) % r.get(i - 1);
                divs = r.get(i - 2) / r.get(i - 1);
                r.add(i, remainder);
                vi.add(i, divs);
            }

            //removing the elements no longer needed
            r.remove(r.size()-1);
            vi.remove(vi.size()-1);


            v = vi.get(vi.size() - 2);

            //TODO: fix getting value of e
            //e=r.get(r.size()-2)+(vi.get(vi.size()-2)*w)/d;
            e=r.get(r.size()-2) + (v * w);
            e=e/d;

            Key publicKey = new Key(e,n);
            return publicKey;
        }catch(Exception NullPointerException){System.out.println("WRONG");}
        return null;
    }

    private static Key genPrivateKey(int d, int w){

        int remainder , divs, e, v;
        ArrayList<Integer> r = new ArrayList<Integer>();
        ArrayList<Integer> vi = new ArrayList<Integer>();

        r.add(0,w); // adding R1
        r.add(1,d); // adding R2
        r.add(2,1); //ignore this basically
        vi.add(0,0); //filling first index
        vi.add(1,0); //filling second index
        vi.add(2,0);//ignore this basically

        try{
            for (int i = 2; r.get(i-1) > 0; i++) {
                remainder = r.get(i - 2) % r.get(i - 1);
                divs = r.get(i - 2) / r.get(i - 1);
                r.add(i, remainder);
                vi.add(i, divs);
            }
            r.remove(r.size()-1);
            vi.remove(vi.size()-1);
            v = vi.get(vi.size() - 2);


            Key privateKey = new Key(d,n);
            return privateKey;
        }catch(Exception NullPointerException){System.out.println("WRONG");}
        return null;
    }

    //TODO: Must fix e first before implementing encrypt method
    private static void encrypt(int[] ascii){
        //Plaintext-M    C=Me(mod n)
        int[] cipher = new int[ascii.length];

        for(int i=0; i<ascii.length; i++){

        }
    }

    private static int[] convertToNum(String plaintext){
        String alphabet = " abcdefghijklmnopqrstuvwxyz";
        int[] ascii = new int[plaintext.length()];
        for (int i=0; i<plaintext.length(); i++){
            ascii[i] = (alphabet.indexOf(plaintext.charAt(i)));
        }
        return ascii;
    }

    public static void main(String [] args){

        Key pubKey = genPublicKey(d,w);
        Key priKey = genPrivateKey(d,w);
        System.out.println(pubKey.partOne + " " + pubKey.partTwo);
        System.out.println(priKey.partOne + " " + priKey.partTwo);

        int[] ascii = convertToNum(plaintext);

        // using 2 as we are encrypting the letter B
        int result = 2^pubKey.partOne; // pubKey.partOne is e
        result = result % w;
        System.out.println(result); // B encrypted

        int result2 = result ^ d;
        result2 = result2 % n;
        System.out.println(result2); // B decrypted == 2




    }

}
