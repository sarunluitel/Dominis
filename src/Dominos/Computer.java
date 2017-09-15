package Dominos;
/************************************
 @author Sarun Luitel

 Provides rules for computer to play
 ************************************/

import java.util.HashMap;

public class Computer
{

  private HashMap<Integer, Domino> computerHand = new HashMap<>();
  private Integer[] cHandArray;
  private int sideToPut;
  static int dominosWithComp=7;


  Computer(Integer[] computerDominos)
  {
    cHandArray=computerDominos;
    for (int i : computerDominos)
    {
      this.computerHand.put(i,new Domino(i/ 10, i% 10));
    }
  }
  // check if Domino is compatible on board.
  Domino getDominos(int side1, int side2)
  {
    for (int a : computerHand.keySet())
    {
      if(a/10==side1|| a%10==side1)
      {
        sideToPut=1;
        Domino d= computerHand.get(a);
        computerHand.remove(a);
        dominosWithComp--;
        return d;
      }
      if(a/10==side2|| a%10==side2)
      {
        sideToPut=2;
        Domino d= computerHand.get(a);
        computerHand.remove(a);
        dominosWithComp--;
        return d;
      }
    }
    return null;
  }


  int sideToPut()
  {
    return sideToPut;
  }

  void addToHand(Domino d)
  {
    System.out.println("got a new Domino  "+ d.DominoID());
    dominosWithComp++;
    computerHand.put(d.DominoID(),d);
  }

  boolean isHandEmpty()
  {
    return computerHand.isEmpty();
  }
}
