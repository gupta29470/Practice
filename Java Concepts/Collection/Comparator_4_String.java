import java.util.*;

public class Comparator_4_String {

    public static void main(String[] args) throws IOException {
        
        TreeSet ts=new TreeSet(new MyComparator());
        ts.add("Bhushan");
        ts.add("Aakash");
        ts.add("Taher");
        ts.add("Hemant");
        ts.add("Jaiki");
        //System.out.println("Natural Sorting:"+ts);//[Aakash, Bhushan, Hemant, Jaiki, Taher]
        System.out.println("After Comparator: "+ts);//After Comparator: [Taher, Jaiki, Hemant, Bhushan, Aakash]
        
    }
}

class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
       String s1=obj1.toString();
       String s2=obj2.toString();
       return -s1.compareTo(s2);
    }
}
