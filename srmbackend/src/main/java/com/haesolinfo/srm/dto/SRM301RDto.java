package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM301RDtoPK;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@Entity
@Data
@IdClass(SRM301RDtoPK.class)
@NamedStoredProcedureQuery(
        name = "SRM301RDto.USP_SRM_301R_QUERY",
        procedureName = "USP_SRM_301R_QUERY",
        resultClasses = SRM301RDto.class)
public class SRM301RDto {
    @JsonProperty("PUR_ORDER_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate PUR_ORDER_DT;
    @Id @JsonProperty("PUR_ORDER_NO")
    private String PUR_ORDER_NO;
    @Id @JsonProperty("PUR_ORDER_SEQ")
    private String PUR_ORDER_SEQ;
    @JsonProperty("PUR_STATUS")private String PUR_STATUS;
    @JsonProperty("SUPPLY_TYPE")private String SUPPLY_TYPE;
    @JsonProperty("ITEM_CD")private String ITEM_CD;
    @JsonProperty("ITEM_NM")private String ITEM_NM;
    @JsonProperty("SPEC")private String SPEC;
    @JsonProperty("THICK")private String THICK;
    @JsonProperty("WIDTH")private String WIDTH;
    @JsonProperty("LENGTH")private String LENGTH;
    @JsonProperty("BASIC_UNIT")private String BASIC_UNIT;
    @JsonProperty("PUR_QTY")private String PUR_QTY;
    @JsonProperty("PUR_QTY_ROLL")private String PUR_QTY_ROLL;
    @JsonProperty("SL_CD")private String SL_CD;
    @JsonProperty("te IN_DT")private LocalDate IN_DT;
    @JsonProperty("IN_NO")private String IN_NO;
    @JsonProperty("IN_SEQ")private String IN_SEQ;
    @JsonProperty("IN_QTY")private Double IN_QTY;
    @JsonProperty("IN_QTY_ROLL")private String IN_QTY_ROLL;
    @JsonProperty("MAKER_LOT_NO")private String MAKER_LOT_NO;
    @JsonProperty("PUR_PRICE")private Double PUR_PRICE;
    @JsonProperty("IN_AMT")private Double IN_AMT;
    @JsonProperty("PUR_CUST_CD")private String PUR_CUST_CD;
    @JsonProperty("BP_NM")private String BP_NM;

}
