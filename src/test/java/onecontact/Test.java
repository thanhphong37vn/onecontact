package onecontact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;

public class Test {
	@SuppressWarnings("unused")
	private static Connection ConnectOracle(String computerName, String port,
			String sID, String userName, String password) {
		System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;

		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@" + computerName + ":"
							+ port + ":" + sID, userName, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			return connection;
		} else {
			System.out.println("Failed to make connection!");
			return null;
		}
	}

	public static void testBase64(){
		String string = "việt nam";
		byte[] byteArray = Base64.encodeBase64(string.getBytes());
		 

		  // Print the encoded byte array

		  System.out.println(Arrays.toString(byteArray));
		 

		  // Print the encoded string

		  String encodedString = new String(byteArray);

		  System.out.println(string + " = " + encodedString);
		  System.out.println("---------");
		  System.out.println(new String(Base64.decodeBase64(encodedString.getBytes())));
		  
	}
	
	public static void main(String[] args) {
		testBase64();
		
		
		
//		// TODO Auto-generated method stub
//		Connection conn = ConnectOracle("118.70.177.191", "1521", "test1",
//				"test", "Test1234");
//		if (conn != null) {
//			String sqlString = "SELECT * FROM MESSAGEHEADER";
//			Statement st = null;
//			try {
//				st = conn.createStatement();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			ResultSet rs = null;
//			try {
//				rs = st.executeQuery(sqlString);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			// get data from result set
//			try {
//				while (rs.next()) {
//					System.out.println(rs.getString("STREAMINGNO"));
//					System.out.println(rs.getString("TIMESTAMP"));
//					System.out.println(rs.getString("ACTIONTYPE"));
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				System.err.println(e.getMessage());
//			}
//		}
	}
}
