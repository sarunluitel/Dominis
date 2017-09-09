import java.util.HashMap;

public class BoneYard {

    public HashMap<Integer,Domino> boneMap = new HashMap<>();

    public BoneYard(Integer[] boneArray){
        for (int i : boneArray) {
            this.boneMap.put(i,new Domino(i/ 10, i% 10));
        }
        System.out.println("asdf"+this.boneMap.toString());

    }
}
