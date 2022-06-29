package com.haesolinfo.srm.vo.srm704w;

import lombok.Data;

import java.util.Date;

@Data
public class SRM704WVo {
    private String divCd;
    private Date orderDtFr;
    private Date orderDtTo;
    private String itemCd;
    private String moldType;
    private String moldClass;
}
