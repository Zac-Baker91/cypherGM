

//-- later dev note: consider adding synonym list checker for the main types to add versatility


import playerMeta.*;

/**
 * Player is the main object that contains all the information that would be found a typical player's character sheet.
 */
public class Player {
    private final String name;
    private final String description;

    private final Descriptor descriptor;
    private final Focus focus;
    private Type type;
    private Stat Might, Speed, Intellect;

    //Tier is players level and effort is used to modify the challenge level of a die roll.
    private int tier,effort,xp;
    private Skill[] skillArray;
    //playerMeta.Abilities are special so they are limited to 10
    private Abilities[] abilitiesArray;
    //This is not a game for loot goblins. element 0 should be reserve for player clothing(even if they are nude)
    private Cypher[] cypherArray = new Cypher[4];
    private int maxCypher;


    public Player(String name, String descriptor, String type, String focus) {
        this.name = name;
        this.effort = 1;
        this.tier = 1;
        this.xp = 0;

        this.description = name + " is a " + descriptor + " " + type + " who " + focus + "!";
        this.type = new Type(type);
        this.descriptor = Descriptor.keyNameof(descriptor);
        //for the simple builder these values are hard coded later it will need user input
        this.focus = new Focus(
                new Abilities[]{new Abilities("Blue Steal","intellect",1,
                        "Lock eyes with someone and overwhelm them with your Machismo")},
                new Abilities[]{new Abilities("Force Entry","might",1,
                        "can force your way through enter ways")},
                new Abilities[]{new Abilities("test","test",0,"test")},
                new Abilities[]{new Abilities("test","test",0,"test")},
                new Abilities[]{new Abilities("test","test",0,"test")},
                new Abilities[]{new Abilities("test","test",0,"test")}
        );

        assert this.descriptor != null;
        Abilities[] tmpA = abilityCat(this.type.getAbilitiesArray(),this.descriptor.abilityArray);
        abilityCat(this.focus.tierOne(),tmpA);

        skillCat(this.type.getSkillArray(), this.descriptor.skillsArray);


    }

//Display function that prints character info to stdout
    public void display(){
        System.out.println("Name: "+this.name);
        System.out.println("effort: "+this.effort+"  Tier: "+this.tier+"  xp: "+ this.xp);
        System.out.println("Might: "+this.getType().getMight().toString());
        System.out.println("Speed: "+this.getType().getSpeed().toString());
        System.out.println("Intellect: "+this.getType().getIntellect().toString());
        System.out.println("Skill:");
        for(Skill s : this.skillArray ){
            if(s != null){
                System.out.println(s.toString());
            }//else{
                //DEBUG line for arrays
                //System.out.println("NULL");

            //}
        }
        System.out.println("Abilities: ");
        for (Abilities a: this.abilitiesArray){
            if(a != null){
                System.out.println(a.toString());
            }//else{
                //DEBUG line for arrays
                //System.out.println("NULL");
            //}
        }
        System.out.println("Bag: ");
        for(Item i : this.type.getPlayersBag()) {
            if(i != null){
                System.out.println(i.toString());
            }//else{
                //DEBUG line for arrays
                //System.out.println("NULL");
            //}
        }
    }
    //Concatenates ability arrays. It returns the concatenated array
    public Abilities[] abilityCat(Abilities[] a1, Abilities[] a2){
        int length = a1.length + a2.length;

        Abilities[] result = new Abilities[length];
        int pos = 0;
        for (Abilities e : a1) {
            result[pos] = e;
            pos++;
        }

        for (Abilities e : a2) {
            result[pos] = e;
            pos++;
        }
        this.abilitiesArray =  result;
        return result;
    }
    //Concatenates Skill arrays. It returns the concatenated array
    public Skill[] skillCat(Skill[] a1, Skill[] a2){
        int length = a1.length + a2.length;

        Skill[] result = new Skill[length];
        int pos = 0;
        for (Skill e : a1) {
            result[pos] = e;
            pos++;
        }
        for (Skill e : a2) {
            result[pos] = e;
            pos++;
        }
        this.skillArray =  result;
        return result;
    }

    public String getDescription() {
        return description;
    }

    public int getTier() {
        return tier;
    }

    public Type getType() {
        return type;
    }

    public int getEffort() {
        return effort;
    }

    public int getXp() {
        return xp;
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

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setMaxCypher(int maxCypher) {
        this.maxCypher = maxCypher;
    }

    public Item[] openItemBag(){
        return this.type.getPlayersBag();
    }

    public Abilities[] getAbilities() {
            return this.abilitiesArray;
    }

}
