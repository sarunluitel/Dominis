package Dominos;

/************************************
 @author Sarun Luitel

 Provides methods and attribues to keep track
 of dominos in the board and rules to play game.
 ************************************/
import java.util.LinkedList;

public class Board
{
  static LinkedList<Domino> Board = new LinkedList<>();
  static int dominosInBoard = 0;
  // initialize to 7 to see if it's the first attempt.
  static int rightTile =7;
  static int leftTile= 7;


  /*****************************************************
   @param dominoFrmPlayers gets Domino from player
   @param side shows what side to put on.

   @return  true if Domino was sucessfully placed on board

   ********************************************************/
  public boolean setBoard(Domino dominoFrmPlayers, int side)
  {

    //Assign the first domino tiles in each corner

    if (rightTile==7 && leftTile==7)
    {
      rightTile = dominoFrmPlayers.getSide2();
      leftTile = dominoFrmPlayers.getSide1();
      Board.addFirst(dominoFrmPlayers);
      dominosInBoard++;
      return true;
    }
    //Assign dominos on left to update the corner values.

    else if (side == 0)
    {
      if(leftTile==dominoFrmPlayers.getSide1() ||dominoFrmPlayers.getSide1()==0
          ||leftTile==0)
      {
        leftTile= dominoFrmPlayers.getSide2();
        Domino fliped = new Domino(dominoFrmPlayers.getSide2(),
            dominoFrmPlayers.getSide1());
        Board.addFirst(fliped);

      }
      else if (leftTile==dominoFrmPlayers.getSide2()||dominoFrmPlayers.getSide2()==0
          ||leftTile==0)
      {
        leftTile= dominoFrmPlayers.getSide1();
        Board.addFirst(dominoFrmPlayers);
        dominosInBoard++;
        return true;

      }
      else
      {
        System.out.println("Invalid Domino@set boardside 0");
        return false;
      }
      //Assign dominos on right to update the corner values.
    }
    else if (side == 1)
    {
      if(rightTile==dominoFrmPlayers.getSide1()||dominoFrmPlayers.getSide1()==0
          ||rightTile==0)
      {
        rightTile= dominoFrmPlayers.getSide2();
        Board.addLast(dominoFrmPlayers);
        dominosInBoard++; return true;
      }
      else if (rightTile==dominoFrmPlayers.getSide2()||dominoFrmPlayers.getSide2()==0||rightTile==0)
      {
        rightTile= dominoFrmPlayers.getSide1();
        Domino fliped = new Domino(dominoFrmPlayers.getSide2(),
            dominoFrmPlayers.getSide1());
        Board.addLast(fliped);
        dominosInBoard++; return true;
      } else{
        System.out.println("Invalid Domino @boardside 1");
        return false;
      }
    }
    return false;

  }
}

