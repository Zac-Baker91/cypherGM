public class Cypher {
    private final String name;
    private final String effect;
    private boolean subtle;
    private boolean manifest;
    private int level;

    public Cypher(String name, String effect, boolean subtle, boolean manifest, int level) {
        this.name = name;
        this.effect = effect;
        this.subtle = subtle;
        this.manifest = manifest;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public boolean isSubtle() {
        return subtle;
    }

    public boolean isManifest() {
        return manifest;
    }

    public int getLevel() {
        return level;
    }

    public void setSubtle(boolean subtle) {
        this.subtle = subtle;
    }

    public void setManifest(boolean manifest) {
        this.manifest = manifest;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
