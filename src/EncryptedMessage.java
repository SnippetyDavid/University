import java.io.Serializable;

public class EncryptedMessage implements Serializable
{   // this instance variable will store the original, encrypted and decrypted message
	private String message;
	
	// this variable stores the key 
	static String KEY = "cable";

    public EncryptedMessage(String Message)
    {	// begin by coding this method first - initialise instance variable message with the original message
		message = new String(Message);
    }

    public String getMessage()
    {	// code this method next - return the value of instance variable message either encrypted or decrypted 
		return message;
    }

    public void encrypt()
    {	/* read through section 3 of the practical 6 document 
		   to get you started */
		/* Hint: the alphabet is required and have a look at the algorithm in the document 
		 * after encryption what form will the original message take plaintext or ciphertext */
		 
    	String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,'!#/:~@[]{}()*&^%$£<>?-_";
        String cipherText = "";

    	for(int i = 0; i < message.length(); i++)
    	{	// find position of plaintext character in the character set
    		int plainTxtCh = charSet.indexOf(message.charAt(i));

                // get position of next key character
    		int keyPos = i % KEY.length();
                // find position of key character in the character set
                int keyCh = charSet.indexOf(KEY.charAt(keyPos));

    		/* add key character to plaintext character - this shifts the
    		   plaintext character - then divide by length of
			   character reference set and get remainder to wrap around */
    		int cipherTxtCh = (plainTxtCh + keyCh) % charSet.length();
    		/* get character at corresponding position in character reference
			   set and add to cipherText */
			char c = charSet.charAt(cipherTxtCh);
			cipherText += c;
    	}
    	message = cipherText;

         }
     
    public void decrypt()
    {	/* read through section 3 of the practical 6 document
    to get you started */
    /* Hint: the alphabet is required and have a look at the algorithm in the document
    * after decryption what form will the original message take plaintext or ciphertext */
    	//decryption is equal to message
    	String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,'!#/:~@[]{}()*&^%$£<>?-_";
        String plainText = "";

    	for(int i = 0; i < message.length(); i++)
    	{	// find position of ciphertext character
    		int cipherTxtCh = charSet.indexOf(message.charAt(i));

                // get position of next key character
    		int keyPos = i % KEY.length();
                // find position of key character in the character set
                int keyCh = charSet.indexOf(KEY.charAt(keyPos));

    		/* subtract original shift from character reference set length to
			   get new shift, add shift to ciphertext character then
			   divide by character reference set length and get remainder to
			   wrap around */
    		int plainTxtCh = (cipherTxtCh + (charSet.length() - keyCh)) % charSet.length();

    		/* get character at corresponding position in character reference
			   set and add to plainText */
			char c = charSet.charAt(plainTxtCh);
			plainText += c;
    	}
    	message = plainText;

        }
     
     private int[] getPositions(String messaged, int location)
     {
     	char[] alphabet = getAlphabet();
     	//select the current letter
     	char currentletter = messaged.charAt(location);
     	//initialise positions
            int position = 0;
            int keyPosition = 0;
            int upperCase =0;


            //search alphabet for current letter in message
            for(int j =0; j<alphabet.length; j++)
            {
            	//if found
               if(alphabet[j] == currentletter)
               {
               	  //record position
                  position =j;
                  //exit loop
                  break;
               }
                else if (Character.toUpperCase(alphabet[j]) == currentletter)
               {
                   position = j;
                   upperCase = 1;
                   break;
               }

            }
			//select corresponding letter from key
            char currentletterKey = KEY.charAt(location % 5);
            	//search alphabet for current letter
                for(int l =0; l<alphabet.length; l++)
                {
                	//if match is found
                    if(alphabet[l] == currentletterKey)
                    {
                    	//record it
                        keyPosition =l;
						//exit loop
                        break;
                    }

                }
                //reocrd positions in array
                int[] positions = {position, keyPosition, upperCase};
                //return them
                return positions;
                }
                
     private char[] getAlphabet(){
     	//reocrd alphabet in Character array
     	char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ', '1','2','3','4','5','6','7','8','9','0'};
     	//return it
     	return alphabet;
     }


}
