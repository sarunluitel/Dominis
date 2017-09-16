package Dominos;
/************************************
 @author Sarun Luitel

 Provides Player properties and attributes
 ************************************/
import java.util.HashMap;

public class Player
{



  static HashMap<Integer,Domino> playerHand = new HashMap<>();
  private static Integer[] playerArray;
  static int side=-1;

  Player(Integer[] playerArray){
    for (Integer i : playerArray) {
      this.playerArray=playerArray;

      this.playerHand.put(i,new Domino(i/ 10, i% 10));
    }

  }

  Domino getDomino(int playerEntry)
  {
    Domino a= playerHand.get(playerEntry);
    playerHand.remove(playerEntry);
    return a;


  } // take user input to pass domino to board.

  /************************************
   @param left checks if Player's had has
   Dominos to play.

   ************************************/
  boolean checkDominos(int left, int right)
  {
    if(left==0 || right==0) return true;
    for (int a : playerHand.keySet())
    {

      if(a/10==left|| a%10==left) return true;

      if(a/10==right|| a%10==right) return true;
    }
    return false;
  }

  // put dominos from boneyard to hand.
  void addToHand(Domino d)
  {
    playerHand.put(d.DominoID(),d);
  }

}

