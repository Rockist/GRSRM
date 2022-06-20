package com.haesolinfo.srm.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class BA_BIZ_PARTNER {
    @Id
    private String BP_CD;
    private String BP_TYPE;
    private String BP_GROUP;
    private String BP_RGST_NO;
    private String BP_FULL_NM;
    private String BP_NM;
    private String BP_ENG_NM;
    private String USE_YN;
    private String REPRE_NM;
    private String CURRENCY;
    private String ZIP_CD;
    private String ADDR1;
    private String ADDR2;
    private String ADDR3;
    private String ADDR1_ENG;
    private String ADDR2_ENG;
    private String ADDR3_ENG;
    private String IND_TYPE;
    private String IND_CLASS;
    private String TEL_NO1;
    private String TEL_NO2;
    private String FAX_NO;
    private String BP_PRSN_NM;
    private String BP_PRSN_TEL;
    private String BP_EMAIL;
    private String SRM_YN;
    private String INSERT_ID;
    private LocalDate INSERT_DT;
    private String UPDATE_ID;
    private LocalDate UPDATE_DT;
    private String TEMP_CD1;
    private String TEMP_CD2;
    private String TEMP_CD3;
    private Double TEMP_NO1;
    private Double TEMP_NO2;
    private Double TEMP_NO3;
}
