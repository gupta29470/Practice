import java.util.*;
import java.sql.*;//Step 1

public class Fetch_all_values-from DB {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Aakash@1998";
        String query = "select * from students;";
        Class.forName("com.mysql.jdbc.Driver");//Step2
        Connection con = DriverManager.getConnection(url, username, password);//Step3
        Statement st = con.createStatement();//Step 4
        ResultSet rs = st.executeQuery(query);//Step 5
        while (rs.next()) {
            String data = rs.getInt("Roll_no") + " " + rs.getString("Full_Name");//Navada
            System.out.println(data);
        }
        st.close();
        con.close();//Step 7

        /*
         1 Navada
         2 Ojha
         3 Pal
         4 Paliwal
         5 Pandey
         */
    }
}
