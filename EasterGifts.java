import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> gifts = Arrays.stream(input.split("\\s+"))
                .collect(Collectors.toList());



        input = scanner.nextLine();
        while (!input.equalsIgnoreCase("No Money")){
           String[] commands = input.split("\\s+");
           String command = commands[0];
           String gift = commands[1];

           switch (command){
               case "OutOfStock":
                 while (gifts.contains(gift)) {
                   int indexGift =  gifts.indexOf(gift);
                   gifts.set(indexGift, "None");
                 }
                   break;
               case "Required":
                   int indexNew = Integer.parseInt(commands[2]);
                   if (isIndexValid(gifts, indexNew)){
                       gifts.set(indexNew,gift);
                   }
                   System.out.println();
                   break;
               case "JustInCase":
                   gifts.set(gifts.size()-1, gift);
                   break;
           }
            input = scanner.nextLine();
        }

       List<String> result = gifts.stream().filter(e->!e.equals("None")).collect(Collectors.toList());
        for (String s : result) {
            System.out.print(s + " ");
        }


    }

    public static boolean isIndexValid (List<String> list, int index){
        boolean indexIsValid = false;
        if (0<=index && index<list.size()){
            indexIsValid = true;
        }
        return indexIsValid;
    }
}
