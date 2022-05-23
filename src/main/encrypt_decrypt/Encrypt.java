package encrypt_decrypt;

public class Encrypt {
    private  String userInput;
    private final int shiftNumber;

    public Encrypt(String userInput, int shiftNumber) {
        this.userInput = userInput;
        this.shiftNumber = shiftNumber;
    }

    public  String encryptMessage() {
        //need an alphabet to use for character substitution
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encryptedMessage = "";
        int charPosition, keyVal;
        char encryptionVal;

        /* iterate through message and either substitute in encoded characters
            or drop in spaces as needed */
        for(int i = 0; i < userInput.length(); i++){
            //substitute spaces
            switch(userInput.charAt(i)){
                case ' ': encryptedMessage += ' ';
                          break;
                    //find location of current character in alphabet
                default:    charPosition = alphabet.indexOf(userInput.charAt(i));
                            //use shift to find location of encoded character
                            keyVal = (shiftNumber + charPosition) % 26;

                         /* if keyVal is negative, we need to go to the other end
                            of the alphabet */
                            if(keyVal < 0){
                                keyVal = alphabet.length() + keyVal;
                            }

                            //found encoded character, insert into encoded message
                            encryptionVal = alphabet.charAt(keyVal);
                            encryptedMessage += encryptionVal;

            }

        }
        //return encoded message
        return encryptedMessage;
    }
}
