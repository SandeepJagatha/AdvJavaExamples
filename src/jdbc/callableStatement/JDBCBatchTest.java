package jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;

import jdbc.JDBCUtil;

/**
 * This class is used to batch update in DB table using CallableStatement.
 */
public class JDBCBatchTest {
	public static void main(String args[]) {
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call insertEMPLOYEE(?,?,?)}";
		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create callableStatement
			callableStatement = conn.prepareCall(proc);

			callableStatement.setInt(1, 7);
			callableStatement.setString(2, "John Doe");
			callableStatement.setInt(3, 50000);
			callableStatement.addBatch();

			callableStatement.setInt(1, 8);
			callableStatement.setString(2, "Jane Doe");
			callableStatement.setInt(3, 50000);
			callableStatement.addBatch();

			// execute query
			callableStatement.executeBatch();

			// close connection
			callableStatement.close();
			conn.close();

			System.out.println("Records inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
