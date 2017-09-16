package Dominos;
/************************************
 @author Sarun Luitel

 Game controller provides codes to show
 Initialize Dominos and control Player turns.

 ************************************/
import java.util.Arrays;
import java.util.Collections;

public class GameController
{

   static Board board = new Board();
   static int playerEntry = -1;

   static boolean hasPlayerPlayed;

   static Player player;
   static Computer computer;
   static BoneYard boneYard;
   static String Winner=null;

   void initialize()
  {

    //make an array of numbers and shuffle that list and use it as keys
    // to assign to board, boneyard and hands
    Integer[] shuffle = {0, 1, 2, 3, 4, 5, 6, 11, 21, 22, 31, 32, 33, 41, 42, 43, 44, 51, 52, 53,
        54, 55, 61, 62, 63, 64, 65, 66};
    Collections.shuffle(Arrays.asList(shuffle)); // shuffled array to assign dominos.

    // get shuffled dominos for each pile.

    Integer[] playerArray = Arrays.copyOfRange(shuffle, 0, 7);
    Integer[] computerArray = Arrays.copyOfRange(shuffle, 7, 14);
    Integer[] boneArray = Arrays.copyOfRange(shuffle, 14, 28);

    player = new Player(playerArray);
    computer = new Computer(computerArray);
    boneYard = new BoneYard(boneArray);


    DisplayController GUI = new DisplayController();
    GUI.initializeBoard();

    playPlayerTurn();


  }


   static void playPlayerTurn()
  {

    // call Display controller methods to show GUI.

    DisplayController GUI = new DisplayController();
    Domino a;

    if (playerEntry == -1)
    {
      hasPlayerPlayed = false;

    }
    try
    {
      while (hasPlayerPlayed)
      {
        // get player domino to board.****************************
        a = player.getDomino(playerEntry);// domino will be drawn from player pile

        //gets inside the while loop if domino a cannot be put to side given.

        while (!board.setBoard(a, Player.side))
        {
          // see if player has any domino that can go to board

          if (!player.checkDominos(Board.leftTile, Board.rightTile))
          {
            if (Player.playerHand.isEmpty())
            {
              GameController.Winner="!!!!Player!!!!";
            }
            else{
              player.addToHand(boneYard.getBones());

            }
            playerEntry = -1;
            GUI.initializeBoard();
            hasPlayerPlayed = false;
            return;
          }
          return;

        }
        // Ask domino from the computer.**************************
        a = computer.getDominos(Board.leftTile, Board.rightTile);
        while (a == null)
        {
          //ask Domino from boneyard if cannot find matching on the board
          computer.addToHand(boneYard.getBones());
          a = computer.getDominos(Board.leftTile, Board.rightTile);
          if (computer.isHandEmpty())
          {
            GameController.Winner="!!!!Computer!!!!";
          }
        }
        System.out.println("Computer played domino   " + a.DominoID());
        board.setBoard(a, computer.sideToPut());


        playerEntry = -1;
        GUI.initializeBoard();
        hasPlayerPlayed = false;

      }


    }catch(NullPointerException e) {
      e.printStackTrace();

    }


  }
}

