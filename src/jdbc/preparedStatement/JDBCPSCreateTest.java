package jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.JDBCUtil;

/**
 * This class is used to create a table in DB using PreparedStatement.
 */
public class JDBCPSCreateTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String query = "create table EMPLOYEE(" + "EMPLOYEE_ID NUMBER(5) NOT NULL, " + "NAME VARCHAR(20) NOT NULL, "
				+ "SALARY NUMBER(10) NOT NULL, " + "PRIMARY KEY (EMPLOYEE_ID) )";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create preparedStatement
			preparedStatement = conn.prepareStatement(query);

			// execute query
			preparedStatement.execute();

			// close connection
			preparedStatement.close();
			conn.close();

			System.out.println("Table created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
