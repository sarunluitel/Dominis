import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DisplayController extends Application
{
  public static int leftDomino = 2;
  public static int rightDomino=3;
  public static int computerHandNum=1;

  GameController g = new GameController();


  public void renderDisplay(String[] args){
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {


    Label lblWelcome = new Label("Welcome to the game of Dominos");

    Button btnStartGame = new Button("Start Game");
    VBox welcomeScreen = new VBox(50);

    welcomeScreen.setAlignment(Pos.CENTER);
    welcomeScreen.getChildren().addAll(lblWelcome,btnStartGame);

    Scene WelcomeScene =new Scene(welcomeScreen,300,300,Color.BLACK);
    WelcomeScene.getStylesheets().add("myDesign.css");



    btnStartGame.setOnAction(event ->{
      g.initialize();
      primaryStage.close();
    });

    primaryStage.setScene(WelcomeScene);
    primaryStage.show();

  }

  public void createGameScene(){





  }
  public  void initializeBoard(Integer[] P)
  {
    Stage gameStage = new Stage();
    HBox playerDominos = new HBox(5);
    HBox boardDominos = new HBox(5);
    HBox computerDominos = new HBox(5);
    GridPane boneYardDominos = new GridPane();
    BorderPane gameLayout = new BorderPane();


    for (int i = 0; i < 7; i++)
    {
      computerDominos.getChildren().add(
          RenderRectangles.renderLbl(0,0));
      boneYardDominos.getChildren().add(
          RenderRectangles.renderLbl(0,0));
      boneYardDominos.getChildren().add(
          RenderRectangles.renderLbl(0,0));
    }

    for (Integer a :P)
    {
      playerDominos.getChildren().add(
          RenderRectangles.renderLbl(a/10,a%10));

    }



    computerDominos.setAlignment(Pos.TOP_RIGHT);
    playerDominos.setAlignment(Pos.BOTTOM_LEFT);
    boardDominos.setAlignment(Pos.CENTER);
    gameLayout.setBottom(playerDominos);
    gameLayout.setTop(computerDominos);
    gameLayout.setCenter(boardDominos);
    gameLayout.setRight(boneYardDominos);



    Scene gameScene = new Scene(gameLayout, 1600,1000,Color.BLACK);
    gameScene.getStylesheets().add("myDesign.css");



    gameStage.setScene(gameScene);
    gameStage.show();


  }

}
