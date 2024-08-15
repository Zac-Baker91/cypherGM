package playerMeta;
/**
 * Abilities are specifics action that can be done at a cost.
 * They typically use a  teir and type rated to a stat pool
 **/
public class Abilities {
    private  String name;
    private String type;

    private int tier;
    private final String description;
    //Default constructor creates a 'tag' Object as a placeholder when player input is needed.
    public Abilities() {
        this.name = "tag";
        this.type = "tag";
        this. tier = 0;
        this.description = "no description";
    }
    public Abilities(String name, String type, int  tier,String description) {
        this.name = name;
        this.type = type;
        this. tier =  tier;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return name + ": " +
                ", type='" + type  +
                ",  tier=" +  tier +
                "\ndescription='" + description;
    }
}
