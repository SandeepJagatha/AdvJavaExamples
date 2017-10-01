package jdbc.storeRetrieveImage;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.JDBCUtil;

/**
 * This class is used to retrieve a image from DB.
 */
public class JDBCRetrieveImageTest {
	public static void main(String args[]) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		String query = "select * from IMAGESTORE where IMAGE_ID = 1";

		try {
			// get connection
			conn = JDBCUtil.getConnection();

			// create preparedStatement
			preparedStatement = conn.prepareStatement(query);

			// execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();

			Blob clob = resultSet.getBlob(2);
			byte[] byteArr = clob.getBytes(1, (int) clob.length());

			FileOutputStream fileOutputStream = new FileOutputStream("F:\\savedImage.jpg");
			fileOutputStream.write(byteArr);

			System.out.println("Image retrieved successfully.");

			// close connection
			fileOutputStream.close();
			preparedStatement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
