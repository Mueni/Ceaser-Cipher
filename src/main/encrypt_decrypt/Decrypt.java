package encrypt_decrypt;

public class Decrypt {
    private  String userInput;
    private final int shiftNumber;

    public Decrypt(String userInput, int shiftNumber) {
        this.userInput = userInput;
        this.shiftNumber = shiftNumber;
    }

    public  String decryptMessage() {
        //need an alphabet to use for character substitution
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String decryptedMessage = "";
        int charPosition, keyVal;
        char decryptionVal;

        /* iterate through message and either substitute in decrypted characters
            or drop in spaces as needed */
        for(int i = 0; i < userInput.length(); i++){
            //substitute spaces
            switch(userInput.charAt(i)){
                case ' ': decryptedMessage += ' ';
                    break;
                //find location of current character in alphabet
                default:    charPosition = alphabet.indexOf(userInput.charAt(i));
                    //use shift to find location of decoded character
                    keyVal = (charPosition - shiftNumber) % 26;

                         /* if keyVal is negative, we need to go to the other end
                            of the alphabet */
                    if(keyVal < 0){
                        keyVal = alphabet.length() + keyVal;
                    }

                    //found un-encoded character, insert into un-encoded message
                    decryptionVal = alphabet.charAt(keyVal);
                    decryptedMessage += decryptionVal;
                    break;

            }

        }
        //return decrypted message
        return decryptedMessage;
    }
}
