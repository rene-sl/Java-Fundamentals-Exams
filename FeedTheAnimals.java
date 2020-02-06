import java.util.*;
import java.util.stream.Collectors;

public class FeedTheAnimals {

    public static class Animal {

        private String name;
        private int food;
        private String area;


        public Animal(String name, int food, String area) {
            this.name = name;
            this.food = food;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public int getFood() {
            return food;
        }

        public String getArea() {
            return area;
        }

        public void setFood(int food) {
            this.food = food;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String current = scanner.nextLine();

        TreeMap<String, Animal> animalList = new TreeMap<>();

        while (!current.equalsIgnoreCase("Last Info")) {
            String[] input = current.split(":");
            String command = input[0];
            String name = input[1];
            int food = Integer.parseInt(input[2]);
            String area = input[3];

            Animal animal = new Animal(name, food, area);


            switch (command) {

                case "Add":
                    if (!animalList.containsKey(name)){
                        animalList.put(name, animal);
                    } else {
                        int currentFood = animalList.get(name).getFood() + food;
                        animalList.get(name).setFood(currentFood);
                    }
                    break;

                case "Feed":
                    if (animalList.containsKey(name)){
                        int currentFood = animalList.get(name).getFood() - food;
                        if (0 < currentFood){
                            animalList.get(name).setFood(currentFood);
                        } else {
                            System.out.printf("%s was successfully fed%n", animalList.get(name).name );
                            animalList.remove(name);
                        }
                    }
                    break;
            }
            current = scanner.nextLine();
        }

        System.out.println("Animals:");
        animalList.entrySet().stream().sorted((f,s ) -> {
            return (( Integer.toString(s.getValue().getFood()))
                    .compareTo( Integer.toString(f.getValue().getFood())));

        }).forEach(entry ->{
            System.out.println(entry.getKey() + " -> " + entry.getValue().getFood() + "g");

        });

        System.out.println("Areas with hungry animals:");
        animalList.entrySet().stream()
                .sorted((f,s ) -> {

                    int result = s.getValue().getArea().compareTo(f.getValue().getArea());

                    if(result == 0){
                        result = s.getKey().compareTo(f.getKey());
                    }
                    return result;

                }).forEach(entry ->{

            System.out.println(entry.getKey() + " : " + entry.getValue().getArea());

        });


    }
}