import java.util.LinkedList;

public class BoneYard {

  private LinkedList<Domino> boneList = new LinkedList<>();
  public static int boneNumRemains=14;


  public BoneYard(Integer[] boneArray){
    for (int i : boneArray) {
      this.boneList.add(new Domino(i/ 10, i% 10));
    }
  }

  public Domino getBones(){
    Domino a = boneList.getFirst();
    boneList.removeFirst();
    boneNumRemains--;
    return a;
  }

}
