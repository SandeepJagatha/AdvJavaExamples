package jdbc;

import java.sql.Connection;
import java.sql.Statement;

/**
 * This class is used to create a table in DB.
 */
public class JDBCCreateTest {
	public static void main(String args[]) {
		Connection conn = null;
		Statement statement = null;

		String query = "create table EMPLOYEE(" + "EMPLOYEE_ID NUMBER(5) NOT NULL, " + "NAME VARCHAR(20) NOT NULL, "
				+ "SALARY NUMBER(10) NOT NULL, " + "PRIMARY KEY (EMPLOYEE_ID) )";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create statement
			statement = conn.createStatement();

			// execute query
			statement.execute(query);

			// close connection
			statement.close();
			conn.close();

			System.out.println("Table created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
