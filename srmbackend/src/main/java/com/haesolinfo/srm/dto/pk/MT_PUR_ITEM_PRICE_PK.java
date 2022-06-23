package com.haesolinfo.srm.dto.pk;


import lombok.Data;
import java.io.Serializable;

@Data
public class MT_PUR_ITEM_PRICE_PK implements Serializable {
    private String DIV_CD;
    private String PUR_CUST_CD;
    private String ITEM_CD;
    private String PUR_UNIT;
    private String PUR_COST_CD;
    private String VALID_FR_DT;
}
