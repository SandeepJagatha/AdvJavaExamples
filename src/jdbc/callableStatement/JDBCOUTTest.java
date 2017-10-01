package jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;

import jdbc.JDBCUtil;

/**
 * This class is used to get a record from DB table using CallableStatement.
 */
public class JDBCOUTTest {
	public static void main(String args[]) {
		Connection conn = null;
		CallableStatement callableStatement = null;
		String proc = "{call getEmpNameByEmpId(?,?)}";
		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create callableStatement
			callableStatement = conn.prepareCall(proc);
			callableStatement.setInt(1, 5);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

			// execute query
			callableStatement.executeUpdate();

			// get employee name
			String empName = callableStatement.getString(2);
			System.out.println("Emp Name: " + empName);

			// close connection
			callableStatement.close();
			conn.close();

			System.out.println("Record inserted successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
