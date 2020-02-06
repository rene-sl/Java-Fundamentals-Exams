import java.util.*;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" \\| ");
        String[] words = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();

        TreeMap<String, List<String>> dictionary = new TreeMap<>();


        for (int i = 0; i < input.length; i++) {
            String[] current = input[i].split(": ");
            String word = current[0];
            String definition = current[1];
            List<String> definitions = new ArrayList<>();

            if (!dictionary.containsKey(word)) {
                definitions.add(definition);
                dictionary.put(word, definitions);
            } else {
                List<String> currentDefinitions = dictionary.get(word);
                currentDefinitions.add(definition);
                dictionary.put(word, currentDefinitions);
            }
        }
            if (command.equals("End")) {

                for (String word : words) {
                    if (dictionary.containsKey(word)) {
                        System.out.printf("%s%n", word);

                        dictionary.get(word).stream().sorted((e1, e2) ->
                                Integer.compare(e2.length(), e1.length())).forEach(s ->
                                System.out.printf("-%s%n", s));
                    }

                }
            }

        if (command.equals("List")) {
            for (Map.Entry<String, List<String>> entry : dictionary.entrySet()) {
                System.out.printf("%s ", entry.getKey());
            }

        }

    }
}

