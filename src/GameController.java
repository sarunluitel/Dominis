import java.util.Arrays;
import java.util.Collections;

public class GameController {

  Board board =new Board();

  public void initialize(){

    //make an array of numbers 11 shuffle that list and use it as keys to assign to board, boneyard and hands
    Integer[] shuffle= {0,1,2,3,4,5,6,11,21,22,31,32,33,41,42,43,44,51,52,53,54,55,61,62,63,64,65,66};
    Collections.shuffle(Arrays.asList(shuffle)); // shuffled array to assign dominos.

    // get shuffled dominos for each pile.

    Integer[] playerArray=Arrays.copyOfRange(shuffle, 0, 7);
    Integer[] computerArray=Arrays.copyOfRange(shuffle,7,14);
    Integer[] boneArray=Arrays.copyOfRange(shuffle,14,28);

    Player player= new Player(playerArray);
    Computer computer= new Computer(computerArray);
    BoneYard boneYard= new BoneYard(boneArray);

    play(player,computer,boneYard);

  }


  public void play(Player player,Computer computer, BoneYard boneYard){

    // ask domino from player**********************************
    System.out.println(player.showHand());

    // get player domino to board.****************************
    Domino a=player.getDomino();

    // true if domino a is successfully put in the board
    while(!board.setBoard(a,player.getDominoSide())) {

      if(player.checkDominos(board.getLeftTile(),board.getRightTile()))
        player.addToHand(boneYard.getBones());//wromg place
      System.out.println(player.showHand());
      System.out.println("invalid domino. try again");
      a = player.getDomino();
      if(player.isHandEmpty()){
        System.out.println("!!!Player wins!!!");
        System.exit(1);
      }
    }

    System.out.println("player played domino   "+a.DominoID());
    board.showBoard();

    // Ask domino from the computer.**************************
    a =computer.getDominos(board.getLeftTile(),board.getRightTile());
    while(a==null){
      computer.addToHand(boneYard.getBones());
      a =computer.getDominos(board.getLeftTile(),board.getRightTile());
      if(computer.isHandEmpty()){
        System.out.println("!!!Computer wins!!!");
        System.exit(1);
      }
    }
    System.out.println("Computer played domino   "+a.DominoID());
    board.setBoard(a,computer.sideToPut());
    board.showBoard();

    play(player,computer,boneYard);


  }


}
