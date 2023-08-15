package playerMeta;

//built to match json save file
public class Skill {

    private String name;
    private boolean trained;
    private boolean specialized;
    private boolean disability;

    public Skill(){
        this.name="tag";
        this.trained = false;
        this.specialized = false;
        this.disability = false;
    }
    public Skill( String name,  boolean trained, boolean specialized, boolean disability){
        this.name = name;
        this.trained = trained;
        this.specialized = specialized;
        this.disability = disability;
    }
    //playerMeta.Cypher uses Challenge modifiers to effect difficulty of dice roles
    //accessor function return [-1,1,2] as modifier value.
    public int getChallengeMod(){
        int modVal = 0;
        if (trained) modVal++;
        if (specialized) modVal++;
        if (disability) modVal--;
        return (modVal);
    }

    public void setSpecialized(boolean specialized) {
        this.specialized = specialized;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public String getName() {
        return name;
    }
}
