import java.util.*;
import java.sql.*;//Step 1

public class Garbage_Collection {

    public static void main(String[] args) throws Exception {
        vita v1=new vita();
        vita v2=new vita();
        
        v1=null;//// Nullifying the reference variable 
        System.gc();// requesting JVM for running Garbage Collector 

        v2=null;//// Nullifying the reference variable 
        System.gc();// requesting JVM for running Garbage Collector 

    }
   protected void finalize() throws Throwable{
        System.out.println("Garbage collector called");
        System.out.println("Object garbage called: "+this);
    }
}
