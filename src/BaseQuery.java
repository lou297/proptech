
public class BaseQuery {
	public static final String BUILD = 
			"insert into kmig_bld("
					+ "LEGL_DONG_CD, " //1
					+ "SIDO_NM, " //2
					+ "SGG_NM, " //3
					+ "LEGL_UMD_NM, " //4
					+ "GOLI_NM, " //5
					+ "MUNT_YN, " //6 
					+ "HNUM_ORGL_NUM, " //7
					+ "HNUM_VICE_NUM, " //8
					+ "ROAD_NM_CD_VAL, " //9 
					+ "ROAD_NM, " //10
					+ "UNG_YN, " //11
					+ "CMPX_ORGL_NUM, " //12
					+ "CMPX_VICE_NUM, " //13
					+ "CMPL_RGST_CMPX_NM, " //14
					+ "DTL_CMPX_NM, " //15
					+ "CMPX_MGMT_NUM, " //16
					+ "UMD_SEQ, " //17 
					+ "HJD_DONG_CD, " //18
					+ "HJD_DONG_NM, " //19
					+ "POST_NUM, " //20
					+ "POST_SEQC, " //21
					+ "MANY_DELI_NM, " //22
					+ "MOV_RSN_CD, " //23
					+ "NOTI_DD, " //24
					+ "BF_ROAD_NM_ADDR, " //25
					+ "SGG_CMPX_NM, " //26
					+ "JOIN_HOUSE_YN, " //27
					+ "BAS_DIST_NUM, " //28
					+ "DTL_ADDR_YN, " //29
					+ "RMK1, " //30
					+ "RMK2" //31
					+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String ROAD =
			"insert into kmig_road_nm ("
					+ "MGMT_NUM, " //1
					+ "ROAD_NM_CD_VAL, " //2
					+ "UMD_SEQ, " //3
					+ "UNG_YN, " //4
					+ "CMPX_ORGL_NUM, " //5
					+ "CMPX_VICE_NUM, " //6 
					+ "BAS_DIST_NUM, " //7
					+ "CHG_RSN_CD, " //8
					+ "NOTI_DD, " //9 
					+ "BF_ROAD_NM_ADDR, " //10
					+ "DTL_ADDR_GIVE_YN" //11
					+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String JIBUN = 
			"insert into kmig_road_nm_hnum ("
					+ "MGMT_NUM, " //1
					+ "SEQC, " //2
					+ "LEGL_DONG_CD, " //3
					+ "SIDO_NM, " //4
					+ "SGG_NM, " //5
					+ "LEGL_UMD_NM, " //6 
					+ "GOLI_NM, " //7
					+ "MUNT_YN, " //8
					+ "HNUM_ORGL_NUM, " //9 
					+ "HNUM_VICE_NUM, " //10
					+ "RPSN_YN" //11
					+ ") "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
