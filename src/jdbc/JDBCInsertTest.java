package jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class JDBCInsertTest {
	public static void main(String args[]) {
		Connection conn = null;
		Statement statement = null;

		String query = "insert into EMPLOYEE " + "(EMPLOYEE_ID, NAME, SALARY) " + "values (1, 'Sj', 85000)";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create statement
			statement = conn.createStatement();

			// execute query
			statement.executeUpdate(query);

			// close connection
			statement.close();
			conn.close();

			System.out.println("Record inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
