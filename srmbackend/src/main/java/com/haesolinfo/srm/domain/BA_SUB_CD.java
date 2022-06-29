package com.haesolinfo.srm.domain;

import com.haesolinfo.srm.dto.pk.BASUBCDPK;
import com.haesolinfo.srm.dto.pk.srm501w.SRM501WDtoSP1PK;
import com.haesolinfo.srm.dto.srm501w.SRM501WDtoSP1;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;

@NamedStoredProcedureQuery(
        name = "BASUBCD.SRM_USP_BA_SUB_CD",
        procedureName = "SRM_USP_BA_SUB_CD",
        resultClasses = BA_SUB_CD.class)
@Data
@Entity
@IdClass(BASUBCDPK.class)
public class BA_SUB_CD {
    @Id
    private String MAIN_CD;

    @Id
    private String SUB_CD;
    private String SUB_NM;
    private String SUB_NM_CHN;
    private String SUB_NM_VNM;
    private String SUB_NM_ENG;
    private String USE_YN;
    private String TEMP_CD1;
    private String TEMP_CD2;
    private String TEMP_CD3;
    private String TEMP_CD4;
    private String TEMP_CD5;
    private String TEMP_NO1;
    private String TEMP_NO2;
    private String TEMP_NO3;
    private String TEMP_NO4;
    private String TEMP_NO5;
    private String INSERT_ID;
    private String INSERT_DT;
    private String UPDATE_ID;
    private String UPDATE_DT;
    private String REMARK;

}
