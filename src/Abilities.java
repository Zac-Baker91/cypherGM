public class Abilities {
    private final String name;
    private final String type;
    //cost from stat pool of [type]
    private final int cost;
    public Abilities() {
        this.name = "tag";
        this.type = "tag";
        this.cost = 0;
    }
    public Abilities(String name, String type, int cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
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
