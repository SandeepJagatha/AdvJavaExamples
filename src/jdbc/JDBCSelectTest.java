package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelectTest {
	public static void main(String args[]) {
		Connection conn = null;
		Statement statement = null;

		String query = "select EMPLOYEE_ID, NAME from EMPLOYEE";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create statement
			statement = conn.createStatement();

			// execute query
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String empId = rs.getString("EMPLOYEE_ID");
				String empName = rs.getString("NAME");

				System.out.println("EmpId : " + empId);
				System.out.println("EmpName : " + empName);
			}

			// close connection
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
