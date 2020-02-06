import java.util.Scanner;

public class PartyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins=0;

        for (int day = 1; day <= days ; day++) {
            if (day%10==0){
                partySize-=2;
            }
            if (day%15==0){
                partySize+=5;
            }

            coins+=50;
            coins-=(2*partySize);

            if (day%3==0){
                coins-=(3*partySize);
            }

            if (day%5==0 && day%3==0){
                coins+=(20*partySize);
                coins-=(2*partySize);
            } else if (day%5==0){
                coins+=(20*partySize);
            }

        }

        System.out.printf("%d companions received %d coins each.", partySize, (int)coins/partySize);

    }
}
