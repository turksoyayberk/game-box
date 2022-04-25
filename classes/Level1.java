package Sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Level1 extends Application {

    ///We created integer variables to move highScore variables from scene to scene.
    private int highScore1 = 0;
    private int highScore2 = 0;
    private int highScore3 = 0;
    private int highScore4 = 0;
    private int highScore5 = 0;
    ///

    private int score = 0;///This variable holds the score.
    private Button[] levelButtons = new Button[6];///We created buttons for clickable boxes.
    private int x[] = new int[6];///We created the integer array that holds the x coordinate of the box.
    private int y[] = new int[6];///We created the integer array that holds the y coordinate of the box.
    private int hp[] = new int[6];///We have created an integer array that holds the health point of the box.
    private int totalScore = 0;///This variable holds the total score.

    ///We created a label variable indicating which box was pressed,
    // which box was hit and how many points were received.
    Label infoText = new Label();
    ///
    Label scoreText = new Label("" + totalScore);///We created label variable for the score.
    Label highScoreText = new Label("High Score: " + highScore1);///We created label variable for the high score.

    GridPane boxGridPane = new GridPane();///We created this GridPane for boxes.
    HBox downHBox = new HBox();///We created this HBox for level, score and high score text.
    Label nextLevelButton = new Label("Next Level");//We created a button that allows to go to the next level.

    ///For pictures of the boxes.
    Image img = new Image("/Sample/40xdemonite.png");
    Image img2 = new Image("/Sample/whitebox.png");
    ///

    ///We created a constructor method to set high scores.
    public Level1(int highScore1, int highScore2, int highScore3, int highScore4, int highScore5) {
        this.highScore1 = highScore1;
        this.highScore2 = highScore2;
        this.highScore3 = highScore3;
        this.highScore4 = highScore4;
        this.highScore5 = highScore5;
    }

    ///
    private void handleButtonClick(ActionEvent event) {

        String boxText = "";//We created a string variable that holds which box is clicked.
        String hitText = "";//We created a string variable that holds which box we hit.
        int count = 0;//Integer variable indicating how many boxes we hit.
        boolean control = true;//We created a boolean variable so that the box is not empty when pressed while it is wood.

        for (int q = 0; q < levelButtons.length; q++)//
        {
            control = true;
            if (event.getSource() == levelButtons[q])//We created a condition that allows us to understand which box we clicked on.
            {
                for (int c = 0; c < levelButtons.length; c++) {
                    if (q != c)///This condition was created to not look at the box we clicked while looking at all the boxes at the top for loop.
                    {
                        ///This condition works if the difference between the y coordinates of the box
                        // we clicked and another box on the same x coordinate is 1 or -1.
                        if (x[q] == x[c] && (y[q] - y[c] == 1 || y[q] - y[c] == -1)) {
                            hitText += x[c] + "," + y[c] + " - ";

                            if (hp[c] == 2) //This condition works if the health of the box we hit is 2.
                            {
                                count++;
                                hp[c] -= 1;
                                levelButtons[c].setStyle("-fx-background-image: url('/Sample/40xwood.png')");
                            } else if (hp[c] == 1) //This condition works if the health of the box we hit is 1.
                            {
                                count++;
                                Rectangle rectangle = new Rectangle();
                                rectangle.setHeight(40);
                                rectangle.setWidth(40);
                                rectangle.setFill(new ImagePattern(img2));
                                boxGridPane.add(rectangle, y[c], x[c]);
                                hp[c] -= 1;
                            }
                            if (hp[q] == 2) //This condition works if the health of the box we clicked is 2.
                            {
                                count++;
                                control = false;
                                hp[q] -= 1;
                                levelButtons[q].setStyle("-fx-background-image: url('/Sample/40xwood.png')");
                            }
                            if (control) {
                                if (hp[q] == 1) //This condition works if the health of the box we clicked is 1.
                                {
                                    count++;
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setHeight(40);
                                    rectangle.setWidth(40);
                                    rectangle.setFill(new ImagePattern(img2));
                                    boxGridPane.add(rectangle, y[q], x[q]);
                                    hp[q] -= 1;
                                }
                            }
                        }
                        ///This condition works if the difference between the x coordinates of the box
                        // we clicked and another box on the same y coordinate is 1 or -1.
                        else if (y[q] == y[c] && (x[q] - x[c] == 1 || x[q] - x[c] == -1)) {
                            hitText += x[c] + "," + y[c] + " - ";

                            if (hp[c] == 2) {
                                count++;
                                hp[c] -= 1;
                                levelButtons[c].setStyle("-fx-background-image: url('/Sample/40xwood.png')");

                            } else if (hp[c] == 1) {
                                count++;
                                Rectangle rectangle = new Rectangle();
                                rectangle.setHeight(40);
                                rectangle.setWidth(40);
                                rectangle.setFill(new ImagePattern(img2));
                                boxGridPane.add(rectangle, y[c], x[c]);
                                hp[c] -= 1;
                            }
                            if (hp[q] == 2) {
                                count++;
                                control = false;
                                hp[q] -= 1;
                                levelButtons[q].setStyle("-fx-background-image: url('/Sample/40xwood.png')");
                            }
                            if (control) {
                                if (hp[q] == 1) {
                                    count++;
                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setHeight(40);
                                    rectangle.setWidth(40);
                                    rectangle.setFill(new ImagePattern(img2));
                                    boxGridPane.add(rectangle, y[q], x[q]);
                                    hp[q] -= 1;
                                }
                            }
                        }
                    }
                }
                ///Scoring system that gives points according to the number of boxes hit.
                if (count == 1) {
                    totalScore -= 3;
                    score = -3;
                } else if (count == 2) {
                    totalScore -= 1;
                    score = -1;
                } else if (count == 3) {
                    totalScore += 1;
                    score = +1;
                } else if (count == 4) {
                    totalScore += 2;
                    score = 2;
                } else if (count == 5) {
                    totalScore += 4;
                    score = 4;
                }
                ///
                scoreText.setText(totalScore + "");//This code sets the score change.
                boxText = "Box: " + x[q] + "-" + y[q];
                hitText = " Hit: " + hitText;
                infoText.setText(boxText + hitText + " (" + score + " points)");


                int i = 0;
                for (; i < levelButtons.length; i++) {
                    if (hp[i] != 0)  ///Checks the health values of all boxes.
                    {
                        break;//It terminates the for loop if the boxes don't have a health point of zero.
                    }
                }
                if (i == levelButtons.length) //This condition works if the health of all boxes is 0.
                {
                    nextLevelButton.setVisible(true);///Makes the Next level button visible.
                    infoText.setText("End game");
                    ///It puts the Next level button 355 pixels to the right of the info text.
                    downHBox.setMargin(nextLevelButton, new Insets(0, 0, 0, 355));//
                    ///

                    ///If the score is higher than highScore, the highScore will set.
                    if (totalScore > highScore1) {
                        highScore1 = totalScore;
                    }
                    highScoreText.setText("High Score:" + highScore1);

                }
            }
        }
    }

    public void NextLevel() {
        Level2 level2Scene = new Level2(highScore1, highScore2, highScore3, highScore4, highScore5);
        level2Scene.start(stage1);
    }

    Stage stage1 = new Stage();//When we go to the next level, we created the scene so that it stays in the same window.

    public void start(Stage stage) {
        stage1 = stage;
        GridPane mainLevel1GridPane = new GridPane();//We created a Gridpane that shows all objects on the screen.

        ///Upper Pane
        HBox upHBox = new HBox();//We created a Hbox for the upper pane.
        Label levelText = new Label("Level #1");

        //Here we set the height, width and background color of the upper pane.
        upHBox.setMaxWidth(485);
        upHBox.setMaxHeight(75);
        upHBox.setStyle("-fx-background-color: #00b2ff");
        ////

        highScoreText.setText("High Score:" + highScore1);
        infoText.setStyle("-fx-font: 11 arial;");
        nextLevelButton.setStyle("-fx-font: 11 arial;");
        highScoreText.setStyle("-fx-font: 11 arial;");
        scoreText.setStyle("-fx-font: 11 arial;");
        levelText.setStyle("-fx-font: 11 arial;");

        //Here we add levelText, scoreText and highScoreText to the upper pane.
        upHBox.getChildren().addAll(levelText, scoreText, highScoreText);
        //
        //We determined the lower gaps of the objects in the upper panel.
        upHBox.setPadding(new Insets(0, 5, 0, 0));
        //
        //Here we determined the spaces between objects.
        upHBox.setMargin(levelText, new Insets(0, 0, 0, 7));
        upHBox.setMargin(scoreText, new Insets(0, 0, 0, 175));
        upHBox.setMargin(highScoreText, new Insets(0, 0, 0, 162));
        //

        ///Lower Pane
        //Here we set the height, width and background color of the lower pane.
        downHBox.setMaxWidth(485);
        downHBox.setMaxHeight(75);
        downHBox.setStyle("-fx-background-color: #269e32");
        //
        //Here we add infoText and nextLevelButton to the lower pane.
        downHBox.getChildren().addAll(infoText, nextLevelButton);
        ///We determined the upper and left gaps of the objects in the upper panel.
        downHBox.setPadding(new Insets(5, 0, 0, 5));
        nextLevelButton.setOnMouseClicked(e -> NextLevel());//We gave click event to next level button.
        nextLevelButton.setVisible(false);//Here we turned off the visibility of the nextLevelButton.

        ///Here we added upper pane, middle pane and lower panes to the mainGridPane.
        mainLevel1GridPane.add(upHBox, 0, 0);
        mainLevel1GridPane.add(boxGridPane, 0, 1);
        mainLevel1GridPane.add(downHBox, 0, 2);
        ///

        for (int i = 0; i < levelButtons.length; i++)//Here we create buttons for boxes that are clickable.
        {
            Button button = new Button();
            button.setPrefSize(40, 40);
            levelButtons[i] = button;//We add the buttons we have created to the Level button array.
            levelButtons[i].setOnAction(this::handleButtonClick);//We gave click event to buttons.
        }
        //Here we set the height, width and background image of the middle pane.
        boxGridPane.setMaxWidth(485);
        boxGridPane.setMaxHeight(400);
        boxGridPane.setStyle("-fx-background-image: url('/Sample/whiteBackGround.png')");
        //
        Rectangle notDestroyedBoxes[] = new Rectangle[94];//Here we created a rectangle array for boxes that cannot be destroyed.
        for (int i = 0; i < notDestroyedBoxes.length; i++) {
            Rectangle rectangles = new Rectangle();//Here we created indestructible boxes.
            rectangles.setHeight(40);
            rectangles.setWidth(40);
            notDestroyedBoxes[i] = rectangles;//We add the rectangles we have created to the rectangle array.
        }
        ///

        int forBoxes = 0;
        int forButton = 0;
        //Here we determine the locations of the boxes according to the given conditions.
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if (((column == 7 || column == 8) && row == 1) || (row == 2 && column == 8)) {
                    x[forButton] = row;
                    y[forButton] = column;
                    hp[forButton] = 1;
                    boxGridPane.add(levelButtons[forButton], column, row);
                    levelButtons[forButton].setStyle("-fx-background-image: url('/Sample/40xwood.png')");
                    forButton++;
                } else if ((column == 4 || column == 5) && (row == 4 || row == 5)) {
                    boxGridPane.add(notDestroyedBoxes[forBoxes], column, row);
                    notDestroyedBoxes[forBoxes].setFill(new ImagePattern(img2));
                    boxGridPane.setMargin(notDestroyedBoxes[forBoxes], new Insets(0, 6, 3, 0));
                    forBoxes++;
                } else if ((column == 1 && row == 7) || ((column == 1 || column == 2) && row == 8)) {
                    x[forButton] = row;
                    y[forButton] = column;
                    hp[forButton] = 2;
                    boxGridPane.add(levelButtons[forButton], column, row);
                    levelButtons[forButton].setStyle("-fx-background-image: url('/Sample/40xiron.png')");
                    forButton++;
                } else {
                    boxGridPane.add(notDestroyedBoxes[forBoxes], column, row);
                    notDestroyedBoxes[forBoxes].setFill(new ImagePattern(img));
                    boxGridPane.setMargin(notDestroyedBoxes[forBoxes], new Insets(0, 6, 3, 0));
                    forBoxes++;
                }
            }
        }
        //
        boxGridPane.setPadding(new Insets(6, 3, 4, 6));//Here we determined the spaces between all the objects in the middle pane.

        Scene level1Scene = new Scene(mainLevel1GridPane);
        stage.setTitle("Game BOX");
        stage.setHeight(513);
        stage.setWidth(485);
        stage.setScene(level1Scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


