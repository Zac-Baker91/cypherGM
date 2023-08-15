import java.util.Scanner;

// playerMeta.Cypher Game Manager
//A game management assistant for the table-top RPG system "cypher system" by Monte cook
// Program written by Zac Baker
public class Main {
    public static void main(String[] args) {

        //control bool for options loop
        boolean optErr = true;

        Scanner stdin = new Scanner(System.in);
        System.out.println("Welcome the playerMeta.Cypher System Game Management.");

        //input checking loop - switch allows for easy addition or removal of options
        while (optErr) {
            System.out.print("Select on option bellow (enter number)\n[1] Player Creation    [2] NPC Creation\n");
            String selection = stdin.nextLine();
            int selectNum;
            try{
                selectNum = Integer.parseInt(selection);
            }catch(NumberFormatException nfe){
                selectNum = -1;
            }
            switch (selectNum) {
                case 1 -> {
                    //Player base stats are generated using a sentence
                    String name, descriptor, type, focus;
                    System.out.println("Who are you?:");
                    System.out.println("<Name> is a <Descriptor> <Type> who <Focus>");
                    System.out.print("Name: ");
                    name = stdin.next();
                    stdin.nextLine();
                    System.out.print("Descriptor: ");
                    descriptor = stdin.next();
                    stdin.nextLine();
                    System.out.print("Type: ");
                    type = stdin.next();
                    stdin.nextLine();
                    System.out.print("Focus: ");
                    focus = stdin.nextLine();
                    Player n00b = new Player(name, descriptor, type, focus);
                    //warrior player should be able to choose either edge in might or speed
                    if ((n00b.getType()).equals("warrior")) {
                        System.out.println("Warrior choose : [1]might or [2]speed");
                        int p = stdin.nextInt();
                        stdin.nextLine();
                        if (p == 1) n00b.modifyMightEdge(1);
                        else if (p == 2) n00b.modifySpeedEdge(1);
                        else System.out.println("Bad input now you are weak and slow LOLz");
                    }
                    // todo Player need to choose specifics items, using item tags with name = tag as place holder.

                    //todo Player chooses from ability list, using tags for abilities array.

                    //todo non-standard player types need to be re-constructed with standard types.

                    //todo modifier player based on Descriptor

                    //todo modifier player based on Foci


                    System.out.println("Welcome "+n00b.getDescription());
                    System.out.println("============================================================");

                }
                case 2 -> {
                    //put the NPC creation methode here
                    System.out.println("This is where NPC creation will be");
                    System.out.println("============================================================");
                }
                default -> System.out.print("\nOops: invalid entry. [try again]\n");
            }

        }

        stdin.close();
    }
}
