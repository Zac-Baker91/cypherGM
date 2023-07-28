
import java.util.Scanner;
//--later dev note: consider an init file for array sizes and other hard coded values
//-- later dev note: consider adding synonym list checker for the main types to add versatility
public class Player {
    private  String name;
    private String description;
    //There are 3 words that will define a player's character [descriptor, type, focus]
    //but Type is the foundation of your character build and is used to construct new characters.
    private String descriptor, type, focus;
    //There are 3 base Stats Might Speed and Intellect.
    private Stat Might, Speed, Intellect;
    //Tier is players level and effort is used to modify the challenge level of a die roll.
    private int tier,effort,xp;
    // 36 is the number of skill slots provided on the character sheet provide with the rule book
    private Skill[] skillArray = new Skill[36];
    //Abilities are special so they are limited to 10
    private Abilities[] abilitiesArray = new Abilities[10];
    //This is not a game for loot goblins. element 0 should be reserve for player clothing(even if they are nude)
    private Item[] playersBag = new Item[15];
    //meant for quick use. hold to many and thing get weird....
    private Cypher[] cypherArray = new Cypher[4];
    private int maxCypher;


    public Player(String name, String descriptor, String type, String focus) {
        this.name = name;
        this.descriptor = descriptor.toLowerCase();
        this.type = type.toLowerCase();
        this.focus = focus.toLowerCase();
        this.effort = 1;

        //Parsing Types
        if (type.equals("warrior")) {

            this.Might = new Stat(10, 1);
            this.Speed = new Stat(10, 0);
            this.Intellect = new Stat(8, 0);
            this.maxCypher = 2;

            this.skillArray[0] = new Skill("Any Weapon", true, false, false);

            this.playersBag[0] = new Item("your naked! please cloths");
            this.playersBag[1] = new Item("weapon1");
            this.playersBag[2] = new Item("weapon2");
            this.playersBag[3] = new Item("expensive item");
            this.playersBag[4] = new Item("moderate item");
            this.playersBag[5] = new Item("moderate item");
            this.playersBag[6] = new Item("cheap item");
            this.playersBag[7] = new Item("cheap item");
            this.playersBag[8] = new Item("cheap item");
            this.playersBag[9] = new Item("cheap item");

            this.abilitiesArray[0] = new Abilities();
            this.abilitiesArray[1] = new Abilities();

        }
        else if (type.equals("adept")) {

            this.Might = new Stat(7, 0);
            this.Speed = new Stat(9, 0);
            this.Intellect = new Stat(12, 1);
            this.maxCypher = 3;

            this.skillArray[0] = new Skill("medium weapons", false, false, true);
            this.skillArray[1] = new Skill("heavy weapons", false, false, true);

            this.playersBag[0] = new Item("your naked! please cloths");
            this.playersBag[1] = new Item("expensive item");
            this.playersBag[2] = new Item("expensive item");
            this.playersBag[3] = new Item("moderate item");
            this.playersBag[4] = new Item("moderate item");
            this.playersBag[5] = new Item("cheap item");
            this.playersBag[6] = new Item("cheap item");
            this.playersBag[7] = new Item("cheap item");
            this.playersBag[8] = new Item("cheap item");

            this.abilitiesArray[0] = new Abilities();
            this.abilitiesArray[1] = new Abilities();
            this.abilitiesArray[2] = new Abilities();
            this.abilitiesArray[3] = new Abilities();

        }
        else if (type.equals("explorer")) {

            this.Might = new Stat(10, 1);
            this.Speed = new Stat(9, 0);
            this.Intellect = new Stat(9, 0);
            this.maxCypher = 2;

            this.skillArray[0] = new Skill("heavy weapons", false, false, true);

            this.playersBag[0] = new Item("your naked! please cloths");
            this.playersBag[1] = new Item("weapon");
            this.playersBag[2] = new Item("expensive item");
            this.playersBag[3] = new Item("expensive item");
            this.playersBag[4] = new Item("moderate item");
            this.playersBag[5] = new Item("moderate item");
            this.playersBag[6] = new Item("cheap item");
            this.playersBag[7] = new Item("cheap item");
            this.playersBag[8] = new Item("cheap item");
            this.playersBag[9] = new Item("cheap item");

            this.abilitiesArray[0] = new Abilities();
            this.abilitiesArray[1] = new Abilities();
            this.abilitiesArray[2] = new Abilities();
            this.abilitiesArray[3] = new Abilities();

        }
        else if (type.equals("speaker")) {

            this.Might = new Stat(8, 0);
            this.Speed = new Stat(9, 0);
            this.Intellect = new Stat(11, 1);
            this.maxCypher = 2;

            this.skillArray[0] = new Skill("medium weapons", false, false, true);
            this.skillArray[1] = new Skill("heavy weapons", false, false, true);

            this.playersBag[0] = new Item("your naked! please cloths");
            this.playersBag[1] = new Item("weapon");
            this.playersBag[2] = new Item("expensive item");
            this.playersBag[3] = new Item("expensive item");
            this.playersBag[4] = new Item("moderate item");
            this.playersBag[5] = new Item("moderate item");
            this.playersBag[6] = new Item("cheap item");
            this.playersBag[7] = new Item("cheap item");
            this.playersBag[8] = new Item("cheap item");
            this.playersBag[9] = new Item("cheap item");

            this.abilitiesArray[0] = new Abilities();
            this.abilitiesArray[1] = new Abilities();
            this.abilitiesArray[2] = new Abilities();
            this.abilitiesArray[3] = new Abilities();

        }
        else {
            //This would be where synonym checker would find new synonym
            System.out.println("Oops:" + type + " is not a valid type");
            this.effort = -1;
        }
        this.description = name + " is a " + descriptor + " " + type + " who " + focus + "!";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String getType() {
        return type;
    }

    public String getFocus() {
        return focus;
    }

    public Stat getMight() {
        return Might;
    }

    public Stat getSpeed() {
        return Speed;
    }

    public Stat getIntellect() {
        return Intellect;
    }

    public int getTier() {
        return tier;
    }

    public int getEffort() {
        return effort;
    }

    public int getXp() {
        return xp;
    }

    public Skill[] getSkillArray() {
        return skillArray;
    }

    public Abilities[] getAbilitiesArray() {
        return abilitiesArray;
    }

    public Item[] getPlayersBag() {
        return playersBag;
    }

    public Cypher[] getCypherArray() {
        return cypherArray;
    }

    public int getMaxCypher() {
        return maxCypher;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public void setMaxCypher(int maxCypher) {
        this.maxCypher = maxCypher;
    }

    //todo manipulators



}
