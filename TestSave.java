import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSave {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/javabatch";
		String username = "root";
		String password = "Nishant@3001";
	   
		//1:Load or register driver
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2: Establish connection
			connection = DriverManager.getConnection(url, username, password);
			
			//3: Establish statement
			Statement statement = connection.createStatement();
			
//			4: Execute statement
			statement.execute("INSERT INTO student VALUES(5,'Dim','dim@mail.com')");
			
//			int a = statement.executeUpdate("UPDATE student SET name ='Pritam' WHERE id = 4");
//			if(a>0) {
//				System.out.println("Updated");
//			}else {
//				System.out.println("Updated");
//			}
			
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
