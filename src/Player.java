
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
            System.out.println("Draw domino from your pile.");
            return getDomino();
        }

        if (playerHand.containsKey(key)) playerHand.remove(key);
        return a;

    } // take user input to pass domino to board.

    public int getDominoSide(){
        Scanner in= new Scanner(System.in);
        System.out.println("Choose a side to put on  1 for Left, 2 for Right");
        int a = in.nextInt();
        if (a==1||a==2) return a;
        return getDominoSide();

    }
}

