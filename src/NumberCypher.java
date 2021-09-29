import java.util.Scanner;

public class NumberCypher {
    public static void main(String[] args) {

        //Vores starting variabler, hvor vi har et alphabeat fra en slags array og en bare string (string[] bliver ikke brugt
        //kan bare godt lide at have den hvis det blev nødvendig)
        int[] numbList = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        String[] alphaList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String alphabeat = "abcdefghijklmnopqrstuvwxyzæøå";

        //Vores ord vi gerne vil encrypt
        String word = "ben";

        //Vi tager informationen fra alphabeat og vores word, og giver den videre til den næste funktion numberCypherEncoder
        String result = numberCypherEncoder(word, alphabeat);
        System.out.println(numberCypherEncoder(word, alphabeat));


        //Vi omregner vores encrypted ord om til en array hvor vi først fjerne ;
        String[] arrayResult = result.split(";");
        System.out.println("Turning the encoded to an array: ");
        //Hvor vi så har et for-loop for hvert tal i arrayen
        for (int i = 0; i < arrayResult.length; i++) {
            System.out.println(arrayResult[i]);
        }

        //Vi tager arrayet fra før, sammen med vores alphabeat og giver den videre til metoden numberCypherDecoder
        numberCypherDecoder(arrayResult,alphabeat);
        System.out.println(numberCypherDecoder(arrayResult,alphabeat));
    }

    //Encrypt metoden
    public static String numberCypherEncoder(String word, String alphabeat) {
        System.out.println("Encoding word: ");
        String result = "";

        //Vores for-loop som skal finde tallets for hvert bogstav i ordet der var givet (ben i dette tilfælde)
        for (int i = 0; i < word.length(); i++) {
            int numberCypher = alphabeat.indexOf(word.charAt(i)+1);
            result += numberCypher+";";
        }

        //Vi returnerer resultatet tilbage til vores main
        return result;
    }

    //Decrypt metoden
    public static String numberCypherDecoder(String[] arrayResult, String alphabeat) {
        System.out.println("Decoding the array: ");
        String result = "";

    //Vi laver et for-loop som skal sammenligne tallene fra arrayet med alphabeat. Men fordi index som regel startet fra
        // 0 vil vi gerne minus det med 1, så det sammenligner rigtig nok
    for (int i = 0; i < arrayResult.length; i++) {
       result+= alphabeat.charAt(Integer.parseInt(arrayResult[i])-1);
    }

    return result;

}
}