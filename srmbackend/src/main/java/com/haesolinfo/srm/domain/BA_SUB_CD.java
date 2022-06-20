package com.haesolinfo.srm.domain;

import com.haesolinfo.srm.dto.pk.BASUBCDPK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@Data
@IdClass(BASUBCDPK.class)
public class BA_SUB_CD {
    @Id
    private String MAIN_CD;

    @Id
    private String SUB_CD;

    private String SUB_NM;
    private String SUB_NM_EN;
    private String SUB_NM_CN;
    private String SUB_NM_VN;
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
