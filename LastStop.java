import java.util.*;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> paintings = Arrays.stream(scanner.nextLine()
                                .split("\\s+"))
                                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("END")){
            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command){
                case "Change":
                    while (paintings.contains(commands[1])){
                        int indexChange = paintings.indexOf(commands[1]);
                        paintings.set(indexChange,commands[2]);
                    }
                    break;
                case "Hide":
                    while (paintings.contains(commands[1])){
                        paintings.remove(commands[1]);
                    }
                    break;
                case "Switch":
                    if (paintings.contains(commands[1]) && paintings.contains(commands[2])){
                        if (commands[1].equals(commands[2])){
                            break;
                        } else {
                            switchPositions(paintings, commands);
                        }
                    }
                    break;
                case "Insert":
                    int indexInsert = Integer.parseInt(commands[1])+1;
                    if (isIndexValid(paintings,indexInsert)){
                        paintings.add(indexInsert, commands[2]);
                    }
                    break;
                case "Reverse":
                    Collections.reverse(paintings);
                    break;
            }


            input = scanner.nextLine();
        }

        for (String painting : paintings) {
            System.out.printf("%s ",painting);
        }


    }

    private static boolean isIndexValid (List<String> list, int index){
        boolean indexIsValid = false;
        if (0<=index && index<list.size()){
            indexIsValid = true;
        }
        return indexIsValid;
    }

     static List<String> switchPositions (List<String> paintings, String[] commands){
        int indexOne = paintings.indexOf(commands[1]);
        int indexTwo = paintings.indexOf(commands[2]);
        paintings.set(indexOne,commands[2]);
        paintings.set(indexTwo,commands[1]);
        return paintings;
    }
}
