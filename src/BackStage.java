import JsonOI.JsonSave;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import playerMeta.Descriptor;
import playerMeta.Focus;
import playerMeta.Player;
import playerMeta.Type;

import java.io.IOException;


/**
 * Class contains all the behind the sense work for the stage;
 */
public class BackStage {

    Stage window;
    Player[] Players = new Player[10];

    int playerCount = 0;


    public BackStage(Stage window) {
        this.window = window;
    }

    public void raiseCurtain(){
        mainMenu();
    }
    private void mainMenu(){
        Button buttonNPC;
        Button buttonUpload;
        Button buttonViewNPC;
        Button buttonFoci;

        Label title = new Label("Main Menu");
        buttonNPC = new Button("Build NPC");
        buttonNPC.setOnAction(e->buildNPC());
        buttonUpload = new Button("Upload NPC");
        buttonUpload.setOnAction(e-> loadNPC());
        buttonViewNPC = new Button("View NPC");
        buttonViewNPC.setOnAction(e -> viewNPCs());
        buttonFoci = new Button("List Foci");




        VBox layout = new VBox(20);
        layout.getChildren().addAll(title,buttonNPC,buttonUpload,buttonViewNPC);

        Scene openingScene = new Scene(layout,600,500);
        window.setScene(openingScene);
        window.show();
    }
    private void buildNPC(){

        System.out.println("Entering character builder");
        JsonSave jsonSave = new JsonSave();
        //building local data structures
        String[] focusOption = {"Has a third eye","is O-5","is unShakable", "has been beyond" };

        //building Gui elements
        Label title = new Label("Who are you?: <Name> is a <Descriptor> <Type> who <Focus>");
        HBox titlePane = new HBox();
        titlePane.getChildren().add(title);
        titlePane.setAlignment(Pos.CENTER);

        //Initializing contollers
        TextField nameField = new TextField("Name");
        ChoiceBox<Descriptor> descriptionBox = new ChoiceBox<>();
        ChoiceBox<String> typeBox = new ChoiceBox<>();
        ChoiceBox<String> focusBox = new ChoiceBox<>();
        descriptionBox.getItems().setAll(Descriptor.values());
        typeBox.getItems().setAll("Warrior","Adept","Explorer","Speaker");
        focusBox.getItems().setAll(focusOption);



        //This event handles creating and saving player based on name input and choice box selection.
        EventHandler<ActionEvent> buildEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {

                String playerName = nameField.getText();
                Descriptor playerDescriptor = descriptionBox.getSelectionModel().getSelectedItem();
                String playerType = typeBox.getSelectionModel().getSelectedItem();
                String playerFocus = focusBox.getSelectionModel().getSelectedItem();

                Player n00b = new Player(playerName, playerDescriptor.keyName, playerType, playerFocus);
                System.out.println("Build Character: "+n00b.getDescription());

                //add new player to class var Player and saves player to json
                Players[playerCount] = n00b;
                playerCount++;
                try {
                    jsonSave.save(n00b, n00b.getName());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        };
        //Bottom bar buttons
        Button buildPlayer = new Button("Build Player");
        buildPlayer.setOnAction(buildEvent);
        Button backB = new Button("Return");
        backB.setOnAction(e -> mainMenu());


        HBox centerB = new HBox(15);
        centerB.getChildren().addAll(nameField, descriptionBox,typeBox,focusBox);

        HBox buildPane = new HBox(buildPlayer,backB);

        BorderPane boarderP = new BorderPane();
        boarderP.setCenter(centerB);
        boarderP.setTop(titlePane);
        boarderP.setBottom(buildPane);

        this.window.setScene(new Scene(boarderP,600,500));
    }
    private void viewNPCs(){
        System.out.println("view my character");
    }
    private void loadNPC(){
        System.out.println("Load Save files");
    }
    private void buildFoci(){

    }


}
