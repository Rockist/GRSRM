package com.haesolinfo.srm.dto.pk;

import lombok.Data;

import java.io.Serializable;

@Data
public class BASUBCDPK implements Serializable {
    private String MAIN_CD;
    private String SUB_CD;
}
