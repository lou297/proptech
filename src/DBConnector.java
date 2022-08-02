import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	private final static String URL = "jdbc:mysql://localhost:3307";
	private final static String DB = "road_info";
	private final static String USER = "root";
	private final static String PWD = "root";
	
	private static Connection conn; //������ ���� ��ü
	static Statement st = null;    //�������� ������ ���� ��ü
	
	public static Connection getConnection() {
		try {
			if(conn == null) {
				conn = DriverManager.getConnection(URL+"/"+DB,USER,PWD);
				conn.setAutoCommit(false);
			}
			return conn;
		} catch(Exception e) {
			System.out.println("DB Connection ���� : " + e);
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