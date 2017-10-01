package jdbc;

import java.sql.Connection;
import java.sql.Statement;

/**
 * This class is used to batch update in DB table.
 */
public class JDBCBatchTest {
	public static void main(String args[]) {
		Connection conn = null;
		Statement statement = null;

		String query1 = "insert into EMPLOYEE " + "(EMPLOYEE_ID, NAME, SALARY) " + "values (1, 'Jane Doe', 50000)";

		String query2 = "insert into EMPLOYEE " + "(EMPLOYEE_ID, NAME, SALARY) " + "values (5, 'John Doe', 50000)";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create statement
			statement = conn.createStatement();

			// set auto commit to false
			conn.setAutoCommit(false);

			// add queries to batch
			statement.addBatch(query1);
			statement.addBatch(query2);

			// execute batch
			statement.executeBatch();

			// commit
			conn.commit();

			// close connection
			statement.close();
			conn.close();

			System.out.println("Records inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
