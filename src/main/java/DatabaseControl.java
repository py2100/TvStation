import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DatabaseControl {
    public static void main(String[] args) {
        String host="localhost";
        String port="3306";
        String database="Query1";   // Name of Database

        String cp="utf8";  // Database codepage supporting Danish:

        String username="root";
        String password="Bacon123";

        String url = "jdbc:mysql://"+host+":"+port+"/"+database+"?characterEncoding="+cp;
        FootagesAndReportersLoader loader = new FootagesAndReportersLoader();



        try{

            // Get connection
            Connection connection= DriverManager.getConnection(url,username,password);
            try {

                List<FootageAndReporter> footagesAndReporters = loader.loadFootagesAndReporters();
                //System.out.println("loading from "+args[0]);
                for(FootageAndReporter footageAndReporter : footagesAndReporters) {

                    System.out.print(footageAndReporter.getFootage().getTitle());

                    //System.out.println("\tReporter: " + footageAndReporter.getReporter());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            PreparedStatement statement=  connection.prepareStatement("create table KagePis(LastName VARCHAR(30));");


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
