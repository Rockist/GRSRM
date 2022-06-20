package com.haesolinfo.srm.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SRM202WVO {
    private String divCd;
    private String purCustCd;
    private LocalDate dtFrom;
    private LocalDate dtTo;
    private String userGroup;

}
