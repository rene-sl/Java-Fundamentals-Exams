import java.util.*;

public class PractisseSession {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        HashMap<String, List<String>> session = new HashMap<>();

        while (!input.equals("END")){
        String [] info = input.split("->");
        String command = info[0];
        String currentRoad = info[1];
        List<String> racers = new ArrayList<>();

        if (command.equals("Add")){
            String racer = info[2];
            if (!session.containsKey(currentRoad)){
                racers.add(racer);
                session.put(currentRoad,racers);
            } else {
                List<String> currentListRacers = session.get(currentRoad);
                currentListRacers.add(racer);
                session.put(currentRoad,currentListRacers);
            }
        }else if (command.equals("Move")){
            String nextRoad = info[3];
            String racer = info[2];
            if (session.get(currentRoad).contains(racer)) {
                session.get(currentRoad).remove(racer);

                List<String> currentListRacers = session.get(nextRoad);
                currentListRacers.add(racer);
                session.put(nextRoad, currentListRacers);
            }
        } else if (command.equals("Close")){
                session.remove(currentRoad);
        }
            input = scanner.nextLine();
        }
        System.out.printf("Practice sessions:\n");
       session.entrySet().stream().sorted((first,second) ->{
           int result = Integer.toString(second.getValue().size())
                   .compareTo(Integer.toString(first.getValue().size()));
           if (result==0){
               result = first.getKey().compareTo(second.getKey());
           }
           return  result;
       }).forEach(stringListEntry -> {
           System.out.print(String.format("%s%n", stringListEntry.getKey()));

           for (String s : stringListEntry.getValue()) {
               System.out.printf("++%s%n",s);
           }{

           }
       });

    }
}
