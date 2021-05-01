import java.util.*;

public class Comparator_6_String_StringBuffer_ {

    public static void main(String[] args) throws IOException {
        // 
        TreeSet ts=new TreeSet(new MyComparator());
        ts.add(new StringBuffer("Bhushan"));
        ts.add("Rashid");
        ts.add(new StringBuffer("Aakash"));
        ts.add("Dhoni");
        ts.add(new StringBuffer("Taher"));
        ts.add(new StringBuffer("Hemant"));
        ts.add("Ava");
        ts.add(new StringBuffer("Jaiki"));
        //System.out.println("Natural Sorting:"+ts);//[Aakash, Bhushan, Hemant, Jaiki, Taher]
        System.out.println("After Comparator: "+ts);//After Comparator: [Taher, Rashid, Jaiki, Hemant, Dhoni, Bhushan, Ava, Aakash]
        
    }
}

class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
       String s1=obj1.toString();
       String s2=obj2.toString();
       return -s1.compareTo(s2);
    }
}
