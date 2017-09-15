import java.util.LinkedList;

public class Board
{
  public LinkedList<Domino> Board = new LinkedList<>();
  public static int dominosInBoard = 0;
  // initialize to 7 to see if it's the first attempt.
  public static int rightTile =7;
  public static int leftTile= 7;


  // set domino a to if not a valid domino return false.
  public boolean setBoard(Domino dominoFrmPlayers, int side)
  {

    //Assign the first domino tiles in each corner

    if (rightTile==7 && leftTile==7)
    {
      rightTile = dominoFrmPlayers.getSide2();
      leftTile = dominoFrmPlayers.getSide1();
    }
    //Assign dominos on left to update the corner values.

    else if (side == 0){
      if(leftTile==dominoFrmPlayers.getSide1() ||dominoFrmPlayers.getSide1()==0||leftTile==0)
      {
        leftTile= dominoFrmPlayers.getSide2();

      }
      else if (leftTile==dominoFrmPlayers.getSide2()||dominoFrmPlayers.getSide2()==0||leftTile==0)
      {
        leftTile= dominoFrmPlayers.getSide1();

      }
      else
      {
        System.out.println("Invalid Domino");
        return false;
      }
      //Assign dominos on right to update the corner values.
    }
    else if (side == 1)
    {
      if(rightTile==dominoFrmPlayers.getSide1()||dominoFrmPlayers.getSide1()==0||rightTile==0)
      {
        rightTile= dominoFrmPlayers.getSide2();
        Board.addLast(dominoFrmPlayers);
        dominosInBoard++; return true;
      }
      else if (rightTile==dominoFrmPlayers.getSide2()||dominoFrmPlayers.getSide2()==0||rightTile==0)
      {
        rightTile= dominoFrmPlayers.getSide1();
        Board.addLast(dominoFrmPlayers);
        dominosInBoard++; return true;
      } else{
        System.out.println("Invalid Domino");
        return false;
      }
    }
    Board.addFirst(dominoFrmPlayers);
    dominosInBoard++;
    return true;

  }
}

