package com.haesolinfo.srm.dto.srm501w;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class SRM501WFileDto {
    private String DIV_CD;
    private String CUST_CD;
    private String ITEM_CD;
    private String FILE_NO;
    private byte[] FILE_IMAGE;
    private String FILE_NAME;
    private String FILE_EXTENSION;
    private String WIDTH;
    private String HEIGHT;
    private String INERT_ID;
    private String VALID_DT;
}