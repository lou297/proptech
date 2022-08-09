import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
//	private static final String DIRECTORY_PATH = "C:\\Users\\LeeJH\\Desktop\\SD\\업무자료\\주소 정보\\test2(빌딩)";
	private static final String DIRECTORY_PATH = "D:\\LawAI\\project\\UploadRoadInfo\\bulkEtr";
	public static final String PREFIX_BUILD = "build_";
	public static final String PREFIX_ROAD = "주소_";
	public static final String PREFIX_JIBUN = "지번_";
	public static final String PREFIX_ROAD_ETR = "RNENTDATA_ALL_";

	public static String[] loadFileList() {
		File directory = new File(DIRECTORY_PATH);
		
		String [] filesName = directory.list();
		
		return filesName;
	}
	
	public static List<String> readFile(String fileName) {
		try {
			List<String> fileStrLines = Files.readAllLines(Paths.get(DIRECTORY_PATH+"/"+fileName));
			
			return fileStrLines;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 읽기 실패 : " + fileName);
			e.printStackTrace();
			return null;
		}
		
	}
}
