package Dominos;
/************************************
 @author Sarun Luitel

 Keeps track of the dominos in boneyard and gives random to
 one who has run out.
 ************************************/

import java.util.LinkedList;

public class BoneYard
{

  private LinkedList<Domino> boneList = new LinkedList<>();
  static int boneNumRemains=14;


  BoneYard(Integer[] boneArray)
  {
    for (int i : boneArray)
    {
      this.boneList.add(new Domino(i/ 10, i% 10));
    }
  }
  /************************************
   @return  Domino to caller
   ************************************/
  Domino getBones()
  {
    Domino a = boneList.getFirst();
    boneList.removeFirst();
    boneNumRemains--;
    return a;
  }
}
