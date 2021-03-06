package com.haesolinfo.srm.dto.srm704w;


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
        name = "SRM704W.USP_PD_703W_QUERY2",
        procedureName = "USP_PD_703W_QUERY2",
        resultClasses = SRM704WDto.class)
public class SRM704WDto {
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
    @JsonProperty("DRAW_NO")
    private String DRAW_NO;
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
}
