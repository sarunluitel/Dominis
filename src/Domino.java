public class Domino {

    private int DominoID;
    private int side1;
    private int side2;

    public Domino(int side1, int side2){
        this.side1=side1;
        this.side2=side2;
        this.DominoID=10*side1+side2;
    }

    public int getSides(){
        return this.side1*10 +this.side2;
    }

    public int DominoID(){
        return this.DominoID;
    }
}
