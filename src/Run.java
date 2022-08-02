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
	private static final String DIRECTORY_PATH = "D:\\SD �����ڷ�\\uploadFile";
	private static final String PREFIX_BUILD = "build_";
	private static final String PREFIX_ROAD = "�ּ�_";
	private static final String PREFIX_JIBUN = "����_";
	private static int totalSize = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		loadFileList();
		DBConnector.close();
		System.out.println("���� ���� �Ϸ�");
	}
	
	private static void loadFileList() {
		File directory = new File(DIRECTORY_PATH);
		
		String [] filesName = directory.list();
		
		for(String fileName : filesName) {
			if(fileName.startsWith(PREFIX_BUILD))
				readFile(fileName, 0);
//				System.out.println(fileName  +" -> �ǹ�");
			else if(fileName.startsWith(PREFIX_ROAD))
				readFile(fileName, 1);
//				System.out.println(fileName  +" -> �ּ�");
			else if(fileName.startsWith(PREFIX_JIBUN))
				readFile(fileName, 2);
//				System.out.println(fileName  +" -> ����");
			else
				System.out.println(fileName + " -> ����");
			if(fileName.startsWith(PREFIX_ROAD))
				break;
		}
		System.out.println("�ּ� ��ü ������ : " + totalSize);
	}
	
	private static void init() {

		conn = DBConnector.getConnection();
	}
	
	
	private static void readFile(String fileName, int fileType) {
		try {
			if(fileType != 1)
				return;
			List<String> fileStrLines = Files.readAllLines(Paths.get(DIRECTORY_PATH+"/"+fileName));
			System.out.println(fileName +"�� ũ�� : " + fileStrLines.size());
			totalSize += fileStrLines.size();
			callQuery(fileStrLines, fileType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("���� �б� ���� : " + fileName);
			e.printStackTrace();
		}
		
//		switch(fileType) {
//		case 0 :
//			//�ǹ�
//			break;
//		case 1 :
//			//�ּ�
//			break;
//		case 2 :
//			//����
//			break;
//		}
	}
	
	private static void callQuery(List<String> fileStrLines, int fileType) {
		
		QueryCaller queryCaller = new QueryCaller();
		
		switch(fileType) {
		case 0 :
			//�ǹ�
			break;
		case 1 :
			//�ּ�
			for(String data : fileStrLines) {
				queryCaller.loadRoadInfoQuery(data);
			}
			break;
		case 2 :
			//����
			break;
		}
		
//		queryCaller.loadBuildingInfoQuery("2611010100|�λ걤����|�߱�|���ֵ�||0|60|23|261103006001|�ʷ����|0|1|4|||2611010100100600023003612|01|2611059000|������1��|48910|||||||0|48910|0||");
//		queryCaller.loadRoadInfoQuery("4211025022103840000000001|421102218001|01|0|1877|0|24204||||0");
//		queryCaller.loadJibunInfoQuery("2711010100100010000009433|1|2711010100|�뱸������|�߱�|���ε�1��||0|2|1|1");
		
		try {
			conn.commit();
		} catch(Throwable t) {
			System.out.println("commit ���� : " + t.getMessage());
		} finally {
//			try {
//				if(conn != null) conn.close();
//			} catch(Throwable t) {
//				
//			}
			System.out.println("�Ϸ�");
		}
	}
	
	

}
