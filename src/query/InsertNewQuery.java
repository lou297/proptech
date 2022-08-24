package query;

public class InsertNewQuery {
	public static final String BUILD = 
			"INSERT INTO KMIG_BLD "
					+ "SELECT * FROM KMIG_BLD_NEW N " 
					+ "WHERE N.MOV_RSN_CD IN ('31', '34', '73') "
					+ "AND NOT EXISTS (SELECT 1 FROM KMIG_BLD O WHERE O.CMPX_MGMT_NUM = N.CMPX_MGMT_NUM);";
	
	public static final String ROAD =
			"insert into KMIG_ROAD_NM ( "
					+ "SELECT * FROM KMIG_ROAD_NM_NEW N "
					+ "WHERE N.CHG_RSN_CD IN ('31', '34') "
					+ "AND NOT EXISTS (SELECT 1 FROM KMIG_ROAD_NM O WHERE O.MGMT_NUM = N.MGMT_NUM);";
	
//	public static final String ROAD_ETR =
//			"INSERT INTO KMIG_ROAD_NM_ENTR ("
//			+ "ROAD_NM_MGMT_NUM, "
//			+ "LEGL_DONG_CD, "
//			+ "SIDO_NM, "
//			+ "SGG_NM, "
//			+ "LEGL_UMD_NM, "
//			+ "GOLI_NM, "
//			+ "ROAD_NM_CD_VAL, "
//			+ "ROAD_NM, "
//			+ "UNG_YN, "
//			+ "CMPX_ORGL_NUM, "
//			+ "CMPX_VICE_NUM, "
//			+ "POST_NUM, "
//			+ "EFCT_OCCR_YMD, "
//			+ "MOV_RSN_CD, "
//			+ "ENTR_SEQ, "
//			+ "ENTR_CL_CD, "
//			+ "ENTR_TYP_CD, "
//			+ "ENTR_X_COOR_VAL, "
//			+ "ENTR_Y_COOR_VAL"
//			+ ") "
//			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);" + 
//			"";
	
	public static final String JIBUN = 
			"insert into KMIG_ROAD_NM_HNUM "
					+ "SELECT * FROM KMIG_ROAD_NM_HNUM_NEW N " + 
			" WHERE NOT EXISTS (SELECT 1 FROM KMIG_ROAD_NM_HNUM O WHERE O.MGMT_NUM = N.MGMT_NUM AND O.SEQC = N.SEQC);";
}
