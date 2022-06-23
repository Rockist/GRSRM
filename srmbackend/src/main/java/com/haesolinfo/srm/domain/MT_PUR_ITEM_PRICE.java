package com.haesolinfo.srm.domain;

import com.haesolinfo.srm.dto.pk.BASUBCDPK;
import com.haesolinfo.srm.dto.pk.MT_PUR_ITEM_PRICE_PK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;

@Entity
@Data
@IdClass(MT_PUR_ITEM_PRICE_PK.class)
public class MT_PUR_ITEM_PRICE {
    @Id
    private String DIV_CD;
    @Id
    private String PUR_CUST_CD;
    @Id
    private String ITEM_CD;
    @Id
    private String PUR_UNIT;
    @Id
    private String PUR_COST_CD;
    @Id
    private String VALID_FR_DT;
    private String FILE_YN;
    private String ITEM_PRICE;
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
    private String GUBUN;
}
