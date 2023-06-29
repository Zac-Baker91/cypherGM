import java.util.HashMap;

public class Action {
    private enum Level {
        INABILITY,
        TRAINED,
        SPECIALIZED
    }
    private Level actionLvl;
    private String description;
    private String type;

    //the int that is passed in the constructor should be [-1, 1, 2]:[Inability, Trained, Specialized]
    //type is the skill type the action fits under.
    public Action(String description, int level, String type){
        this.description = description;
        this.type = type;

        switch(level){
            case -1 -> {
                actionLvl = Level.INABILITY;

            }
            case 1 -> {
                actionLvl = Level.TRAINED;

            }
            case 2 -> {
                actionLvl = Level.SPECIALIZED;
            }

        }
    }

    //NEEDS GETTERS and SETTERS


}
