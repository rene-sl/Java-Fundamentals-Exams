import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String a = scanner.next();
        String b = scanner.next();


        String regex = "^[d-z{}#\\|]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String encryptedWord = null;

        while (matcher.find()) {
            String decrypted = input;
            encryptedWord="";


            for (int i = 0; i < decrypted.length(); i++) {
                char letter = (char) decrypted.charAt(i);
                char encryptedChar = (char) (letter - 3);
                encryptedWord+=encryptedChar;
            }

                int index = encryptedWord.indexOf(a);
                while (index!=-1){
                    encryptedWord = encryptedWord.replace(a,b);
                    index= encryptedWord.indexOf(a);
                }
            System.out.println(encryptedWord);
        }


        if (encryptedWord==null){
            System.out.println("This is not the book you are looking for.");
        }

    }
}
