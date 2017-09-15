import sun.java2d.pipe.AAShapePipe;

import java.util.HashMap;

public class Computer {

  private HashMap<Integer, Domino> computerHand = new HashMap<>();
  private Integer[] cHandArray;
  private int sideToPut;
  public static int dominosWithComp=7;


  public Computer(Integer[] computerDominos) {
    cHandArray=computerDominos;
    for (int i : computerDominos) {
      this.computerHand.put(i,new Domino(i/ 10, i% 10));
    }
  }

  public Domino getDominos(int side1, int side2){
    for (int a : computerHand.keySet()) {
      if(a/10==side1|| a%10==side1){
        sideToPut=1;
        Domino d= computerHand.get(a);
        computerHand.remove(a);
        dominosWithComp--;
        return d;
      }
      if(a/10==side2|| a%10==side2) {
        sideToPut=2;
        Domino d= computerHand.get(a);
        computerHand.remove(a);
        dominosWithComp--;
        return d;
      }
    }
    return null;
  }


  public int sideToPut(){
    return sideToPut;
  }

  public void addToHand(Domino d){
    System.out.println("got a new Domino  "+ d.DominoID());
    dominosWithComp++;
    computerHand.put(d.DominoID(),d);
  }

  public boolean isHandEmpty(){
    return computerHand.isEmpty();
  }
}
