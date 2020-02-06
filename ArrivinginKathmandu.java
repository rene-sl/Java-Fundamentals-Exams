import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivinginKathmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        while (!input.equals("Last note")) {

            String regex = "(^[A-Za-z\\@\\!\\#\\$\\?]+)=(\\d+)<<(.+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String namePeak = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                String geohashCode = matcher.group(3);
                String name = "";

                for (int i = 0; i < namePeak.length(); i++) {
                    if (Character.isLetter(namePeak.charAt(i))) {
                        name += namePeak.charAt(i);
                    }
                }

                if (geohashCode.length() == length) {
                    System.out.printf("Coordinates found! %s -> %s%n", name, geohashCode);
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }

                input = scanner.nextLine();
        }
    }
}
