package playerMeta;
/**
 * Record that contains arrays of ability's by tier 1-6.
 * These Foci are highly unique to the game and the players, They should are constructed using user input.
 **/
public record Focus(String name,String description,String[] connectionOptions,String[] additionalEquipment, Abilities[] Abilities_array) {
    @Override
    public String toString(){
        return this.name();
    }
}
