import java.util.*;
import java.sql.*;//Step 1

public class Drop_Table {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "drop table Empl";
        PreparedStatement ps = con.prepareStatement(query);
        ps.executeUpdate();
        System.out.println("Table Dropped ");
        ps.close();
        con.close();

    }
}
