package jdbc.resultSetMetaData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import jdbc.JDBCUtil;

/**
 * This class is used to show the use of ResultSetMetaData.
 */
public class JdbcRSMDTest {
	public static void main(String args[]) {
		Connection conn = null;
		Statement statement = null;

		String query = "select EMPLOYEE_ID, " + "NAME from EMPLOYEE";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create statement
			statement = conn.createStatement();

			// execute query
			ResultSet rs = statement.executeQuery(query);

			// get ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();

			// Result set meta data
			System.out.println("Total cols: " + rsmd.getColumnCount());
			System.out.println("Column name: " + rsmd.getColumnName(1));
			System.out.println("Column type: " + rsmd.getColumnTypeName(1));

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
