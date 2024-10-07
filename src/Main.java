import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for database connection details
        System.out.print("Enter DB URL (e.g., jdbc:mysql://mysql-container:3306/mydb): ");
        String url = scanner.nextLine();

        System.out.print("Enter DB Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter DB Password: ");
        String password = scanner.nextLine();

        try {
            String className = "com.mysql.cj.jdbc.Driver";
            Class.forName(className);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int roll = resultSet.getInt("roll");
                double marks = resultSet.getDouble("marks");
                System.out.println("Id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Roll: " + roll);
                System.out.println("Marks: " + marks);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
