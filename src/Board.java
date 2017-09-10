import java.util.LinkedList;

public class Board
{
    public LinkedList<Domino> Board = new LinkedList<>();
    public static int dominosInBoard=0;

    public void setBoard(Domino dominoFrmPlayers,int side) {
        if (side<=1) {
            Board.addFirst(dominoFrmPlayers);
            dominosInBoard++; return;
        }
        Board.addLast(dominoFrmPlayers);
        dominosInBoard++;
    }

    public Domino[] getboard(){
        Domino[] a ={Board.getFirst(),Board.getLast()}; //return only first and last from the board
        return a;
    }
}

