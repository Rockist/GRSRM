package com.haesolinfo.srm.dto.pk.popup;

import lombok.Data;
import java.io.Serializable;

@Data
public class PUR_CUST_CD_JOIN_PK implements Serializable {
    private String PUR_CUST_CD;
    private String BP_NM;
    private String ITEM_CD;
    private String ITEM_NM;
    private String SPEC;
}
