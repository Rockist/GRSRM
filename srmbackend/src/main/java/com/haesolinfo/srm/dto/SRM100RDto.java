package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM100RDtoPK;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM100RDto.USP_SRM_100R_QUERY",
        procedureName = "USP_SRM_100R_QUERY",
        resultClasses = SRM100RDto.class)
@Data
@Entity
@IdClass(SRM100RDtoPK.class)
public class SRM100RDto {

    @JsonProperty("PUR_ORDER_DT")
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate PUR_ORDER_DT;

    @Id @JsonProperty("PUR_ORDER_NO")
    private String PUR_ORDER_NO;
    @Id @JsonProperty("PUR_ORDER_SEQ")
    private String PUR_ORDER_SEQ;

    @JsonProperty("PUR_CUST_CD")
    private String PUR_CUST_CD;

    @JsonProperty("PUR_STATUS")
    private String PUR_STATUS;
    @JsonProperty("SUPPLY_TYPE")
    private String SUPPLY_TYPE;
    @JsonProperty("ITEM_CD")
    private String ITEM_CD;
    @JsonProperty("ITEM_NM")
    private String ITEM_NM;
    @JsonProperty("SPEC")
    private String SPEC;
    @JsonProperty("THICK")
    private String THICK;
    @JsonProperty("WIDTH")
    private String WIDTH;
    @JsonProperty("LENGTH")
    private String LENGTH;
    @JsonProperty("DLVY_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DLVY_DT;
    @JsonProperty("PUR_QTY")
    private Double PUR_QTY;
    @JsonProperty("PUR_QTY_ROLL")
    private String PUR_QTY_ROLL;
    @JsonProperty("PUR_UNIT")
    private String PUR_UNIT;
    @JsonProperty("PUR_COST_CD")
    private String PUR_COST_CD;
    @JsonProperty("PUR_PRICE")
    private Double PUR_PRICE;
    @JsonProperty("PUR_AMT")
    private Double PUR_AMT;
    @JsonProperty("IN_QTY")
    private Double IN_QTY;
    @JsonProperty("IN_QTY_ROLL")
    private String IN_QTY_ROLL;
    @JsonProperty("IN_AMT")
    private Double IN_AMT;
    @JsonProperty("NOT_IN_QTY")
    private Double NOT_IN_QTY;
    @JsonProperty("NOT_IN_QTY_ROLL")
    private Double NOT_IN_QTY_ROLL;
    @JsonProperty("REMARK")
    private String REMARK;

    @JsonProperty("BP_NM")
    private String BP_NM;
    @JsonProperty("PUR_USER_ID")
    private String PUR_USER_ID;
    @JsonProperty("PLANT_TYPE")
    private String PLANT_TYPE;

}

