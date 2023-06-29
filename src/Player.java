import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    //There are 3 base Skill Might Speed and Intellect.
    //each has a Pool and Edge. Pool is your capacity and edge is your skill level.
    private class Skill{
        private int currentPool;
        private int edge;
        private int maxPool;
        public Skill(){
            currentPool = -1;
            maxPool = -1;
            edge = -1;
        }
        public Skill(int p,int e){
            currentPool = p;
            maxPool = p;
            edge = e;
        }



    }
    private Skill might, speed, intellect;

    //Tier is players level and effort is used make action easier
    private int tier,effort,xp;
    private Action[] actionArray = new Action[36];

    public Player(String name, String descriptor,String type,String focus){
        System.out.println(name + " the " + descriptor +" "+ type+" who " + focus + " has been born!");

    }



}
