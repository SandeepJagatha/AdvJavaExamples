package jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;

import jdbc.JDBCUtil;

/**
 * This class is used to insert a record in DB table using CallableStatement.
 */
public class JDBCINTest {
	public static void main(String args[]) {
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call insertEMPLOYEE(?,?,?)}";
		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create callableStatement
			callableStatement = conn.prepareCall(proc);
			callableStatement.setInt(1, 5);
			callableStatement.setString(2, "John Doe");
			callableStatement.setInt(3, 100000);

			// execute query
			callableStatement.executeUpdate();

			// close connection
			callableStatement.close();
			conn.close();

			System.out.println("Record inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
