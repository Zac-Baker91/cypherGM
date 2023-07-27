

public class Player {
    private final String name;
    private  String Description;
    //There are 3 words that will define a player's character [descriptor, type, focus]
    private final String descriptor, type, focus;
    //There are 3 base Stats Might Speed and Intellect.
    private Stat Might, Speed, Intellect;
    //Tier is players level and effort is used to modify the challenge level of a die roll.
    private int tier,effort,xp;
    // 36 is the number of skill slots provided on the character sheet provide with the rule book
    private Skill[] statsArray = new Skill[36];
    //Abilities are special so they are limited to 10
    private Abilities[] abilitiesArray = new Abilities[10];
    //This is not a game for loot goblins
    private Item[] playersBag = new Item[10];
    //meant for quick use hold to many and thing get weird....
    private Cypher[] cypherArray = new Cypher[4];


    public Player(String name, String descriptor, String type, String focus) {
        this.name = name;
        this.descriptor = descriptor;
        this.type = type;
        this.focus = focus;
        //todo !!!this is where character generation gets cool!!!
        System.out.println(name + " the " + descriptor +" "+ type+" who " + focus + " has been born!");
    }
}
