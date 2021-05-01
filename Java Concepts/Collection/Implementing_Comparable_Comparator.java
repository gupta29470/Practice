import java.util.*;

public class Implementing_Comparable_Comparator {

    public static void main(String[] args) throws IOException {
        Employee e1 = new Employee("Pathak", 14);
        Employee e2 = new Employee("Valmiki", 56);
        Employee e3 = new Employee("Pandey", 8);
        Employee e4 = new Employee("Gupta", 71);
        Employee e5 = new Employee("Hemant", 58);
        Employee e6 = new Employee("Singh", 38);
        Employee e7 = new Employee("Vinayak", 1);

        TreeSet t1 = new TreeSet();
        t1.add(e1);
        t1.add(e2);
        t1.add(e3);
        t1.add(e4);
        t1.add(e5);
        t1.add(e6);
        t1.add(e7);
        System.out.println("Default Sorting using Comparable based on Employee Id: "+t1);
//Default Sorting using Comparable based on Employee Id: [Vinayak  1, Pandey  8, Pathak  14, Singh  38, Valmiki  56, Hemant  58, Gupta  71]        
        
        
        TreeSet t2 = new TreeSet(new MyComparator());
        t2.add(e1);
        t2.add(e2);
        t2.add(e3);
        t2.add(e4);
        t2.add(e5);
        t2.add(e6);
        t2.add(e7);
        
        System.out.println("Sorting using Comparator using Employee Names: "+t2);
 //Sorting using Comparator using Employee Names: [Gupta  71, Hemant  58, Pandey  8, Pathak  14, Singh  38, Valmiki  56, Vinayak  1]

    }
}

class Employee implements Comparable {

    String name;
    int eid;

    Employee(String name, int eid) {
        this.name = name;
        this.eid = eid;
    }

    public String toString() {
        return name + "  " + eid;
    }

    public int compareTo(Object obj) {
        int eid1 = this.eid; // first object ie.obj1 or 1st person employee id
        Employee e = (Employee) obj;
        int eid2 = e.eid;// second object ie.obj1 or 2nd person employee id
        if (eid1 < eid2) {
            return -1;// eid 1 comes before eid 2
        } else if (eid1 > eid2) {
            return 1;// eid 1 comes after eid 2
        } else {
            return 0; // duplicate value
        }
    }
}
class MyComparator implements Comparator{
    public int compare(Object obj1,Object obj2){
        Employee e1=(Employee)obj1;
        Employee e2=(Employee)obj2;
        String s1=e1.name;
        String s2=e2.name;
        return s1.compareTo(s2);
    }
}