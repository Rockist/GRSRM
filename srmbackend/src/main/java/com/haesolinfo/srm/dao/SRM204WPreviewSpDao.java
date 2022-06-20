package com.haesolinfo.srm.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SRM204WPreviewSpDao {
    @Id
    private int CNT;
    private String GUBUN;
    private int GCNT;
    private Date DLVY_DT;
    private String DLVY_NO;
    private String BP_RGIST_NO;
    private String BP_NM;
    private String REPRE_NM;
    private String ADDR;
    private String TEL_NO1;
    private String FAX_NO;
    private String IND_TYPE;
    private String IND_CLASS;
    private String REMARK;
    private String ITEM_CD;
    private String ITEM_NM;
    private String SPEC;
    private String BASIC_UNIT;
    private BigDecimal DLVY_QTY;
    private BigDecimal DLVY_ROLL;
    private BigDecimal SCRAP_QTY;
    private BigDecimal ITEM_PRICE;
    private BigDecimal AMT;
    private String LOT_NO;
    private String CUST_CD;
    private int CNT2;
}
