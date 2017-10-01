package jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.JDBCUtil;

/**
 * This class is used to select a list of records from DB table using
 * PreparedStatement.
 */
public class JDBCPSSelectTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String query = "select EMPLOYEE_ID, NAME from EMPLOYEE";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create preparedStatement
			preparedStatement = conn.prepareStatement(query);

			// execute query
			ResultSet rs = preparedStatement.executeQuery(query);
			while (rs.next()) {
				String empId = rs.getString("EMPLOYEE_ID");
				String empName = rs.getString("NAME");

				System.out.println("EmpId : " + empId);
				System.out.println("EmpName : " + empName);
			}

			// close connection
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
