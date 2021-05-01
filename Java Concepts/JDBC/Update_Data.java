import java.util.*;
import java.sql.*;//Step 1

public class Update_Data {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        String query = "update  Students set Full_Name='Rai' where Roll_no='9'";
        PreparedStatement ps = con.prepareStatement(query);
        int count = ps.executeUpdate();
        System.out.println("Row(s) affected: " + count);
        ps.close();
        con.close();

    }
}
