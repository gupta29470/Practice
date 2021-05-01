import java.util.*;
import java.sql.*;//Step 1

public class DAO {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(5);
        System.out.println(s1.name);

    }
}

class StudentDAO {

    public Student getStudent(int rollno) {
        Student s = new Student();
        s.rollno = rollno;
        try {
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "root";
            String password = "Aakash@1998";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            String query = "Select Full_Name from Students where Roll_no=" + rollno;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("Full_Name");
            s.name = name;
            return s;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}

class Student {

    int rollno;
    String name;
}
