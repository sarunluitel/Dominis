import com.sun.media.jfxmedia.events.PlayerEvent;

import java.util.Arrays;
import java.util.Collections;

public class GameController {
    public final int RIGHT=2;
    public final int LEFT=1;

    Board board =new Board();

    public GameController(){
        initialize();
    }


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

        // ask domino from player
        System.out.println("these are your Dominos Play one"+player.playerHand.keySet());
        // get player domino to board.
        board.setBoard(player.getDomino(),RIGHT);
        //41showBoad();

        // Ask domino from the computer.
        board.setBoard(computer.getdominos(),LEFT);
        showBoad();

        play(player,computer,boneYard);


    }

    public void showBoad(){
        //show the board
        if (Board.dominosInBoard==1){
            System.out.println("BOARD   "+board.getboard()[0].DominoID());
        }
        else{
            System.out.println("BOARD    "+board.getboard()[0].DominoID()+"..."+board.getboard()[1].DominoID());
        }
    }
}
