import javafx.stage.Stage;


/**
 * Class contains all the behind the sense work for the stage;
 */
public class BackStage {

    Stage window;

    public BackStage(Stage window) {
        this.window = window;
    }
    public void buildNPC(){
        System.out.println("build my character");
    }
    public void viewNPCs(){
        System.out.println("view my character");
    }
    public void loadNPC(){
        System.out.println("Load Save files");
    }



}
