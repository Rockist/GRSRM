package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM201WDtoSP2PK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM201WDtoSP2.USP_SRM_201W_QUERY2",
        procedureName = "USP_SRM_201W_QUERY2",
        resultClasses = SRM201WDtoSP2.class)
@Data
@Entity
@IdClass(SRM201WDtoSP2PK.class)
public class SRM201WDtoSP2 {
    @JsonProperty("GU")private String GU;
    @JsonProperty("CUST_CD")private String CUST_CD;                             // 거래처코드
    @JsonProperty("DLVY_DT")private LocalDate DLVY_DT;                          // 납기일자
    @JsonProperty("MAKE_DT")private LocalDate MAKE_DT;                          // 제조일자
    @JsonProperty("VALID_TO_DT")private LocalDate VALID_TO_DT;                  // 유효일자
    @Id @JsonProperty("DLVY_NO")private String DLVY_NO;                      // 납품번호
    @Id @JsonProperty("DLVY_SEQ")private String DLVY_SEQ;                    // 순번
    @JsonProperty("SUPPLY_TYPE") private String SUPPLY_TYPE;                    // 개발/양산 구분
    @JsonProperty("ITEM_CD")private String ITEM_CD;                             // 품목코드
    @JsonProperty("ITEM_NM")private String ITEM_NM;                             // 원단사모델명
    @JsonProperty("THICK")private String THICK;                                 // 두께
    @JsonProperty("WIDTH")private String WIDTH;                                 // 폭
    @JsonProperty("LENGTH")private String LENGTH;                               // 길이
    @JsonProperty("BASIC_UNIT")private String BASIC_UNIT;                       // 단위
    @JsonProperty("ITEM_PRICE")private Double ITEM_PRICE;                       // 단가
    @JsonProperty("EXCHANGE_RATE")private Double EXCHANGE_RATE;                 //
    @JsonProperty("IN_AMT")private Double IN_AMT;                               // 공급금액
    @JsonProperty("AMT_RATE")private Double AMT_RATE;                           // 공급금액(한화)
    @JsonProperty("PUR_QTY")private Double PUR_QTY;                             // 발주량
    @JsonProperty("PUR_QTY_ROLL")private Double PUR_QTY_ROLL;                   // 발주ROLL
    @JsonProperty("DLVY_QTY")private Double DLVY_QTY;                           // 납품량
    @JsonProperty("DLVY_ROLL")private Double DLVY_ROLL;                         // 납품ROLL
    @JsonProperty("SCRAP_QTY")private Double SCRAP_QTY;                         // 스크랩 수량
    @JsonProperty("MAKER_LOT_NO")private String MAKER_LOT_NO;                   // 원단LOT번호
    @JsonProperty("REMARK")private String REMARK;                               // 비고
    @JsonProperty("PUR_ORDER_NO")private String PUR_ORDER_NO;                   // 발주번호
    @JsonProperty("PUR_ORDER_SEQ")private String PUR_ORDER_SEQ;              // 발주번호순번

}
