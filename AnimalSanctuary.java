import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalWeight = 0;

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            String regex = "n:([^;]*);t:([^;]*);c--([A-Za-z ]+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()){
                String nameSymbols = matcher.group(1);
                String kindAnimalSymbols = matcher.group(2);
                String countrySymbols = matcher.group(3);

                int weight = 0;

                String name ="";
                for (int j = 0; j < nameSymbols.length() ; j++) {
                    if (Character.isLetter(nameSymbols.charAt(j)) ||
                            Character.isSpaceChar(nameSymbols.charAt(j))){
                        name+=nameSymbols.charAt(j);
                    } else if (Character.isDigit(nameSymbols.charAt(j))){
                        char ch = nameSymbols.charAt(j);
                        int digit = ch - '0';
                        weight+=digit;
                    }
                }
                String kindAnimal = "";
                for (int k = 0; k <kindAnimalSymbols.length(); k++) {
                    if (Character.isLetter(kindAnimalSymbols.charAt(k)) ||
                    Character.isSpaceChar(kindAnimalSymbols.charAt(k))){
                        kindAnimal+=kindAnimalSymbols.charAt(k);
                    } else if (Character.isDigit(kindAnimalSymbols.charAt(k))){
                        char ch = kindAnimalSymbols.charAt(k);
                        int digit = ch - '0';
                        weight+=digit;
                    }
                }

                String country = "";
                for (int l = 0; l <countrySymbols.length(); l++) {
                    if (Character.isLetter(countrySymbols.charAt(l)) ||
                            Character.isSpaceChar(countrySymbols.charAt(l))){
                        country+=countrySymbols.charAt(l);
                    }
                }
                System.out.printf("%s is a %s from %s%n",name,kindAnimal,country);
                totalWeight+=weight;
            }
        }
        System.out.printf("Total weight of animals: %dKG", totalWeight);
    }
}
