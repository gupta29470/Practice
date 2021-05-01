import java.util.*;

public class Comparator_8_Sorting_names_descending_according_to_name_length {

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
        System.out.println("Sorting descending  Names according to name length: "
        +ts);//Sorting descending  Names according to name length: [Bhushan, Aakash, Hemant, Rashid, Dhoni, Jaiki, Taher, Ava]
        
    }
}

class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
       String s1=obj1.toString();
       String s2=obj2.toString();
       int len1=s1.length();
       int len2=s2.length();
       if(len1<len2){
           return 1;
       }
       else if(len1>len2){
           return -1;
       }
       else{
           return s1.compareTo(s2);
       }
    }
}
