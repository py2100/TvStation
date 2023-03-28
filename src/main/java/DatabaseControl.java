import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseControl {
    public static void main(String[] args) {
        String host="localhost";
        String port="3306";
        String database="Tv";   // Name of Database
        String cp="utf8";  // Database codepage supporting Danish:

        String username="root";
        String password="mypassword";

        String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?characterEncoding="+cp;
        try{
            // Get connection
            Connection connection= DriverManager.getConnection(url,username,password);
            Scanner scan = new Scanner(System.in,"CP850");
            String input = scan.nextLine();
            scan.close();
            PreparedStatement statement=  connection.prepareStatement("insert into Edition values ()");
            System.out.println(statement);
            statement.execute();

           // statement=  connection.prepareStatement("insert into Edition values ()");
          //  System.out.println(statement);
           // statement.execute();


            //statement=  connection.prepareStatement("insert into Edition values ()");
          //  System.out.println(statement);
          //  statement.execute();





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
