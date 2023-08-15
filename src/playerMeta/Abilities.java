package playerMeta;

public class Abilities {
    private  String name;
    private String type;
    //cost from stat pool of [type]
    private int cost;
    private String description;
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

}
