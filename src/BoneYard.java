import java.util.LinkedList;

public class BoneYard {

    public LinkedList<Domino> boneList = new LinkedList<>();

    public BoneYard(Integer[] boneArray){
        for (int i : boneArray) {
            this.boneList.add(new Domino(i/ 10, i% 10));
        }
    }

    public Domino getBones(){
        Domino a = boneList.getFirst();
        boneList.removeFirst();
        return a;
    }
    public int boneNumRemain(){
        return boneList.size();
    }
}
