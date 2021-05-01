                                                import java.util.*;
import java.sql.*;//Step 1

public class JDBC_1 {

    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/jdbc";
        String username="root";
        String password="Aakash@1998";
        String query="select * from students;";
        Class.forName("com.mysql.jdbc.Driver");//Step2
        Connection con=DriverManager.getConnection(url,username,password);//Step3
        Statement st=con.createStatement();//Step 4
        ResultSet rs=st.executeQuery(query);//Step 5
        rs.next();//Step 6
        String data=rs.getString("Full_Name");//Navada
        System.out.println(data);
        st.close();
        con.close();//Step 7

    }
}
