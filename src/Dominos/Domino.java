package Dominos;
/************************************
 @author Sarun Luitel

 Provides methods to define a Domino

 ************************************/
public class Domino
{

  private int DominoID;
  private int side1;
  private int side2;

   Domino(int side1, int side2)
  {
    this.side1=side1;
    this.side2=side2;
    this.DominoID=10*side1+side2;
  }

   int getSide1()
  {
    return this.side1;
  }


   int getSide2()
  {
    return this.side2;
  }

   int DominoID()
  {
    return this.DominoID;
  }
}

