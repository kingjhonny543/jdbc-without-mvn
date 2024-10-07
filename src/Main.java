import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {



            private static final String url ="jdbc:mysql://localhost:3306/mydb";
            private static final String username="root";
            private static final String password="";

            public static void main(String[] args) {
                try {
                    String className = "com.mysql.cj.jdbc.Driver";
                    Class.forName(className);


                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement statement = connection.createStatement();
                    String query = "select * from students";
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        int roll = resultSet.getInt("roll");
                        double marks = resultSet.getDouble("marks");
                        System.out.println("Id:"+id);
                        System.out.println("Name:"+name);
                        System.out.println("Roll:"+roll);
                        System.out.println("Marks:"+marks);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

