
import java.util.HashMap;
import java.util.Scanner;

public class Player {



  public static HashMap<Integer,Domino> playerHand = new HashMap<>();
  public static Integer[] playerArray;
  public static int side=-1;

  public Player(Integer[] playerArray){
    for (Integer i : playerArray) {
      this.playerArray=playerArray;

      this.playerHand.put(i,new Domino(i/ 10, i% 10));
    }

  }

  public Domino getDomino(int playerEntry){



    Domino a=null;
    if (playerHand.containsKey(playerEntry)){
      a= playerHand.get(playerEntry);
      playerHand.remove(playerEntry);
      return a;
    }
    else{
      //ask to select domino from their pile
      //GameController.playerEntry=-1;
      //GameController.hasPlayerPlayed=false;
      //GameController.playPlayerTurn();
      System.out.println("go get another domino from your pile");
      return null ;//getDomino(GameController.playerEntry);

    }




  } // take user input to pass domino to board.

  //returns true if player's hand has the domino on the end of the board
  public boolean checkDominos(int left, int right){
    for (int a : playerHand.keySet()) {
      if(a/10==left|| a%10==left){
        return true;
      }
      if(a/10==right|| a%10==right) {
        return true;
      }
    }
    return false;
  }


  public void addToHand(Domino d){
    System.out.println("got a new Domino  "+ d.DominoID());
    playerHand.put(d.DominoID(),d);
  }

}

