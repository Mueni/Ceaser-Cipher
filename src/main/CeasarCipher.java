import java.io.Console;
import java.util.*;


public class CeasarCipher {
    public static void main(String[] args) {
        runCeasarProgram();
    }

    public static void runCeasarProgram() {
        // get whether user wants to encode or decode message
        Scanner ceasarReader = new Scanner(System.in);
        Scanner messageReader = new Scanner(System.in);
        String conversionCeasar = "";
        String messageInput = "";
        int shiftValue = 0;
        System.out.println("Hey welcome to the ceasar program");
        System.out.println("If you would you like to encode text type 1 or if you would like to decode text type 2? ");

        try {
            int ceasarFunction= ceasarReader.nextInt();
            System.out.println("Your ceasar Function is" + " " + ceasarFunction);

            if (ceasarFunction !=1 && ceasarFunction !=2) {
                System.out.println("Kindly choose 1 for encoding  or 2 for decoding");
                continueFunction();
            } else if (ceasarFunction == 1) {
                conversionCeasar = "encode";

            } else if (ceasarFunction == 2)  {
                conversionCeasar = "decode";
            }
            else {
                System.out.println("Your selection is not available");
                System.exit(0);
            }
            System.out.println("Your conversionCeasar is" + " " + conversionCeasar);

        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("The ceasar fuction value must be an integer.");
            continueFunction();
        }

        //get message to encode from user
        if(conversionCeasar.equals("encode")) {
            System.out.println("Please enter the text you wish to encrypt. No numeric values or puntuation marks are permitted!");
            System.out.print("Your message: ");
            messageInput = messageReader.nextLine();
            System.out.println("");
        } else if (conversionCeasar.equals("decode")) {
            System.out.println("Please enter the text you wish to decrypt. No numeric values or puntuation marks are permitted!");
            System.out.print("Your message: ");
            messageInput = messageReader.nextLine();
            System.out.println("");
        }

        //ensure that input message contains no numeric values, is not empty and remove any punctuation marks
        String inputString = messageInput.replaceAll("\\p{Punct}", "");

        if(inputString.matches(".*\\d.*")){
            System.out.println("Your input does not meet the criteria stated above.");
            continueFunction();
        }else if(inputString.equals("")){
            System.out.println("You didn't enter anything.");
            continueFunction();
        }
        else System.out.println("Your input is" + " " + inputString);

        //get cipher shift value from user
        Scanner shiftReader = new Scanner(System.in);
        System.out.println("Please enter an integer for the cipher shift.");
        System.out.println("Positive integers alphabetically shift right and negative integers alphabetically shift left.");
        System.out.print("Cipher shift: ");
        try{
            shiftValue = shiftReader.nextInt();
        }catch(InputMismatchException e){
            System.out.println("");
            System.out.println("The shift value must be an integer.");
            continueFunction();
        }
        System.out.println("Your shift value is" + " " + shiftValue);

    }

    public static void continueFunction() {
        System.out.println("Would you like to continue? yes/no");
        Scanner toContinue = new Scanner(System.in);
        String continueText;
        continueText = toContinue.nextLine();
        String caseContinueText = continueText.toLowerCase();

        if (!caseContinueText.equals("yes") && !caseContinueText.equals("no")) {
            System.out.println("Kindly choose yes or no");
        } else if (caseContinueText.equals("yes")) {
            runCeasarProgram();
        } else {
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }
}



