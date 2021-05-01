import java.util.*;
import java.sql.*;//Step 1

public class Delete_data {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "delete from Students where Roll_no=?";
        PreparedStatement ps = con.prepareStatement(query);
        System.out.println("Enter which roll no you want to delete");
        int rollno = sc.nextInt();
        ps.setInt(1, rollno);
        int count = ps.executeUpdate();
        System.out.println("Row(s) affected: " + count);
        ps.close();
        con.close();

    }
}
