package jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.JDBCUtil;

/**
 * This class is used to batch update in DB table using PreparedStatement.
 */
public class JDBCPSBatchTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String query = "insert into EMPLOYEE " + "(EMPLOYEE_ID, NAME, SALARY) " + "values (?,?,?)";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// set auto commit to false
			conn.setAutoCommit(false);

			// create preparedStatement
			preparedStatement = conn.prepareStatement(query);

			// set values
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "John Doe");
			preparedStatement.setInt(3, 62000);
			preparedStatement.addBatch();

			// set values
			preparedStatement.setInt(1, 4);
			preparedStatement.setString(2, "Jane Doe");
			preparedStatement.setInt(3, 52000);
			preparedStatement.addBatch();

			// execute query
			preparedStatement.executeBatch();

			// commit
			conn.commit();

			// close connection
			preparedStatement.close();
			conn.close();

			System.out.println("Record inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
