public class Item {
    private final String name;
    private final String range;
    private final int damage;
    private final String durability;
    private final String description;

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

}
