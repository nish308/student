import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestGetAll {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "Nishant@3001";
		String sql = "Select * from student";
		
		//1:Load or register driver
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2: Establish connection
			connection = DriverManager.getConnection(url, username, password);
			
			//3: Establish statement
			Statement statement = connection.createStatement();
			
			//4: Execute statement
			ResultSet resultSet =  statement.executeQuery(sql);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println("=====================");
			}	
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				System.out.println("All Good");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
