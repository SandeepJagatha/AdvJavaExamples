package jdbc.resultSetMetaData;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

import jdbc.JDBCUtil;

public class JdbcDatabaseMetaDataTest {
	public static void main(String args[]) {
		Connection conn = null;

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// get DatabaseMetaData
			DatabaseMetaData dbmd = conn.getMetaData();

			// Result set meta data
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("DB UserName: " + dbmd.getUserName());
			System.out.println("DB Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("DB Product Version: " + dbmd.getDatabaseProductVersion());

			// close connection
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
