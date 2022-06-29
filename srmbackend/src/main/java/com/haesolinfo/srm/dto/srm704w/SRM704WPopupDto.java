package com.haesolinfo.srm.dto.srm704w;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dao.srm704w.SRM704WPopupDao;
import com.haesolinfo.srm.dto.CmbItemsDto;
import com.haesolinfo.srm.dto.popup.PopupDtoInterface;
import com.haesolinfo.srm.dto.popup.PopupHeader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Slf4j
@NoArgsConstructor
public class SRM704WPopupDto implements PopupDtoInterface {

    @Id
    @JsonProperty("ITEM_CD")
    private String ITEM_CD;
    @JsonProperty("ITEM_NM")
    private String ITEM_NM;
    @JsonProperty("SPEC")
    private String SPEC;
    @JsonProperty("ITEM_ACCT")
    private String ITEM_ACCT;
    @JsonProperty("ITEM_CLASS")
    private String ITEM_CLASS;
    @JsonProperty("UNIT")
    private String UNIT;
    @JsonProperty("WIDTH")
    private String WIDTH;
    @JsonProperty("BOM_YN")
    private String BOM_YN;


    @Override
    public List<PopupHeader> getHeaderList() {
        List<PopupHeader> headerList = new ArrayList<>();
        headerList.add(getHeader("품목코드", "ITEM_CD"));
        headerList.add(getHeader("품목명", "ITEM_NM"));
        headerList.add(getHeader("규격", "SPEC"));
        headerList.add(getHeader("품목계정", "ITEM_ACCT"));
        headerList.add(getHeader("품목분류", "ITEM_CLASS"));
        headerList.add(getHeader("단위", "UNIT"));
        headerList.add(getHeader("WIDTH", "WIDTH"));
        headerList.add(getHeader("BOM등록여부", "BOM_YN"));
        return headerList;
    }

    public SRM704WPopupDto mapping(SRM704WPopupDao dao, List<CmbItemsDto> cmbItemsDto) {
        this.ITEM_CD = dao.getITEM_CD();
        this.ITEM_NM = dao.getITEM_NM();
        this.SPEC = dao.getSPEC();
        this.ITEM_ACCT = dao.getITEM_ACCT();
        this.ITEM_ACCT = cmbItemsDto.stream()
                .filter(item -> item.getText().equals(dao.getITEM_ACCT())).findFirst().get().getValue();

        this.ITEM_CLASS = " ";
        this.UNIT = dao.getUNIT();
        this.WIDTH = dao.getWIDTH();
        this.BOM_YN = dao.getBOM_YN().equals("Y") ? "예" : "아니오";
        return this;
    }
}
