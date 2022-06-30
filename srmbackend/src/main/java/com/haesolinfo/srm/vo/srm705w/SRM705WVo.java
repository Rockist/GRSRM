package com.haesolinfo.srm.vo.srm705w;

import lombok.Data;

import java.util.Date;

@Data
public class SRM705WVo {
    private String divCd;
    private Date orderDtFr;
    private Date orderDtTo;
    private String moldCd;
    private String moldNm;
}
