import java.util.Arrays;
import java.util.Collections;

public class GameController {

    public void play(){
        initialize();
        createObjects();


    }// make an array of numbers 11 shuffle that list and use it as keys to assign to board, boneyard and hands


    public void initialize(){

        //make an array of numbers 11 shuffle that list and use it as keys to assign to board, boneyard and hands
        Integer[] shuffle= {0,1,2,3,4,5,6,11,21,22,31,32,33,41,42,43,44,51,52,53,54,55,61,62,63,64,65,66};
        Collections.shuffle(Arrays.asList(shuffle)); // shuffled array to assign dominos.

        // get shuffled dominos for each pile.

        Integer[] playerArray=Arrays.copyOfRange(shuffle, 0, 7);
        Integer[] computerArray=Arrays.copyOfRange(shuffle,7,14);
        Integer[] boneArray=Arrays.copyOfRange(shuffle,14,28);

        System.out.println("Bone array");
    }


    public void createObjects(){

    }


}
