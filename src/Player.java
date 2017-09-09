
import java.util.HashMap;

public class Player {

    protected HashMap<Integer,Domino> playerHand = new HashMap<>();

    public Player(Integer[] playerArray){
        for (Integer i : playerArray) {
            this.playerHand.put(i,new Domino(i/ 10, i% 10));
        }

    }
}

