package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM204WDtoSP1PK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM204WDtoSP1.USP_SRM_204W_QUERY1",
        procedureName = "USP_SRM_204W_QUERY1",
        resultClasses = SRM204WDtoSP1.class)
@Data
@Entity
@IdClass(SRM204WDtoSP1PK.class)
public class SRM204WDtoSP1 {
    @JsonProperty("CHK") private boolean CHK;
    @Id @JsonProperty("DLVY_NO")private String DLVY_NO;                 // 발주번호
    @Id @JsonProperty("DLVY_DT")private LocalDate DLVY_DT;              // 발주번호순번
    @Id @JsonProperty("PUR_CUST_CD")private String PUR_CUST_CD;         // 거래처코드
    @JsonProperty("DLVY_QTY") private Double DLVY_QTY;                  // 납품량
    @JsonProperty("DDLVY_ROLL") private Double DDLVY_ROLL;                // 납품롤
    @JsonProperty("SCRAP_QTY") private Double SCRAP_QTY;                // 스크랩 수량
    @JsonProperty("AMT") private Double AMT;                            // 금액
    @JsonProperty("RECEIPT_YN") private String RECEIPT_YN;              // 출력여부
    @JsonProperty("IN_YN") private String IN_YN;                        // 입고여부
    @JsonProperty("BP_NM") private String BP_NM;                        //
    @JsonProperty("PUR_USER_NM") private String PUR_USER_NM;            // 담당자
}
