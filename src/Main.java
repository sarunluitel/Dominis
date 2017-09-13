import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application
{

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    GameController g = new GameController();
    Label lblWelcome = new Label("Welcome to the game of Dominos");

    Button btnStartGame = new Button("Start Game");
    VBox welcomeScreen = new VBox(30);
    welcomeScreen.setAlignment(Pos.CENTER);
    welcomeScreen.getChildren().addAll(lblWelcome,btnStartGame);





    Scene scene =new Scene(welcomeScreen,300,300);

    btnStartGame.setOnAction(event ->g.initialize());

    primaryStage.setScene(scene);
    primaryStage.show();

  }

}