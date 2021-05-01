import java.util.*;
import java.sql.*;//Step 1

public class Insert_into_Database {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "insert into Students values(?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        int rollno = sc.nextInt();
         ps.setInt(1, rollno);
        String name = sc.next();
        ps.setString(2, name);
        int count = ps.executeUpdate();
        System.out.println("Row(s) affected: " + count);
        ps.close();
        con.close();

    }
}
