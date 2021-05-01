import java.util.*;

public class Comparartor_1 {

    public static void main(String[] args) throws IOException {
        
        TreeSet ts=new TreeSet(new MyComparator());
        ts.add(55);
        ts.add(99);
        ts.add(5524);
        ts.add(1224);
        ts.add(100000);
        System.out.println("Default Natural Sorting Order: "+ts);//Default Natural Sorting Order: [55, 99, 1224, 5524, 100000]
        System.out.println("After applying Comparartor we want descending:"
                + ts);//After applying Comparartor we want descending:[100000, 5524, 1224, 99, 55]
    }
}

class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
        Integer i1=(int)obj1;
        Integer i2=(int)obj2;
        if(i1<i2){
            return 1;
        }
        else if(i1>i2){
            return -1;
        }
        else{
            return 0;
        }
    }
}
