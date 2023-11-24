import JsonOI.JsonLoad;
import JsonOI.JsonSave;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    static int WINDOWHIGHT = 700;
    static int WINDOWWIDTH = 1500;
    static String MAINIMAGE = "SCP1.png";


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



        
        buttonNPC = new Button("Build Player");
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
        //Foci builder
        buttonFoci = new Button("Build Foci");
        buttonFoci.setOnAction(e->{
            fociAdder();
        });

        //Setting GUI Layout

        HBox buttonLayout = new HBox(20);
        buttonLayout.setBackground(Background.fill(Color.BLACK));
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.getChildren().addAll(buttonNPC,buttonFoci,buttonUpload,buttonViewPC);
        ImageView mainImage = new ImageView();
        TilePane imagePane;
        try {
            mainImage.setImage(getImageFromFile(MAINIMAGE));
            imagePane = new TilePane(mainImage);
            imagePane.setBackground(Background.fill(Color.BLACK));


        } catch (FileNotFoundException e) {
            imagePane = new TilePane(new Text("oops " + e + "not found!"));

            System.out.println("no image found:\n"+e);
        }
        imagePane.setAlignment(Pos.CENTER);
        mainImage.setFitHeight(WINDOWHIGHT - buttonLayout.getHeight());
        mainImage.setPreserveRatio(true);

        VBox layout = new VBox(buttonLayout,imagePane);
        layout.setBackground(Background.fill(Color.BLACK));

        Scene openingScene = new Scene(layout,WINDOWWIDTH,WINDOWHIGHT);
        window.setScene(openingScene);
        window.show();
    }
    private void fociAdder(){
        System.out.println("creating new Focus");

        BorderPane mainPain = new BorderPane();

        Button aReturn = new Button("Return");
        aReturn.setOnAction(e->mainMenu());
        Button build = new Button("Create focus");

        TextField titleField = new TextField("Focus Title");

        TextField tier1Name = new TextField("Tier 1 Ability");
        TextField tier2Name = new TextField("Tier 2 Ability");
        TextField tier3Name = new TextField("Tier 3 Ability");
        TextField tier4Name = new TextField("Tier 4 Ability");
        TextField tier5Name = new TextField("Tier 5 Ability");
        TextField tier6Name = new TextField("Tier 6 Ability");

        TextField tier1Type = new TextField("Type");
        TextField tier2Type = new TextField("Type");
        TextField tier3Type = new TextField("Type");
        TextField tier4Type = new TextField("Type");
        TextField tier5Type = new TextField("Type");
        TextField tier6Type = new TextField("Type");

        TextField tier1Cost = new TextField("Cost");
        TextField tier2Cost = new TextField("Cost");
        TextField tier3Cost = new TextField("Cost");
        TextField tier4Cost = new TextField("Cost");
        TextField tier5Cost = new TextField("Cost");
        TextField tier6Cost = new TextField("Cost");

        TextArea tier1Description = new TextArea("Description");
        TextArea tier2Description = new TextArea("Description");
        TextArea tier3Description = new TextArea("Description");
        TextArea tier4Description = new TextArea("Description");
        TextArea tier5Description = new TextArea("Description");
        TextArea tier6Description = new TextArea("Description");

        HBox tier1Ability = new HBox(tier1Name,tier1Type,tier1Cost,tier1Description);
        HBox tier2Ability = new HBox(tier2Name,tier2Type,tier2Cost,tier2Description);
        HBox tier3Ability = new HBox(tier3Name,tier3Type,tier3Cost,tier3Description);
        HBox tier4Ability = new HBox(tier4Name,tier4Type,tier4Cost,tier4Description);
        HBox tier5Ability = new HBox(tier5Name,tier5Type,tier5Cost,tier5Description);
        HBox tier6Ability = new HBox(tier6Name,tier6Type,tier6Cost,tier6Description);


        EventHandler<ActionEvent> buildfoci = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Abilities ability1[] = new Abilities[]{new Abilities(
                        tier1Name.getText(),
                        tier1Type.getText(),
                        Integer.parseInt(tier1Cost.getText()),
                        tier1Description.getText()
                )};
                Abilities ability2[] = new Abilities[]{new Abilities(
                        tier2Name.getText(),
                        tier2Type.getText(),
                        Integer.parseInt(tier2Cost.getText()),
                        tier2Description.getText()
                )};
                Abilities ability3[] = new Abilities[]{new Abilities(
                        tier3Name.getText(),
                        tier3Type.getText(),
                        Integer.parseInt(tier3Cost.getText()),
                        tier3Description.getText()
                )};
                Abilities ability4[] = new Abilities[]{new Abilities(
                        tier4Name.getText(),
                        tier4Type.getText(),
                        Integer.parseInt(tier4Cost.getText()),
                        tier4Description.getText()
                )};
                Abilities ability5[] = new Abilities[]{new Abilities(
                        tier5Name.getText(),
                        tier5Type.getText(),
                        Integer.parseInt(tier5Cost.getText()),
                        tier5Description.getText()
                )};
                Abilities[] ability6 = new Abilities[]{new Abilities(
                        tier6Name.getText(),
                        tier6Type.getText(),
                        Integer.parseInt(tier6Cost.getText()),
                        tier6Description.getText()
                )};


                Focus tmpF = new Focus(titleField.getText(),
                        ability1,ability2,ability3,ability4,ability5,ability6);

                JsonSave fJson = new JsonSave();
                try {
                    fJson.save(tmpF,"foci/"+titleField.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                fociAdder();
            }
        };


        build.setOnAction(buildfoci);


        mainPain.setCenter(new VBox(10,titleField,tier1Ability,
                tier2Ability,tier3Ability,
                tier4Ability,tier5Ability,tier6Ability));

        mainPain.setBottom(new VBox(10,build,aReturn));
        window.setScene(new Scene(mainPain,WINDOWWIDTH,WINDOWHIGHT));
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
        ScrollPane scroll = new ScrollPane();
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

                scroll.setContent(displayChar);
                boarderP.setCenter(scroll);
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
        buildPane.setSpacing(5);
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
        playerName.setFont(Font.font(null,FontWeight.BOLD, FontPosture.ITALIC,40));

        stat1.setFont(Font.font(null, FontWeight.BOLD,20));

        //Stat Pool Display(Top)
        VBox might =
                new VBox(new Text("Might"),
                        new HBox(new Text("Max: "+player.getType().getMight().getMaxPool()+"  "),
                                new Text("Edge: " + player.getType().getMight().getEdge())),
                        new Text("Current: "+ player.getType().getMight().getCurrentPool())
                        );
        might.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, new CornerRadii(5),Insets.EMPTY)));
        might.setSpacing(5);
        VBox speed =
                new VBox(new Text("Speed"),
                        new HBox(new Text("Max: "+player.getType().getSpeed().getMaxPool()+"  "),
                                new Text("Edge: " + player.getType().getSpeed().getEdge())),
                        new Text("Current: "+ player.getType().getSpeed().getCurrentPool())
                );
        speed.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5),Insets.EMPTY)));
        speed.setSpacing(5);

        VBox intel =
                new VBox(new Text("Intellect"),
                        new HBox(new Text("Max: "+player.getType().getIntellect().getMaxPool()+"  "),
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
        skills.setPrefWidth(sectionWidth);


        //Ability Display Box (Center)
        VBox ability = new VBox();
        ability.setPrefWidth(sectionWidth);

        for(Abilities ab:player.getAbilities()){
            if (ab != null) {
                Text description = new Text(ab.getDescription()+'\n');
                description.setWrappingWidth(sectionWidth);
                Text abilityTitle = new Text(ab.getName() + ": [type: " + ab.getType() + "| cost: " + ab.getCost() + "]");
                abilityTitle.setFont(Font.font(15));
                ability.getChildren().add(new VBox(abilityTitle,description));
            }
        }


        //Bag of Items Display (Left)
        VBox itemBag = new VBox();
        itemBag.setSpacing(5);
        itemBag.setPrefWidth(sectionWidth);
        Text itemTitle = new Text(" Item Bag");
        itemTitle.setFont(Font.font(20));
        Text dividerTop = new Text("=-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-=");

        itemBag.getChildren().addAll(itemTitle,dividerTop);


        for(Item item: player.openItemBag()){
            if (item != null ){
                Text itemInfo = new Text(item.toString());
                itemInfo.setWrappingWidth(sectionWidth);
                Text divider = new Text("=-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-=");
                itemBag.getChildren().addAll(itemInfo,divider);
            }
        }



        playerStat.setTop(new VBox(playerName,stat1,statPools));
        playerStat.setRight(skills);
        playerStat.setCenter(ability);
        playerStat.setLeft(itemBag);



        return playerStat;
    }





    private Image getImageFromFile(String filename) throws FileNotFoundException {

        Path currentRelativePath = Paths.get("");
        String fullPath = currentRelativePath.toAbsolutePath().toString();
        String pathFile = fullPath +"/image/"+filename;


        // create a input stream
        FileInputStream input = new FileInputStream(pathFile);

        // create a image
        return new Image(input);
    }

}
