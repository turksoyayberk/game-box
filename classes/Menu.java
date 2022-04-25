package Sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.*;

public class Menu extends Application {

    ///We created integer variables that hold HighScore data.
    private int highScore1 = 0;
    private int highScore2 = 0;
    private int highScore3 = 0;
    private int highScore4 = 0;
    private int highScore5 = 0;
    ///
    ///We created variables that show the playability of the levels.
    private boolean level1 = true;
    private boolean level2 = false;
    private boolean level3 = false;
    private boolean level4 = false;
    private boolean level5 = false;
    ///
    ///We created buttons for levels.
    Button level1Button = new Button("Level1");
    Button level2Button = new Button("Level2");
    Button level3Button = new Button("Level3");
    Button level4Button = new Button("Level4");
    Button level5Button = new Button("Level5");
    ///
    ///We created a warning text in case of player clicks on unplayable level button.
    Label warningText = new Label();
    ///
    ///Here we created the setter and getter methods of the variables
    // because we set the variables when returning from level 5 to the menu and use getter methods.
    public boolean isLevel1() { return level1; }
    public void setLevel1(boolean level1) { this.level1 = level1; }
    public boolean isLevel2() { return level2; }
    public void setLevel2(boolean level2) {
        this.level2 = level2;
    }
    public boolean isLevel3() {
        return level3;
    }
    public void setLevel3(boolean level3) {
        this.level3 = level3;
    }
    public boolean isLevel4() {
        return level4;
    }
    public void setLevel4(boolean level4) {
        this.level4 = level4;
    }
    public boolean isLevel5() {
        return level5;
    }
    public void setLevel5(boolean level5) {
        this.level5 = level5;
    }
    public int getHighScore1() {
        return highScore1;
    }
    public void setHighScore1(int highScore1) {
        this.highScore1 = highScore1;
    }
    public int getHighScore2() {
        return highScore2;
    }
    public void setHighScore2(int highScore2) {
        this.highScore2 = highScore2;
    }
    public int getHighScore3() {
        return highScore3;
    }
    public void setHighScore3(int highScore3) {
        this.highScore3 = highScore3;
    }
    public int getHighScore4() {
        return highScore4;
    }
    public void setHighScore4(int highScore4) {
        this.highScore4 = highScore4;
    }
    public int getHighScore5() {
        return highScore5;
    }
    public void setHighScore5(int highScore5) {
        this.highScore5 = highScore5;
    }
    ///

    private void HandleButtonClick(ActionEvent event)//We wrote code that determines how the buttons behave if they are clicked.
    {
        if(event.getSource()==level1Button)
        {
            Level1 level1Scene = new Level1(getHighScore1(), getHighScore2(), getHighScore3(), getHighScore4(), getHighScore5());
            level1Scene.start(stage1);
        }
        if(event.getSource()==level2Button)
        {
            Level2 level2Scene = new Level2(getHighScore1(), getHighScore2(), getHighScore3(), getHighScore4(), getHighScore5());
            if(isLevel2())
            {
                level2Scene.start(stage1);
            }
            else
            {
                warningText.setText("Finish all the levels before to unlock");
            }
        }
        if(event.getSource()==level3Button)
        {
            Level3 level3Scene = new Level3(getHighScore1(), getHighScore2(), getHighScore3(), getHighScore4(), getHighScore5());
            if(isLevel3())
            {
                level3Scene.start(stage1);
            }
            else
            {
                warningText.setText("Finish all the levels before to unlock");
            }
        }
        if(event.getSource()==level4Button)
        {
            Level4 level4Scene = new Level4(getHighScore1(), getHighScore2(), getHighScore3(), getHighScore4(), getHighScore5());
            if(isLevel4())
            {
                level4Scene.start(stage1);
            }
            else
            {
                warningText.setText("Finish all the levels before to unlock");
            }
        }
        if(event.getSource()==level5Button)
        {
            Level5 level5Scene = new Level5(getHighScore1(), getHighScore2(), getHighScore3(), getHighScore4(), getHighScore5());
            if(isLevel5())
            {
                level5Scene.start(stage1);
            }
              else
            {
                warningText.setText("Finish all the levels before to unlock");
            }

        }
    }
    Stage stage1= new Stage();///We wrote stage1 for the handleButtonClick method.
    public void start(Stage stage) {
        stage1=stage;

        ///Level screen.
        BorderPane levelBorderPane = new BorderPane();
        VBox levelVBox = new VBox();
        levelBorderPane.setStyle("-fx-background-color: DARKSLATEGREY");
        ///We created the content of the Level screen.
        level1Button.setPrefSize(80, 40);
        level2Button.setPrefSize(80, 40);
        level3Button.setPrefSize(80, 40);
        level4Button.setPrefSize(80, 40);
        level5Button.setPrefSize(80, 40);

        warningText.setStyle("-fx-font: 11 arial;");
        warningText.setTextFill(Color.WHITE);

        level1Button.setOnAction(this::HandleButtonClick);
        level2Button.setOnAction(this::HandleButtonClick);
        level3Button.setOnAction(this::HandleButtonClick);
        level4Button.setOnAction(this::HandleButtonClick);
        level5Button.setOnAction(this::HandleButtonClick);

        levelVBox.getChildren().addAll(warningText,level1Button, level2Button, level3Button, level4Button, level5Button);
        levelVBox.setPadding(new Insets(100, 0, 0, 200));
        levelVBox.setMargin(level1Button, new Insets(15, 0, 0, 0));
        levelVBox.setMargin(level2Button, new Insets(15, 0, 0, 0));
        levelVBox.setMargin(level3Button, new Insets(15, 0, 0, 0));
        levelVBox.setMargin(level4Button, new Insets(15, 0, 0, 0));
        levelVBox.setMargin(level5Button, new Insets(15, 0, 0, 0));

        levelBorderPane.setCenter(levelVBox);
        Scene levelsScene = new Scene(levelBorderPane);//We created level scene.

        ///We created the content of the Main Menu.
        VBox buttonsVBox = new VBox();
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> stage.setScene(levelsScene));///When the button is clicked, it opens the level stage.
        playButton.setPrefSize(80, 40);
        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(80, 40);

        exitButton.setOnAction(e->System.exit(0));

        buttonsVBox.getChildren().addAll(playButton, exitButton);
        buttonsVBox.setPadding(new Insets(175, 0, 0, 200));
        buttonsVBox.setMargin(exitButton, new Insets(15, 0, 0, 0));

        BorderPane mainMenuBorderPane = new BorderPane();
        mainMenuBorderPane.setStyle("-fx-background-color: DARKSLATEGREY");
        mainMenuBorderPane.setCenter(buttonsVBox);

        Scene mainMenuScene = new Scene(mainMenuBorderPane);
        stage.setTitle("Game BOX");
        stage.setHeight(513);
        stage.setWidth(485);
        stage.setResizable(false);
        stage.setScene(mainMenuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
