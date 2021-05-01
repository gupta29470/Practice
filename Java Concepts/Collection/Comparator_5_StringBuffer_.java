import java.util.*;

public class Comparator_5_StringBuffer_ {

    public static void main(String[] args) throws IOException {
        // 
        TreeSet ts=new TreeSet(new MyComparator());
        ts.add(new StringBuffer("Bhushan"));
        ts.add(new StringBuffer("Aakash"));
        ts.add(new StringBuffer("Taher"));
        ts.add(new StringBuffer("Hemant"));
        ts.add(new StringBuffer("Jaiki"));
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
