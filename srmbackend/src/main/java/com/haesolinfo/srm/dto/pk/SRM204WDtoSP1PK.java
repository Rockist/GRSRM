package com.haesolinfo.srm.dto.pk;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class SRM204WDtoSP1PK implements Serializable {
    private String DLVY_NO;
    private LocalDate DLVY_DT;
    private String PUR_CUST_CD;
}
