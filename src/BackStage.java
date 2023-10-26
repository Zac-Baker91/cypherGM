import JsonOI.JsonLoad;
import JsonOI.JsonSave;
import com.sun.prism.paint.Paint;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playerMeta.*;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Class contains all the behind the sense work for the stage;
 */
public class BackStage {

    Stage window;
    Player[] players = new Player[10];
    BackgroundFill mainFill = new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY);
    Background mainBackdrop = new Background(mainFill);



    int playerCount = 0;
    int WINDOWHIGHT = 700;
    int WINDOWWIDTH = 1500;


    public BackStage(Stage window) {
        this.window = window;
    }

    public void raiseCurtain(){
        mainMenu();
    }
    private void lowerCurtain(){
        //todo methode to be used when properly quiting app
    }
    private void mainMenu(){
        Button buttonNPC;
        Button buttonUpload;
        Button buttonViewPC;
        Button buttonFoci;



        Label title = new Label("Main Menu");
        buttonNPC = new Button("Build NPC");
        buttonNPC.setOnAction(e-> {
            try {
                buildNPC();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonUpload = new Button("Upload Player");
        buttonUpload.setOnAction(e-> loadPC());
        buttonViewPC = new Button("View Player");
        buttonViewPC.setOnAction(e -> {
            try {
                viewPCs();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        buttonFoci = new Button("List Foci");




        VBox layout = new VBox(20);
        layout.getChildren().addAll(title,buttonNPC,buttonUpload,buttonViewPC);

        Scene openingScene = new Scene(layout,WINDOWWIDTH,WINDOWHIGHT);
        openingScene.setFill(Color.BISQUE);
        window.setScene(openingScene);
        window.show();
    }
    private void buildNPC() throws IOException {

        System.out.println("Loading foci options...");
        JsonSave jsonSave = new JsonSave();


        //building local data structures
        Focus[] foci = buildFoci();
        String[] focusOption = new String[foci.length];
        int i = 0;
        for (Focus f:foci) {
            System.out.println(f.name());
            focusOption[i] = f.name();
            i++;
        }


        //building Gui elements
        Label title = new Label("Who are you?: <Name> is a <Descriptor> <Type> who <Focus>");
        VBox titlePane = new VBox();
        titlePane.getChildren().add(title);


        //Initializing contollers
        BorderPane boarderP = new BorderPane();
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

                BorderPane displayChar = playerStatPane(n00b);
                boarderP.setCenter(displayChar);
                //add new player to class var Player and saves player to json
                players[playerCount] = n00b;
                playerCount++;
                try {
                    jsonSave.save(n00b.getFocus(), n00b.getName());
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
        centerB.setAlignment(Pos.CENTER);

        HBox buildPane = new HBox(buildPlayer,backB);
        titlePane.getChildren().add(centerB);
        titlePane.setAlignment(Pos.CENTER);

        boarderP.setTop(titlePane);
        boarderP.setBottom(buildPane);

        this.window.setScene(new Scene(boarderP,WINDOWWIDTH,WINDOWHIGHT));
    }
    private void viewPCs() throws FileNotFoundException {
        System.out.println("Loading character...");
        TabPane tabPane = new TabPane();

        int i = 0;
        for (Player p:players) {
            if(p != null) {
                System.out.println(p.getName() + " added to tabs");
                Tab tab = new Tab();
                tab.setText(p.getName());
                tab.setContent(playerStatPane(p));
                tabPane.getTabs().add(tab);
            }else {
                System.out.println("Chair "+i+" is empty");
            }
            i++;
        }
        this.window.setScene(new Scene(tabPane,WINDOWWIDTH,WINDOWHIGHT));

    }
    private Player loadPC(){
        System.out.println("Load Save files");
        return null;
    }
    private Focus[] buildFoci() throws IOException {
        JsonLoad jsonLoader = new JsonLoad();
        Object[] fociObj =  jsonLoader.LoadAllJsonInDirectory("savefile/foci", Focus.class);

        Focus[] foci = new Focus[fociObj.length];
        int ptr = 0;
        for(Object fo : fociObj){
            foci[ptr] = (Focus) fo;
            ptr++;
        };
        return foci;

    }
    private BorderPane playerStatPane (Player player){

        int sectionWidth = (WINDOWWIDTH/3)-5;
        BorderPane playerStat = new BorderPane();
        playerStat.setBackground(mainBackdrop);
        //check for null player objects
        if (player == null){
            System.out.println("oops that players seat is empty");
            Label oops = new Label("empty chair");
            playerStat.setTop(oops);
            return playerStat;
        }

        //Basic Player Info(Top)
        Text playerName = new Text(player.getName());
        Text stat1 = new Text("effort: "+player.getEffort()+"  Tier: "+player.getTier()+"  xp: "+ player.getXp());
        playerName.setFont(Font.font(null,FontWeight.BOLD, FontPosture.ITALIC,25));

        stat1.setFont(Font.font("Roboto", FontWeight.BOLD,20));

        //Stat Pool Display(Top)
        VBox might =
                new VBox(new Text("Might"),
                        new HBox(new Text("Max: "+player.getType().getMight().getMaxPool()),
                                new Text("Edge: " + player.getType().getMight().getEdge())),
                        new Text("Current: "+ player.getType().getMight().getCurrentPool())
                        );
        might.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, new CornerRadii(5),Insets.EMPTY)));
        might.setSpacing(5);
        VBox speed =
                new VBox(new Text("Speed"),
                        new HBox(new Text("Max: "+player.getType().getSpeed().getMaxPool()),
                                new Text("Edge: " + player.getType().getSpeed().getEdge())),
                        new Text("Current: "+ player.getType().getSpeed().getCurrentPool())
                );
        speed.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),Insets.EMPTY)));
        speed.setSpacing(5);
        VBox intel =
                new VBox(new Text("Intellect"),
                        new HBox(new Text("Max: "+player.getType().getIntellect().getMaxPool()),
                                new Text("Edge: " + player.getType().getIntellect().getEdge())),
                        new Text("Current: "+ player.getType().getIntellect().getCurrentPool())
                );
        intel.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, new CornerRadii(5),Insets.EMPTY)));
        intel.setSpacing(5);
        HBox statPools = new HBox(might,speed,intel);
        statPools.setSpacing(3);


        //Skill Display Box (Right)
        VBox title = new VBox();
        VBox skillLevel = new VBox();

        title.getChildren().add(new Text("Skill"));
        skillLevel.getChildren().add(new Text("Trained|Specialized|Disability"));

        for(Skill skill : player.getSkillArray()){
            if(skill != null) {
                title.getChildren().add(new Text(skill.getName()));
                skillLevel.getChildren().add(new Text(skill.uiString()));
            }
        }
        HBox skills = new HBox(title,skillLevel);

        //Ability Display Box (Center)
        VBox ability = new VBox();

        for(Abilities ab:player.getAbilities()){
            if (ab != null) {
                Text description = new Text(ab.getDescription());
                description.setWrappingWidth(sectionWidth);
                ability.getChildren().add(
                        new VBox(
                                new Text(ab.getName() + ": [type:" + ab.getType() + "| cost:" + ab.getCost() + "]"),
                                description
                                )
                );
            }
        }


        //Bag of Items Display (Left)
        VBox itemBag = new VBox();
        for(Item item: player.openItemBag()){
            if (item != null ) itemBag.getChildren().add(new Text(item.toString()));
        }



        playerStat.setTop(new VBox(playerName,stat1,statPools));
        playerStat.setRight(skills);
        playerStat.setCenter(ability);
        playerStat.setLeft(itemBag);


        return playerStat;
    }




    //setBackgroundImage needs work side lined for now
    private BackgroundImage setBackgroundImage(String filename) throws FileNotFoundException {

        Path currentRelativePath = Paths.get("");
        String fullPath = currentRelativePath.toAbsolutePath().toString();
        String pathFile = fullPath +"/image/"+filename;


        // create a input stream
        FileInputStream input = new FileInputStream(pathFile);

        // create a image
        Image image = new Image(input);

        BackgroundSize bSize = new BackgroundSize(20,20,false,false,false,true);

        BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                bSize);


        return backgroundImage;
    }

}
