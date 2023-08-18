package playerMeta;
/**
 * Abilities are specifics action that can be done at a cost.
 * They typically use a cost and type rated to a stat pool
 **/
public class Abilities {
    private  String name;
    private String type;

    private int cost;
    private final String description;
    //Default constructor creates a 'tag' Object as a placeholder when player input is needed.
    public Abilities() {
        this.name = "tag";
        this.type = "tag";
        this.cost = 0;
        this.description = "no description";
    }
    public Abilities(String name, String type, int cost,String description) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + ": " +
                ", type='" + type  +
                ", cost=" + cost +
                "\ndescription='" + description;
    }
}
