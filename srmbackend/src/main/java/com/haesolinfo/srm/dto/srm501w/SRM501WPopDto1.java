package com.haesolinfo.srm.dto.srm501w;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.popup.PopupDtoInterface;
import com.haesolinfo.srm.dto.popup.PopupHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class SRM501WPopDto1 implements PopupDtoInterface {

    @JsonProperty("BP_CD")
    private String BP_CD;
    @JsonProperty("BP_NM")
    private String BP_NM;

    @Override
    public boolean filter(String word) {
        String tword = word.replace("\"", "");
        return tword.equals("") || this.BP_CD.contains(tword) || this.BP_NM.contains(tword);
    }
    @Override
    public List<PopupHeader> getHeaderList() {
        List<PopupHeader> headerList = new ArrayList<>();
        headerList.add(getHeader("거래처코드", "BP_CD"));
        headerList.add(getHeader("거래처명", "BP_NM"));
        return headerList;
    }
}
