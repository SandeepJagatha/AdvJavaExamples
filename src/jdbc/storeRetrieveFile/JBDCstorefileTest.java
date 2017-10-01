package jdbc.storeRetrieveFile;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jdbc.JDBCUtil;

/**
 * This class is used to store a file in DB.
 */
public class JBDCstorefileTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String createTableQuery = "create table FILESTORE(" + "FILE_ID NUMBER(5) NOT NULL, " + "NAME CLOB NOT NULL, "
				+ "PRIMARY KEY (FILE_ID) )";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create preparedStatement
			preparedStatement = conn.prepareStatement(createTableQuery);

			// execute query for create table
			preparedStatement.execute();
			System.out.println("Table created successfully.");

			String storeFileQuery = "insert into FILESTORE " + "values (?,?)";
			preparedStatement = conn.prepareStatement(storeFileQuery);

			// Read source file
			File file = new File("F:\\test.txt");
			FileReader fileReader = new FileReader(file);

			preparedStatement.setInt(1, 2);
			preparedStatement.setCharacterStream(2, fileReader, (int) file.length());

			preparedStatement.executeUpdate();
			System.out.println("File stored successfully.");

			// close connection
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
