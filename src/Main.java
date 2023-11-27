
import javafx.application.Application;
import javafx.stage.Stage;
/**
 Cypher Game Manager
    A game management assistant for the table-top RPG system "cypher system" by Monte cook
    Program written by Zac Baker
 */
public class Main extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        BackStage stageHand = new BackStage(primaryStage);

        primaryStage.setTitle("Cypher Game Master");
        stageHand.raiseCurtain();


    }

}