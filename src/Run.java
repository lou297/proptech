import java.sql.Connection;
import java.util.List;

public class Run {
	private static Connection conn;
	private static int maxLen = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test();
		init();
		loadFileInfo();
		DBConnector.close();
		System.out.println("성공");
	}
	
//	private static void test() {
//		String path = "D:\\LawAI\\project\\UploadRoadInfo";
//		File directory = new File(path);
//		
//		String [] filesName = directory.list();
//		
//		for(String fileName : filesName) {
//			try {
//				System.out.println(fileName + " 읽기 시작");
//				List<String> fileStrLines = Files.readAllLines(Paths.get(path+"/"+fileName));
//				for(String fileStr : fileStrLines) {
//					String[] contents = fileStr.split("\\|", -1);
//					
//					for(String content : contents) {
//						int contentSize = content.length();
//						if(maxLen < contentSize) {
//							maxLen = contentSize;
//							System.out.println("최대 길이 : " + maxLen);
//						}
//					}
//				}
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				System.out.println("파일 읽기 실패 : " + fileName);
//				e.printStackTrace();
//			}
//		}
//	}
//	
	
	
	private static void init() {

		conn = DBConnector.getConnection();
	}
	
	private static void loadFileInfo() {
		int totalDataSize = 0;
		
		String[] fileNames = FileReader.loadFileList();
		int fileNumber = fileNames.length;
		for(int i = 0 ; i < fileNumber; i++) {
			String fileName = fileNames[i];
			System.out.println(fileName +" 읽기 시작");
			
			List<String> fileContents = FileReader.readFile(fileName);
			System.out.println("해당 파일에 데이터 " + fileContents.size() +"건이 존재합니다.");
			totalDataSize += fileContents.size();
			QueryCaller qc = new QueryCaller();
			if(fileName.startsWith(FileReader.PREFIX_BUILD)) {
				qc.loadBuildInfo(fileContents);
			}
			else if(fileName.startsWith(FileReader.PREFIX_ROAD)) {
				qc.loadRoadInfo(fileContents);
			}
			else if(fileName.startsWith(FileReader.PREFIX_ROAD_ETR)) {
				qc.loadRoadEtrInfo(fileContents);
			}
			else if(fileName.startsWith(FileReader.PREFIX_JIBUN)) {
				qc.loadJibunInfo(fileContents);
			}
			else
				System.out.println(fileName + " -> 오류");
			System.out.println("db insert 완료되었습니다. ("+(i+1)+"/"+fileNumber+")\n");
		}
		
		System.out.println("전체 파일 대상으로 총 " + totalDataSize +"건이 Insert됐습니다.");
	}
	
	

}
