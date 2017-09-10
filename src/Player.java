
import java.util.HashMap;
import java.util.Scanner;

public class Player {

    protected HashMap<Integer,Domino> playerHand = new HashMap<>();

    public Player(Integer[] playerArray){
        for (Integer i : playerArray) {
            this.playerHand.put(i,new Domino(i/ 10, i% 10));
        }

    }

    public Domino getDomino(){
        Scanner in =new Scanner(System.in);
        Integer key = in.nextInt();

        Domino a=null;

        if (playerHand.containsKey(key)){
            a= playerHand.get(key);
        }
        else{
            System.out.println("Draw domino from yur pile.");
            return getDomino();
        }

        if (playerHand.containsKey(key)) playerHand.remove(key);
        //System.out.println("outpot from player returning domino"+ a.DominoID());
        return a;

    }
}

