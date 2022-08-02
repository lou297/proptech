import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;

public class Run {
	private static Connection conn;
	private static final String DIRECTORY_PATH = "D:\\SD 업무자료\\uploadFile";
	private static final String PREFIX_BUILD = "build_";
	private static final String PREFIX_ROAD = "주소_";
	private static final String PREFIX_JIBUN = "지번_";
	private static int totalSize = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		loadFileList();
		DBConnector.close();
		System.out.println("쿼리 실행 완료");
	}
	
	private static void loadFileList() {
		File directory = new File(DIRECTORY_PATH);
		
		String [] filesName = directory.list();
		
		for(String fileName : filesName) {
			if(fileName.startsWith(PREFIX_BUILD))
				readFile(fileName, 0);
//				System.out.println(fileName  +" -> 건물");
			else if(fileName.startsWith(PREFIX_ROAD))
				readFile(fileName, 1);
//				System.out.println(fileName  +" -> 주소");
			else if(fileName.startsWith(PREFIX_JIBUN))
				readFile(fileName, 2);
//				System.out.println(fileName  +" -> 지번");
			else
				System.out.println(fileName + " -> 오류");
			if(fileName.startsWith(PREFIX_ROAD))
				break;
		}
		System.out.println("주소 전체 사이즈 : " + totalSize);
	}
	
	private static void init() {

		conn = DBConnector.getConnection();
	}
	
	
	private static void readFile(String fileName, int fileType) {
		try {
			if(fileType != 1)
				return;
			List<String> fileStrLines = Files.readAllLines(Paths.get(DIRECTORY_PATH+"/"+fileName));
			System.out.println(fileName +"의 크기 : " + fileStrLines.size());
			totalSize += fileStrLines.size();
			callQuery(fileStrLines, fileType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 읽기 실패 : " + fileName);
			e.printStackTrace();
		}
		
//		switch(fileType) {
//		case 0 :
//			//건물
//			break;
//		case 1 :
//			//주소
//			break;
//		case 2 :
//			//지번
//			break;
//		}
	}
	
	private static void callQuery(List<String> fileStrLines, int fileType) {
		
		QueryCaller queryCaller = new QueryCaller();
		
		switch(fileType) {
		case 0 :
			//건물
			break;
		case 1 :
			//주소
			for(String data : fileStrLines) {
				queryCaller.loadRoadInfoQuery(data);
			}
			break;
		case 2 :
			//지번
			break;
		}
		
//		queryCaller.loadBuildingInfoQuery("2611010100|부산광역시|중구|영주동||0|60|23|261103006001|초량상로|0|1|4|||2611010100100600023003612|01|2611059000|영주제1동|48910|||||||0|48910|0||");
//		queryCaller.loadRoadInfoQuery("4211025022103840000000001|421102218001|01|0|1877|0|24204||||0");
//		queryCaller.loadJibunInfoQuery("2711010100100010000009433|1|2711010100|대구광역시|중구|동인동1가||0|2|1|1");
		
		try {
			conn.commit();
		} catch(Throwable t) {
			System.out.println("commit 에러 : " + t.getMessage());
		} finally {
//			try {
//				if(conn != null) conn.close();
//			} catch(Throwable t) {
//				
//			}
			System.out.println("완료");
		}
	}
	
	

}
