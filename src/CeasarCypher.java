import java.util.Scanner;
public class CeasarCypher {
    public static void main(String[] args) {

        String alphabeat = "abcdefghijklmnopqrstuvwxyz";

        //Starter scanneren som spørger brugeren om hvad de gerne vil gøre
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to encrypt or decrypt");
        String userOption = scanner.nextLine();

        //Bliver så splittet op i 2 forskellige if kommandoer som skal tage information givet og føre det videre til en ny metode
        if (userOption.equalsIgnoreCase("encrypt")) {
            System.out.println("Insert word to encrypt, cope: ");
            String userInput = scanner.nextLine();

            System.out.println("How many letters would you like to move?");
            int shift = scanner.nextInt();


            caesarEncrypt(alphabeat, shift, userInput);
            System.out.println("Your encrypted word will become: " + caesarEncrypt(alphabeat, shift, userInput));

        } else if (userOption.equalsIgnoreCase("decrypt")) {
            System.out.println("Insert word to decrypt, cope: ");
            String userInput = scanner.nextLine();

            System.out.println("How many letters would you like to move?");
            int shift = scanner.nextInt();

            ceasarDecrypt(alphabeat, shift, userInput);
            System.out.println("Your decrypted word will become: " + ceasarDecrypt(alphabeat, shift, userInput));
        }


    }
    //Vores encrypt kommando
    public static String caesarEncrypt(String alphabeat, int shift, String userInput) {

        String result = "";
        //Vores for loop checker for det første index osv, og sammenligner det med stringen alphabeat
        for (int i = 0; i < userInput.length(); i++) {
            int indexOfStringInAlphabeat = alphabeat.indexOf(userInput.charAt(i));
            //Hvad den så gør er at tage ud fra alphabeat og flytte den med shift, hvor indexet der var før bliver nu skiftet ud med.
            result += alphabeat.charAt(indexOfStringInAlphabeat + shift) + "";
        }
        //Vi returnerer så for hvert bogstav ud fra længen af navnet med vores forloop[i]
        return result;

    }

    public static String ceasarDecrypt(String alphabeat, int shift, String userInput) {

        String result = "";
        //Det samme som i encrypt undtagen at nu har vi minuset med shift for at gå tilbage i alphabeat for index.
        for (int i = 0; i < userInput.length(); i++) {
            int indexOfStringInAlphaBeat = alphabeat.indexOf(userInput.charAt(i));
            result += alphabeat.charAt(indexOfStringInAlphaBeat - shift) + "";
        }
        return result;
    }
}
