package playerMeta;
/**
 * Items are things that player carry in their bag: weapons, clothing, necronomicon...whatever
**/
public class Item {
    private String name;
    private String range;
    private int damage;
    private String durability;
    private String description;

    //playerMeta.Item(String name) constructor used to create tags for unspecified items in playerMeta.Item arrays
    public Item(String description){
        this.name = "Tag";
        this.range = "";
        this.damage = -1;
        this.durability = "";
        this.description = description;
    }
    //Constructor for adding Items during game play.
    public Item(String name, String range, int damage, String durability, String description) {
        this.name = name;
        this.range = range;
        this.damage = damage;
        this.durability = durability;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public String getDurability() {
        return durability;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  name + '\'' +
                ", range='" + range + '\'' +
                ", damage=" + damage +
                ", durability='" + durability + '\'' +
                ", description='" + description;
    }
}
