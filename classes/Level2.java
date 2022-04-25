package Sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;


public class Level2 extends Application {
    private int highScore1 = 0;
    private int highScore2 = 0;
    private int highScore3 = 0;
    private int highScore4 = 0;
    private int highScore5 = 0;


    private int score = 0;
    private Button[] levelButtons = new Button[24];
    private int x[] = new int[24];
    private int y[] = new int[24];
    private int hp[] = new int[24];
    private int totalScore = 0;

    Label infoText = new Label();
    Label scoreText = new Label("" + totalScore);
    Label highScoreText = new Label("High Score: " + highScore1);

    GridPane boxGridPane = new GridPane();
    HBox downHBox = new HBox();
    Label nextLevelButton = new Label("Next Level");

    Image img = new Image("/Sample/40xdemonite.png");
    Image img2 = new Image("/Sample/whitebox.png");


    public Level2(int highScore1, int highScore2, int highScore3, int highScore4, int highScore5) {
        this.highScore1 = highScore1;
        this.highScore2 = highScore2;
        this.highScore3 = highScore3;
        this.highScore4 = highScore4;
        this.highScore5 = highScore5;
    }

    private void handleButtonClick(ActionEvent event) {

        String boxText = "";//Hangi kutuya tıkladığımızı tutan text
        String hitText = "";//Hangi kutulara vurabildiğimizi tutan text;
        int count = 0;// Kaç tane kutuya vurduğumuzu tutan int.
        boolean control = true;//morken basınca beyaz olmaması için.
        for (int q = 0; q < levelButtons.length; q++) {
            control = true;
            if (event.getSource() == levelButtons[q]) {
                for (int c = 0; c < levelButtons.length; c++) {
                    if (q != c) {
                        if (x[q] == x[c] && (y[q] - y[c] == 1 || y[q] - y[c] == -1)) {
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
                        } else if (y[q] == y[c] && (x[q] - x[c] == 1 || x[q] - x[c] == -1)) {
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
                ///Aşağıda puanlama sistemi var.
                if (count == 1) {
                    totalScore -= 3;
                    score = -3;
                } else if (count == 2) {
                    totalScore -= 1;
                    score = -1;
                } else if (count == 3) {
                    totalScore += 1;
                    score = +1;
                }
                else if(count==4)
                {
                    totalScore +=2;
                    score =2;
                }
                else if(count==5)
                {
                    totalScore +=4;
                    score =4;
                }
                scoreText.setText(totalScore + "");
                boxText = "Box: " + x[q] + "-" + y[q];
                hitText = " Hit: " + hitText;
                infoText.setText(boxText + hitText + " (" + score + " points)");

                int i = 0;
                for (; i < levelButtons.length; i++) {
                    if (hp[i] != 0) {
                        break;
                    }
                }
                if (i == levelButtons.length) {
                    nextLevelButton.setVisible(true);
                    infoText.setText("End game");
                    downHBox.setMargin(nextLevelButton, new Insets(0, 0, 0, 355));

                    ///High Score
                    ///Eğer score highScoredan yüksekse highScore güncelleniyor.
                    if (totalScore > highScore2) {
                        highScore2 = totalScore;
                    }
                    highScoreText.setText("High Score:" + highScore2);

                }
            }
        }
    }

    Stage stage2 = new Stage();//high score verisini tutmak için
    public void NextLevel()
    {
        Level3 level3Scene = new Level3(highScore1, highScore2, highScore3, highScore4, highScore5);
        level3Scene.start(stage2);
    }
    public void start(Stage stage) {
        GridPane mainLevel1GridPane = new GridPane();

        HBox upHBox = new HBox();

        stage2 = stage;

        ///Üst taraf
        Label levelText = new Label("Level #2");

        // upGridPane.setMaxHeight(75);


        upHBox.setMaxWidth(485);
        upHBox.setMaxHeight(75);
        upHBox.setStyle("-fx-background-color: #00b2ff");


        highScoreText.setText("High Score:" + highScore2);
        infoText.setStyle("-fx-font: 11 arial;");
        nextLevelButton.setStyle("-fx-font: 11 arial;");
        highScoreText.setStyle("-fx-font: 11 arial;");
        scoreText.setStyle("-fx-font: 11 arial;");
        levelText.setStyle("-fx-font: 11 arial;");

        upHBox.getChildren().addAll(levelText, scoreText, highScoreText);
        upHBox.setPadding(new Insets(0, 5, 0, 0));
        upHBox.setMargin(levelText, new Insets(0, 0, 0, 7));
        upHBox.setMargin(scoreText, new Insets(0, 0, 0, 175));
        upHBox.setMargin(highScoreText, new Insets(0, 0, 0, 162));


        downHBox.setMaxWidth(485);
        downHBox.setMaxHeight(75);
        downHBox.setStyle("-fx-background-color: #269e32");

        downHBox.getChildren().addAll(infoText, nextLevelButton);

        downHBox.setPadding(new Insets(5, 0, 0, 5));
        nextLevelButton.setOnMouseClicked(e->NextLevel());
        nextLevelButton.setVisible(false);


        mainLevel1GridPane.add(upHBox, 0, 0);
        mainLevel1GridPane.add(boxGridPane, 0, 1);
        mainLevel1GridPane.add(downHBox, 0, 2);


        for (int i = 0; i < levelButtons.length; i++) {
            Button button = new Button();
            button.setPrefSize(40, 40);
            levelButtons[i] = button;
            levelButtons[i].setOnAction(this::handleButtonClick);
        }
        boxGridPane.setMaxWidth(485);
        boxGridPane.setMaxHeight(400);
        boxGridPane.setStyle("-fx-background-image: url('/Sample/whiteBackGround.png')");
        Rectangle notDestroyedBoxes[] = new Rectangle[76];
        for (int i = 0; i < notDestroyedBoxes.length; i++) {
            Rectangle rectangles = new Rectangle();
            rectangles.setHeight(40);
            rectangles.setWidth(40);
            notDestroyedBoxes[i] = rectangles;
        }
        int forBoxes = 0;
        int forButton = 0;
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                if((((row >= 1 && row <=4)||(row >= 6 && row <=7)) && column==4)   || (((row >= 2 && row <=3)||(row >= 5 && row <=8)) && column==5))
                {
                    x[forButton] = row;
                    y[forButton] = column;
                    hp[forButton] = 1;
                    boxGridPane.add(levelButtons[forButton], column, row);
                    levelButtons[forButton].setStyle("-fx-background-image: url('/Sample/40xwood.png')");
                    forButton++;
                }
                else if((row==1 || row==8) && (column==1 || column==8))
                {
                    boxGridPane.add(notDestroyedBoxes[forBoxes], column, row);
                    notDestroyedBoxes[forBoxes].setFill(new ImagePattern(img2));
                    boxGridPane.setMargin(notDestroyedBoxes[forBoxes], new Insets(0, 6, 3, 0));
                    forBoxes++;
                }
                else if((((column >= 1 && column <=3)||(column >= 5 && column <=7)) && row==4)  ||  (((column >= 2 && column <=4)||(column >= 6 && column <=8)) && row==5))
                {
                    x[forButton] = row;
                    y[forButton] = column;
                    hp[forButton] = 2;
                    boxGridPane.add(levelButtons[forButton], column, row);
                    levelButtons[forButton].setStyle("-fx-background-image: url('/Sample/40xiron.png')");
                    forButton++;
                }
                else{
                    boxGridPane.add(notDestroyedBoxes[forBoxes], column, row);
                    notDestroyedBoxes[forBoxes].setFill(new ImagePattern(img));
                    boxGridPane.setMargin(notDestroyedBoxes[forBoxes], new Insets(0, 6, 3, 0));
                    forBoxes++;
                }
            }
        }
        boxGridPane.setPadding(new Insets(6, 3, 4, 6));

        Scene level1Scene = new Scene(mainLevel1GridPane);
        stage.setTitle("Game BOX");
        stage.setHeight(513);
        stage.setWidth(485);
        stage.setScene(level1Scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}