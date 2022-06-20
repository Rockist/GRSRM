package com.haesolinfo.srm.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SRM201WVO {

    //공통
    private String divCd;
    private String purCustCd;
    private String userGroup;

    //SP1
    private LocalDate dtFrom;
    private LocalDate dtTo;
    private String dtGbn;
    private String npYn;

    //SP2용
    private LocalDate dlvyFr;             //납품기간
    private LocalDate dlvyTo;             //납품기간
    private String dlvyNo;             //납품번호
}
