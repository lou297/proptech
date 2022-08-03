import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private final static String URL = "jdbc:mysql://localhost:3306";
	private final static String DB = "road_info";
	private final static String USER = "root";
	private final static String PWD = "root";
	
//	private final static String URL = "jdbc:mysql://skcc-lawai-rds-p1.cyyp4tfbvwkc.ap-northeast-2.rds.amazonaws.com:3306";
//	private final static String DB = "lawai2";
//	private final static String USER = "lawai2";
//	private final static String PWD = "ApplePie!1";
	
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(URL+"/"+DB,USER,PWD);
				conn.setAutoCommit(false);
			}
			return conn;
		} catch(Exception e) {
			System.out.println("DB Connection 실패 : " + e);
			return null;
		}
	}

	public static void close()
	{
		if (conn != null)
		{
			try {
				if (!conn.isClosed())
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("DB Connection �ݱ� ����");
				e.printStackTrace();
			}
		}
		
		conn = null;
	}
	
}