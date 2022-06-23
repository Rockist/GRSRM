package com.haesolinfo.srm.dto.popup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SRM501WPopDto2 implements PopupDtoInterface {
    @JsonProperty("BP_CD")
    private String PUR_CUST_CD;
    @JsonProperty("BP_NM")
    private String BP_NM;
    @JsonProperty("ITEM_CD")
    private String ITEM_CD;
    @JsonProperty("ITEM_NM")
    private String ITEM_NM;
    @JsonProperty("SPEC")
    private String SPEC;

    public SRM501WPopDto2(String PUR_CUST_CD, String BP_NM, String ITEM_CD, String ITEM_NM) {
        this.PUR_CUST_CD = PUR_CUST_CD;
        this.BP_NM = BP_NM;
        this.ITEM_CD = ITEM_CD;
        this.ITEM_NM = ITEM_NM;
    }

    @Override
    public boolean filter(String word) {
        String tword = word.replace("\"", "");
        return tword.equals("") || PUR_CUST_CD.contains(tword) || BP_NM.contains(tword) || ITEM_CD.contains(tword);
    }

    @Override
    public List<PopupHeader> getHeaderList() {
        List<PopupHeader> headerList = new ArrayList<>();
        headerList.add(getHeader("거래처코드", "BP_CD"));
        headerList.add(getHeader("거래처명", "BP_NM"));
        headerList.add(getHeader("아이탬코드", "ITEM_CD"));
        headerList.add(getHeader("아이탬명", "ITEM_NM"));
        return headerList;
    }
}