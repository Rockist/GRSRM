package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM302RDtoPK;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@Entity
@Data
@IdClass(SRM302RDtoPK.class)
@NamedStoredProcedureQuery(
        name = "SRM302RDto.USP_SRM_302R_QUERY",
        procedureName = "USP_SRM_302R_QUERY",
        resultClasses = SRM302RDto.class)
public class SRM302RDto {

    @JsonProperty("GU")private String GU;
    @JsonProperty("IN_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate IN_DT;
    @Id @JsonProperty("PUR_ORDER_NO")private String PUR_ORDER_NO;
    @Id @JsonProperty("DLVY_NO")private String DLVY_NO;
    @Id @JsonProperty("DLVY_SEQ")private Integer DLVY_SEQ;
    @JsonProperty("ITEM_CD")private String ITEM_CD;
    @JsonProperty("ITEM_NM")private String ITEM_NM;
    @JsonProperty("SPEC")private String SPEC;
    @JsonProperty("THICK")private String THICK;
    @JsonProperty("WIDTH")private String WIDTH;
    @JsonProperty("LENGTH")private String LENGTH;
    @JsonProperty("BASIC_UNIT")private String BASIC_UNIT;
    @JsonProperty("PUR_QTY")private Double PUR_QTY;
    @JsonProperty("PUR_QTY_ROLL")private Double PUR_QTY_ROLL;
    @JsonProperty("IN_QTY")private Double IN_QTY;
    @JsonProperty("IN_QTY_ROLL")private Double IN_QTY_ROLL;
    @JsonProperty("SCRAP_QTY")private Double SCRAP_QTY;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @JsonProperty("PUR_PRICE")private Double PUR_PRICE;
    @JsonProperty("IN_AMT")
    @NumberFormat(style = NumberFormat.Style.NUMBER)private Double IN_AMT;
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    @JsonProperty("EX_AMT")private Double EX_AMT;
    @JsonProperty("PUR_CUST_CD")private String PUR_CUST_CD;
    @JsonProperty("BP_NM")private String BP_NM;
    @JsonProperty("CFM_YN")private String CFM_YN;
    @JsonProperty("CFM_USER")private String CFM_USER;

}
