import java.util.*;

public class Student_Class_with_Comparable {

    public static void main(String[] args) throws IOException {
        List<Students> list = new ArrayList();
        list.add(new Students(1, "Vinayak", 55));
        list.add(new Students(2, "Ojha", 65));
        list.add(new Students(3, "Pal", 96));
        list.add(new Students(4, "Paliwal", 21));
        list.add(new Students(5, "Jayesh", 52));
        list.add(new Students(6, "Pandey", 48));
        list.add(new Students(7, "Sandeep", 36));
        list.add(new Students(8, "Pathak", 55));
        list.add(new Students(9, "Peri", 88));
        list.add(new Students(10, "Poojari", 95));

        Collections.sort(list);

        ListIterator ltr = list.listIterator();
        while (ltr.hasNext()) {
            System.out.println(ltr.next() + " ");
        }
        /*3  Pal  96 
         10  Poojari  95 
         9  Peri  88 
         2  Ojha  65 
         1  Vinayak  55 
         8  Pathak  55 
         5  Jayesh  52 
         6  Pandey  48 
         7  Sandeep  36 
         4  Paliwal  21 */

    }
}

class Students implements Comparable<Students> {

    int rollno;
    String name;
    int marks;

    public Students(int rollno, String name, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.marks = marks;

    }

    public String toString() {
        return rollno + "  " + name + "  " + marks;
    }

    public int compareTo(Students m) {

        return this.marks > m.marks ? -1 : this.marks < m.marks ? 1 : 0;
    }

}
