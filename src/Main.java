
import JsonOI.JsonLoad;
import playerMeta.Abilities;
import playerMeta.Player;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 Cypher Game Manager
    A game management assistant for the table-top RPG system "cypher system" by Monte cook
    Program written by Zac Baker
 */
public class Main {
    public static void main(String[] args) throws IOException {

        //control bool for options loop
        boolean optExit = true;
        //ten player is a lot of people at the table
        Player[] playArray = new Player[10];
        int ptrPlayer = 0;

        Abilities[] avalibleAblities;

        Scanner stdin = new Scanner(System.in);
        System.out.println("Welcome the Cypher System Game Management.");
        //todo look for abilities json for what abilities this session will use.
        fociBuilder(stdin);

        //input checking loop - switch allows for easy addition or removal of options
        while (optExit) {
            System.out.print("""
                    Select on option bellow (enter number)
                    [1] Player Creation    [2] Load Player    [3]View Player   [0]Exit
                    """);
            String selection = stdin.nextLine();
            int selectNum;
            try{
                selectNum = Integer.parseInt(selection);
            }catch(NumberFormatException nfe){
                selectNum = -1;
            }
            switch (selectNum) {
                case 1 -> {
                    //playerMeta.Player base stats are generated using a sentence
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
                    /*
                     During construction warrior player can edge in might or speed.
                     to void user input in constructor resolve this edge case after construction
                     */
                    if (n00b.getType().getKey().equals("warrior")) {
                        System.out.println("Warrior choose : [1]might or [2]speed");
                        int p = stdin.nextInt();
                        stdin.nextLine();
                        if (p == 1) n00b.getType().getMight().modEdge(1);
                        else if (p == 2) n00b.getType().getSpeed().modEdge(1);
                        else System.out.println("Bad input now you are weak and slow LOLz");
                    }

                    n00b.savePlayer();
                    //loads player in player array for use is session
                    if(ptrPlayer < 10){
                        playArray[ptrPlayer] = n00b;
                        ptrPlayer++;
                    } else System.out.println("Oops: there are already 10 plays, that's the max!");

                    // todo playerMeta.Player need to choose specifics items, using item tags with name = tag as place holder.

                    //todo playerMeta.Player chooses from ability list, using tags for abilities array.

                    //todo non-standard player types need to be re-constructed with standard types.



                    System.out.println("Welcome "+n00b.getDescription());

                    System.out.println("============================================================");

                }
                case 2 -> {
                    System.out.println("What is the name of the player you want to download?");
                    String filename = stdin.next();
                    stdin.nextLine();
                    JsonLoad download = new JsonLoad();
                    Player player = (Player) download.LoadByFileName("savefile/" + filename, Player.class);
                    if(ptrPlayer < 10){
                        playArray[ptrPlayer] = player;
                        ptrPlayer++;
                    } else System.out.println("Oops: there are already 10 plays, that's the max!");

                }
                case 3-> {

                    System.out.println("What is the name of the player you need info for?");
                    String key = stdin.next();
                    stdin.nextLine();
                    int count = 0;
                    for (Player player: playArray){
                        if (Objects.equals(player.getName(), key)){
                            playArray[count].display();
                            break;
                        }
                        count++;
                        if(count == playArray.length) System.out.println("playerMeta.Player not found!");

                    }
                }
                case 0 -> {
                    optExit = false;
                }
                default -> System.out.print("\nOops: invalid entry. "+selectNum+"[try again]\n");
            }

        }

        stdin.close();
    }

    public static void fociBuilder(Scanner stdin){
        System.out.print("Hey GM before you start building players you need to set up their foci options. Let's GO! ");

    }
}