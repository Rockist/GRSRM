package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dao.SRM204WPreviewSpDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SRM204WPreviewSpDto {
    @Id
    @JsonProperty("CNT")private int CNT;
    @JsonProperty("GUBUN")private String GUBUN;
    @JsonProperty("GCNT")private int GCNT;
    @JsonProperty("DLVY_DT")private Date DLVY_DT;
    @JsonProperty("DLVY_NO")private String DLVY_NO;
    @JsonProperty("BP_RGIST_NO")private String BP_RGIST_NO;
    @JsonProperty("BP_NM")private String BP_NM;
    @JsonProperty("REPRE_NM")private String REPRE_NM;
    @JsonProperty("ADDR")private String ADDR;
    @JsonProperty("TEL_NO1")private String TEL_NO1;
    @JsonProperty("FAX_NO")private String FAX_NO;
    @JsonProperty("IND_TYPE")private String IND_TYPE;
    @JsonProperty("IND_CLASS")private String IND_CLASS;
    @JsonProperty("REMARK")private String REMARK;
    @JsonProperty("ITEM_CD")private String ITEM_CD;
    @JsonProperty("ITEM_NM")private String ITEM_NM;
    @JsonProperty("SPEC")private String SPEC;
    @JsonProperty("BASIC_UNIT")private String BASIC_UNIT;
    @JsonProperty("DLVY_QTY")private String DLVY_QTY;
    @JsonProperty("DLVY_ROLL")private String DLVY_ROLL;
    @JsonProperty("SCRAP_QTY")private String SCRAP_QTY;
    @JsonProperty("ITEM_PRICE")private String ITEM_PRICE;
    @JsonProperty("AMT")private String AMT;
    @JsonProperty("LOT_NO")private String LOT_NO;
    @JsonProperty("CUST_CD")private String CUST_CD;
    @JsonProperty("CNT2")private int CNT2;

    public SRM204WPreviewSpDto toDto(SRM204WPreviewSpDao dao, DecimalFormat format_1, DecimalFormat format_2) {
        setCNT(dao.getCNT());
        setGUBUN(dao.getGUBUN());
        setGCNT(dao.getGCNT());
        setDLVY_DT(dao.getDLVY_DT());
        setDLVY_NO(dao.getDLVY_NO());
        setBP_RGIST_NO(dao.getBP_RGIST_NO());
        setBP_NM(dao.getBP_NM());
        setREPRE_NM(dao.getREPRE_NM());
        setADDR(dao.getADDR());
        setTEL_NO1(dao.getTEL_NO1());
        setFAX_NO(dao.getFAX_NO());
        setIND_TYPE(dao.getIND_TYPE());
        setIND_CLASS(dao.getIND_CLASS());
        setREMARK(dao.getREMARK());
        setITEM_CD(dao.getITEM_CD());
        setITEM_NM(dao.getITEM_NM());
        setSPEC(dao.getSPEC());
        setBASIC_UNIT(dao.getBASIC_UNIT());
        setDLVY_QTY(format(format_2, dao.getDLVY_QTY()));
        setDLVY_ROLL(format(format_2, dao.getDLVY_ROLL()));
        setSCRAP_QTY(format(format_2, dao.getSCRAP_QTY()));
        setITEM_PRICE(format(format_1, dao.getITEM_PRICE()));
        setAMT(format(format_1, dao.getAMT()));
        setLOT_NO(dao.getLOT_NO());
        setCUST_CD(dao.getCUST_CD());
        setCNT2(dao.getCNT2());
        return this;
    }

    private String format(DecimalFormat format, BigDecimal data) {
        String result = format.format(data);
        return result.equals(".00") ? "0.00" : result;
    }
}
