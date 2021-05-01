import java.util.*;
import java.sql.*;//Step 1

public class Create_Table {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "create table Emp(Empid int Primary Key,EmpName varchar(25))";
        PreparedStatement ps = con.prepareStatement(query);
		ps.executeUpdate();
        System.out.println("Table Created: ");
        ps.close();
        con.close();

    }
}
