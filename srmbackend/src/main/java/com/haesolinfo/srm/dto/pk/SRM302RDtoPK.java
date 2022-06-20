package com.haesolinfo.srm.dto.pk;

import lombok.Data;

import java.io.Serializable;

@Data
public class SRM302RDtoPK implements Serializable {
    private String PUR_ORDER_NO;
    private String DLVY_NO;
    private Integer DLVY_SEQ;
}
