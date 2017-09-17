package Dominos; /************************************
 @author Sarun Luitel

 Class DispayController calls in methods and
 provies code to setup GUI interface.

 ************************************/
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayController extends Application
{

  GameController g = new GameController();
  public static Stage gameStage;


  public void renderDisplay(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {


    Text txtWelcome = new Text("Welcome to the game of Dominos \n" +
        "Use left click to put dominos to the left of the Board \n " +
        "and Right Click to put dominos to the left od Board");

    Button btnStartGame = new Button("Start Game");
    VBox welcomeScreen = new VBox(50);

    welcomeScreen.setAlignment(Pos.CENTER);
    welcomeScreen.getChildren().addAll(txtWelcome, btnStartGame);

    Scene WelcomeScene = new Scene(welcomeScreen, 500, 500, Color.BLACK);
    WelcomeScene.getStylesheets().add("Dominos/myDesign.css");

    //Click event Listner Lambda Function
    btnStartGame.setOnAction(event ->
    {
      g.initialize();
      primaryStage.close();
    });

    primaryStage.setScene(WelcomeScene);
    primaryStage.show();

  }

  /************************************
   * Call to initialize GUI and redraw
   * after event handling
   ************************************/
  void initializeBoard()
  {

    {
      if(GameController.Winner!=null)
      {
        gameStage.close();
        showWinner();
        return;
      }
      if(Board.leftTile!=7)gameStage.close();
      gameStage= new Stage();

      ScrollPane sc = new ScrollPane();
      HBox playerDominos = new HBox(10);
      HBox boardDominos = new HBox(30);
      HBox computerDominos = new HBox(10);
      HBox boneYardDominos = new HBox(5);
      BorderPane gameLayout = new BorderPane();


      for (int i = 0; i < Computer.dominosWithComp; i++)
      {
        computerDominos.getChildren().add(
            RenderRectangles.renderLbl(0, 0));
      }

      boneYardDominos.getChildren().addAll(
          RenderRectangles.renderLbl(0, 0),
          new Text(BoneYard.boneNumRemains+"  Dominos remain"));


      for (Integer a : Player.playerHand.keySet())
      {
        playerDominos.getChildren().add(
            RenderRectangles.renderLbl(a / 10, a % 10));
      }
      System.out.println("outside board set loop");
      for (Domino a : Board.Board)
      {

        System.out.println("inside");
        Label local;
        local =RenderRectangles.renderLbl(a.getSide1(), a.getSide2());
        local.setRotate(-90);

        local.setMinWidth(50);
        System.out.println("putting dominos in board  "+a.DominoID());
        boardDominos.getChildren().addAll(local);
       // boardDominos.setSpacing();
      }
      sc.setContent(boardDominos);


      computerDominos.setAlignment(Pos.TOP_RIGHT);
      playerDominos.setAlignment(Pos.BOTTOM_LEFT);
      boardDominos.setAlignment(Pos.CENTER);
      boneYardDominos.setAlignment(Pos.BOTTOM_RIGHT);
      gameLayout.setBottom(playerDominos);
      gameLayout.setTop(computerDominos);
      gameLayout.setCenter(sc);
      gameLayout.setRight(boneYardDominos);


      Scene gameScene = new Scene(gameLayout, 1600, 1000, Color.BLACK);
      gameScene.getStylesheets().add("Dominos/myDesign.css");

      gameStage.setScene(gameScene);
      gameStage.show();


    }
  }
  void showWinner(){
    Stage gameStage=new Stage();
    VBox winnerBox = new VBox(30);
    winnerBox.getChildren().addAll(new Text("The Winner is  :"+
        GameController.Winner));
    Scene gameScene = new Scene(winnerBox, 300, 300, Color.BLACK);

    gameStage.setScene(gameScene);
    gameStage.show();


  }
}




