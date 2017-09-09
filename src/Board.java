import java.util.HashMap;

public class Board
{
    public HashMap<Integer, Domino> Board = new HashMap<>();

    public Board(Integer[] boardArray){

        for (int i : boardArray) {
            this.Board.put(i,new Domino(i/ 10, i% 10));
        }

    }
}
