public class Comparartor_3_Shortcuts_ {

    public static void main(String[] args) throws IOException {
        
        TreeSet ts=new TreeSet(new MyComparator());
        ts.add(55);
        ts.add(99);
        ts.add(5524);
        ts.add(1224);
        ts.add(100000);
        System.out.println("Default Natural Sorting Order: "+ts);//Default Natural Sorting Order: [55, 99, 1224, 5524, 100000]
        System.out.println("After applying Comparartor we want descending based on"
                + "second last digit:"
                + ts);//After applying Comparartor we want descending based onsecond last digit:[100000, 5524, 1224, 99, 55]
    }
}

class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
        Integer i1=(int)obj1;
        Integer i2=(int)obj2;
        //return -i1.compareTo(i2); //[100000, 5524, 1224, 99, 55]
        //or
       // return i2.compareTo(i1);//return -i1.compareTo(i2); //[100000, 5524, 1224, 99, 55]
        //return +1;//[55, 99, 5524, 1224, 100000] same as insertion order
       // return -1;//[100000, 1224, 5524, 99, 55] reverse as insertion order
        return 0;//[55] only 1st element inserted and others elements declared as duplicates

    }
}
