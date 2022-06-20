package com.haesolinfo.srm.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class XM101WVo {
    private String divCd;
    @Column(columnDefinition = "NVARCHAR(20) default ''")
    private String pMenuId;
    private String useYN;
}
