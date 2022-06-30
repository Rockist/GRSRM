package com.haesolinfo.srm.dto.srm705w;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
@NamedStoredProcedureQuery(
        name = "SRM705W.USP_SRM_705W_QUERY",
        procedureName = "USP_SRM_705W_QUERY",
        resultClasses = SRM705WDto.class)
public class SRM705WDto {
    @JsonProperty("GU")
    private String GU;
    @Id
    @JsonProperty("ORDER_NO")
    private String ORDER_NO;
    @JsonProperty("ORDER_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ORDER_DT;
    @JsonProperty("MAKER")
    private String MAKER;
    @JsonProperty("PUR_USER_ID")
    private String PUR_USER_ID;
    @JsonProperty("REQ_TYPE")
    private String REQ_TYPE;
    @JsonProperty("MOLD_CD")
    private String MOLD_CD;
    @JsonProperty("MOLD_NM")
    private String MOLD_NM;
    @JsonProperty("MOLD_CLASS")
    private String MOLD_CLASS;
    @JsonProperty("ITEM_CD")
    private String ITEM_CD;
    @JsonProperty("ITEM_NM")
    private String ITEM_NM;
    @JsonProperty("ROUT_NO")
    private String ROUT_NO;
    @JsonProperty("PROC_CD")
    private String PROC_CD;
    @JsonProperty("REQ_QTY")
    private int REQ_QTY;
    @JsonProperty("MOLD_TYPE")
    private String MOLD_TYPE;
    @JsonProperty("ORDER_QTY")
    private int ORDER_QTY;
    @JsonProperty("MOLD_PRICE")
    private BigDecimal MOLD_PRICE;
    @JsonProperty("MOLD_AMT")
    private BigDecimal MOLD_AMT;
    @JsonProperty("DLVY_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DLVY_DT;
    @JsonProperty("IN_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate IN_DATE;
    @JsonProperty("REMARK")
    private String REMARK;
    @JsonProperty("OFFER_STATE")
    private String OFFER_STATE;
    @JsonProperty("OFFER_FILE_NAME")
    private String OFFER_FILE_NAME;
    @JsonProperty("OFFER_FILE_EXTENSION")
    private String OFFER_FILE_EXTENSION;
    @JsonProperty("INSERT_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate INSERT_DT;
}
