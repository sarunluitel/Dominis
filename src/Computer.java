import java.util.HashMap;

public class Computer {

    private HashMap<Integer, Domino> computerHand = new HashMap<>();

    public Computer(Integer[] computerDominos) {

        for (int i : computerDominos) {
            this.computerHand.put(i,new Domino(i/ 10, i% 10));
        }
    }
}
