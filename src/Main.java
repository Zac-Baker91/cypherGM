import java.util.Scanner;

// Cypher Game Manager
//A game management assistant for the table-top RPG system "cypher system" by Monte cook
// Program written by Zac Baker
public class Main {
    public static void main(String[] args) {

        //control bool for options loop
        boolean optErr = true;

        Scanner stdin = new Scanner(System.in);
        System.out.printf("Welcome the Cypher System Game Management. \n\nSelect on option bellow (enter number)\n");

        //input checking loop - switch allows for easy addition or removal of options
        while (optErr) {
            System.out.printf("[1] Player Creation    [2] NPC Creation\n");
            String selection = stdin.nextLine();
            int selectNum;
            try{
                selectNum = Integer.parseInt(selection);
            }catch(NumberFormatException nfe){
                selectNum = -1;
            }
            switch (selectNum) {
                case 1:
                    //Player base stats are generated using a sentence
                    String name,descriptor,type,focus;
                    System.out.println("Who are you?:");
                    System.out.println("<Name> is a <Descriptor> <Type> who <Focus>");
                    System.out.printf("Name: ");
                    name = stdin.next();
                    stdin.nextLine();
                    System.out.printf("Descriptor: ");
                    descriptor = stdin.next();
                    stdin.nextLine();
                    System.out.printf("Type: ");
                    type = stdin.next();
                    stdin.nextLine();
                    System.out.print("Focus: ");
                    focus = stdin.nextLine();

                    Player n00b = new Player(name,descriptor,type,focus);

                    optErr = false;
                    break;
                case 2:
                    //put the NPC creation methode here
                    System.out.println("This is where NPC creation will be");
                    optErr = false;
                    break;
                default:
                    System.out.printf("\nOpps: invalid entry. [try again]\n");

            }

        }

        stdin.close();
    }
}
