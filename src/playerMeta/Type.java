package playerMeta;

/**
 * Type is the foundation of the character build.
 */
public class Type {
    String key;
    private Stat Might, Speed, Intellect;
    private Skill[] skillArray = new Skill[36];
    //playerMeta.Abilities are special so they are limited to 10
    private Abilities[] abilitiesArray = new Abilities[20];
    //This is not a game for loot goblins. element 0 should be reserve for player clothing(even if they are nude)
    private Item[] playersBag = new Item[20];
    private int maxCypher;
    public Type(String name) {

        this.key = name.toLowerCase();

        if (this.key.equals("warrior")) {

            this.Might = new Stat(10, 0);
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
        else if (this.key.equals("adept")) {

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
        else if (this.key.equals("explorer")) {

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
        else if (this.key.equals("speaker")) {

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
            throw new IllegalArgumentException("Oops "+key+" is not a valid type!");
        }

    }

    public String getKey() {
        return key;
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

    public Abilities[] getAbilitiesArray() {
        return abilitiesArray;
    }

    public Skill[] getSkillArray() {
        return skillArray;
    }

    public Item[] getPlayersBag() {
        return playersBag;
    }
}
