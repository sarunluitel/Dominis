import java.util.HashMap;

public class Computer {

    private HashMap<Integer, Domino> computerHand = new HashMap<>();
    private Integer[] cHandArray;

    public Computer(Integer[] computerDominos) {
        cHandArray=computerDominos;
        for (int i : computerDominos) {
            this.computerHand.put(i,new Domino(i/ 10, i% 10));
        }
    }

    public void lookboard(){


    }
    public Domino getdominos(){
        return computerHand.get(cHandArray[0]);
    }

}
