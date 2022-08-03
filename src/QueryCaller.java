import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class QueryCaller {
	private static final int BATCH_CLEAN_TIME = 500000;
	public void loadBuildInfo(List<String> txtBuildInfos) {
		Connection conn = DBConnector.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(BaseQuery.BUILD);
			int buildsSize = txtBuildInfos.size();
			
			for(int n = 0 ; n < buildsSize ; n++) {
				String buildInfos = txtBuildInfos.get(n);
				String[] inputableBuildInfos = convertStrToStrList(buildInfos);
				//한줄씩 입력
				
				for(int i = 1 ; i <= 31; i++) {
					String inputableBuildInfo = inputableBuildInfos[i-1];
					if(i == 7 || i == 8 || i ==12 || i == 13) {
//						if(inputableBuildInfo.length() != 0)
							pstmt.setInt(i, Integer.parseInt(inputableBuildInfo));
//						else 
//							pstmt.setString(i, null);
							
					} else {
//						if(inputableBuildInfo.length() != 0)
							pstmt.setString(i, inputableBuildInfo);
//						else 
//							pstmt.setString(i, null);
					}
				}
				
				pstmt.addBatch();
				
				pstmt.clearParameters();
				
				if((n % BATCH_CLEAN_TIME) == 0) {
					pstmt.executeBatch();
					
					pstmt.clearBatch();
					
					conn.commit();
				}
			}
			
			
			
			pstmt.executeBatch();
			
			pstmt.clearBatch();
			
			conn.commit();
		} catch(SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
					System.out.println("query 실행 실패 : " + e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	public void loadRoadInfo(List<String> txtRoadInfos) {
		Connection conn = DBConnector.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(BaseQuery.ROAD);
			int roadsSize = txtRoadInfos.size();
			
			for(int n = 0 ; n < roadsSize ; n++) {
				String roadInfos = txtRoadInfos.get(n);
				String[] inputableRoadInfos = convertStrToStrList(roadInfos);
				//한줄씩 입력
			
				for(int i = 1 ; i <= 11; i++) {
					String inputableRoadInfo = inputableRoadInfos[i-1];
					if(i == 5 || i == 6) {
//						if(inputableRoadInfo.length() != 0)
							pstmt.setInt(i, Integer.parseInt(inputableRoadInfo));
//						else 
//							pstmt.setString(i, null);
							
					} else {
//						if(inputableRoadInfo.length() != 0)
							pstmt.setString(i, inputableRoadInfo);
//						else 
//							pstmt.setString(i, null);
					}
				}
				pstmt.addBatch();
				
				pstmt.clearParameters();
			}

			
			
			pstmt.executeBatch();
			
			pstmt.clearBatch();
			
			conn.commit();
		} catch(Throwable e) {
			if(conn != null) {
				try {
					conn.rollback();
					System.out.println("query 실행 실패 : " + e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	public void loadJibunInfo(List<String> txtJibunInfos) {
		Connection conn = DBConnector.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(BaseQuery.JIBUN);
			int jibunsSize = txtJibunInfos.size();
			
			for(int n = 0 ; n < jibunsSize ; n++) {
				String jibunInfos = txtJibunInfos.get(n);
				String[] inputableJibunInfos = convertStrToStrList(jibunInfos);
				//한줄씩 입력
				
				for(int i = 1 ; i <= 11; i++) {
					String inputableJibunInfo = inputableJibunInfos[i-1];
					if(i == 9 || i == 10) {
//						if(inputableJibunInfo.length() != 0)
							pstmt.setInt(i, Integer.parseInt(inputableJibunInfo));
//						else 
//							pstmt.setString(i, null);
							
					} else {
//						if(inputableJibunInfo.length() != 0)
							pstmt.setString(i, inputableJibunInfo);
//						else 
//							pstmt.setString(i, null);
					}
				}
				pstmt.addBatch();
				
				pstmt.clearParameters();
			}

			
			
			pstmt.executeBatch();
			
			pstmt.clearBatch();
			
			conn.commit();
		} catch(Throwable e) {
			if(conn != null) {
				try {
					conn.rollback();
					System.out.println("query 실행 실패 : " + e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public String[] convertStrToStrList(String valueStr) {
		return valueStr.split("\\|", -1);
	}
	
	

}
