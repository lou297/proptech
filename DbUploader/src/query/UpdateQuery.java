package query;

public class UpdateQuery {
	public static final String BUILD = 
			"UPDATE kmig_bld A, kmig_bld_new B set" + 
			"	A.LEGL_DONG_CD=B.LEGL_DONG_CD, " + 
			"	A.SIDO_NM=B.SIDO_NM, " + 
			"	A.SGG_NM=B.SGG_NM, " + 
			"	A.LEGL_UMD_NM=B.LEGL_UMD_NM, " + 
			"	A.GOLI_NM=B.GOLI_NM, " + 
			"	A.MUNT_YN=B.MUNT_YN, " + 
			"	A.HNUM_ORGL_NUM=B.HNUM_ORGL_NUM, " + 
			"	A.HNUM_VICE_NUM=B.HNUM_VICE_NUM, " + 
			"	A.ROAD_NM_CD_VAL=B.ROAD_NM_CD_VAL," + 
			"	A.ROAD_NM=B.ROAD_NM, " + 
			"	A.UNG_YN=B.UNG_YN, " + 
			"	A.CMPX_ORGL_NUM=B.CMPX_ORGL_NUM, " + 
			"	A.CMPX_VICE_NUM=B.CMPX_VICE_NUM, " + 
			"	A.CMPL_RGST_CMPX_NM=B.CMPL_RGST_CMPX_NM, " + 
			"	A.DTL_CMPX_NM=B.DTL_CMPX_NM, " + 
			"	A.CMPX_MGMT_NUM=B.CMPX_MGMT_NUM, " + 
			"	A.UMD_SEQ=B.UMD_SEQ, " + 
			"	A.HJD_DONG_CD=B.HJD_DONG_CD, " + 
			"	A.HJD_DONG_NM=B.HJD_DONG_NM, " + 
			"	A.POST_NUM=B.POST_NUM, " + 
			"	A.POST_SEQC=B.POST_SEQC, " + 
			"	A.MANY_DELI_NM=B.MANY_DELI_NM, " + 
			"	A.MOV_RSN_CD=B.MOV_RSN_CD, " + 
			"	A.NOTI_DD=B.NOTI_DD, " + 
			"	A.BF_ROAD_NM_ADDR=B.BF_ROAD_NM_ADDR, " + 
			"	A.SGG_CMPX_NM=B.SGG_CMPX_NM, " + 
			"	A.JOIN_HOUSE_YN=B.JOIN_HOUSE_YN, " + 
			"	A.BAS_DIST_NUM=B.BAS_DIST_NUM, " + 
			"	A.DTL_ADDR_YN= B.DTL_ADDR_YN, " + 
			"	A.RMK1=B.RMK1, " + 
			"	A.RMK2=B.RMK2" + 
			"	WHERE B.CMPX_MGMT_NUM = A.CMPX_MGMT_NUM AND B.MOV_RSN_CD IN ('31', '34','73')" + 
			"	AND EXISTS (SELECT 1 FROM kmig_bld_new C WHERE C.CMPX_MGMT_NUM = A.CMPX_MGMT_NUM AND C.MOV_RSN_CD IN ('31', '34', '73'));";
	
	public static final String ROAD =
			"update KMIG_ROAD_NM A, KMIG_ROAD_NM_NEW B set"
					+ "A.MGMT_NUM=B.MGMT_NUM, " //1
					+ "A.ROAD_NM_CD_VAL=B.ROAD_NM_CD_VAL, " //2
					+ "A.UMD_SEQ=B.UMD_SEQ, " //3
					+ "A.UNG_YN=B.UNG_YN, " //4
					+ "A.CMPX_ORGL_NUM=B.CMPX_ORGL_NUM, " //5
					+ "A.CMPX_VICE_NUM=B.CMPX_VICE_NUM, " //6 
					+ "A.BAS_DIST_NUM=B.BAS_DIST_NUM, " //7
					+ "A.CHG_RSN_CD=B.CHG_RSN_CD, " //8
					+ "A.NOTI_DD=B.NOTI_DD, " //9 
					+ "A.BF_ROAD_NM_ADDR=B.BF_ROAD_NM_ADDR, " //10
					+ "A.DTL_ADDR_GIVE_YN=B.DTL_ADDR_GIVE_YN" //11
					+ " WHERE B.MGMT_NUM = A.MGMT_NUM AND B.CHG_RSN_CD IN ('31', '34')"
					+ "AND EXISTS (SELECT 1 FROM KMIG_ROAD_NM_NEW C WHERE C.MGMT_NUM = A.MGMT_NUM AND C.CHG_RSN_CD IN ('31', '34'))";
	
//	public static final String ROAD_ETR =
//			"INSERT INTO kmig_road_nm_entr ("
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
			"update KMIG_ROAD_NM_HNUM A, KMIG_ROAD_NM_HNUM_NEW B set"
					+ "A.MGMT_NUM=B.MGMT_NUM, " //1
					+ "A.SEQC=B.SEQC, " //2
					+ "A.LEGL_DONG_CD=B.LEGL_DONG_CD, " //3
					+ "A.SIDO_NM=B.SIDO_NM, " //4
					+ "A.SGG_NM=B.SGG_NM, " //5
					+ "A.LEGL_UMD_NM=B.LEGL_UMD_NM, " //6 
					+ "A.GOLI_NM=B.GOLI_NM, " //7
					+ "A.MUNT_YN=B.MUNT_YN, " //8
					+ "A.HNUM_ORGL_NUM=B.HNUM_ORGL_NUM, " //9 
					+ "A.HNUM_VICE_NUMB=HNUM_VICE_NUM, " //10
					+ "A.RPSN_YN=B.RPSN_YN " //11
					+ "WHERE B.MGMT_NUM = A.MGMT_NUM AND";
}
