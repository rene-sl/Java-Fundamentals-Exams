import java.util.*;
import java.util.stream.Collectors;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        HashMap<String, List<String>> collection = new HashMap<>();


        while (!input.equals("END")) {
            String[] commands = input.split("->");
            String command = commands[0];
            String store = commands[1];

            switch (command) {
                case "Add":
                    List<String> items = Arrays.stream(commands[2].split(","))
                            .collect(Collectors.toList());

                    if (!collection.containsKey(store)) {
                        collection.put(store, items);
                    } else {
                        List<String> currentItems = collection.get(store);
                        for (String item : items) {
                            currentItems.add(item);
                        }
                        collection.put(store, currentItems);
                    }
                    break;

                case "Remove":
                    if (collection.containsKey(store)) {
                        collection.remove(store);
                    }
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.print("Stores list:" + "\n");
        collection.entrySet()
                .stream()
                .sorted((first, second) -> {

            int res = ((Integer.toString(second.getValue().size())
                            .compareTo(Integer.toString(first.getValue().size()))));
            if  (res == 0){
                res = second.getKey().compareTo(first.getKey());
            }
            return res;
        }).forEach(stringListEntry -> {
            System.out.print(String.format("%s%n",
                    stringListEntry.getKey()));
                    for (int i = 0; i < stringListEntry.getValue().size() ; i++) {
                        System.out.printf("<<%s>>%n", stringListEntry.getValue().get(i));
                    }
        }
        );
    }
}

//"%s%n<<%s>>"