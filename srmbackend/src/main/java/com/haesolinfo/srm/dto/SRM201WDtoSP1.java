package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM201WDtoSP1PK;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM201WDtoSP1.USP_SRM_201W_QUERY1",
        procedureName = "USP_SRM_201W_QUERY1",
        resultClasses = SRM201WDtoSP1.class)
@Data
@Entity
@IdClass(SRM201WDtoSP1PK.class)
public class SRM201WDtoSP1 {

    @JsonProperty("GU")private String GU;
    @JsonProperty("PUR_ORDER_DT")
    @DateTimeFormat(pattern = "yyyy-MM-dd")private LocalDate PUR_ORDER_DT;      // 발주일
    @Id @JsonProperty("PUR_ORDER_NO")private String PUR_ORDER_NO;               // 발주번호
    @Id @JsonProperty("PUR_ORDER_SEQ")private String PUR_ORDER_SEQ;              // 발주번호순번
    @JsonProperty("PUR_STATUS")private String PUR_STATUS;                     // 발주상태
    @JsonProperty("SUPPLY_TYPE") private String SUPPLY_TYPE;                    // 개발/양산 구분
    @JsonProperty("ITEM_CD")private String ITEM_CD;                             // 품목코드
    @JsonProperty("ITEM_NM")private String ITEM_NM;                             // 원단사모델명
    @JsonProperty("THICK")private String THICK;                                 // 두께
    @JsonProperty("WIDTH")private String WIDTH;                                 // 폭
    @JsonProperty("LENGTH")private String LENGTH;                               // 길이
    @JsonProperty("DLVY_DT")private LocalDate DLVY_DT;                          // 납기일자
    @JsonProperty("MAKE_DT")private String MAKE_DT;                          // 제조일자
    @JsonProperty("VALID_TO_DT")private String VALID_TO_DT;                  // 유효일자
    @JsonProperty("IN_DT")private LocalDate IN_DT;                              // 납품일자
    @JsonProperty("ITEM_PRICE")private Double ITEM_PRICE;                       // 단가
    @JsonProperty("PUR_COST_CD")private String PUR_COST_CD;                     // 통화
    @JsonProperty("PUR_UNIT")private String PUR_UNIT;                           // 발주단위
    @JsonProperty("PUR_QTY")private Double PUR_QTY;                             // 발주량
    @JsonProperty("PUR_QTY_ROLL")private Double PUR_QTY_ROLL;                   // 발주ROLL
    @JsonProperty("NOT_IN_QTY")private Double NOT_IN_QTY;                       // 미입고
    @JsonProperty("NOT_IN_QTY_ROLL")private Double NOT_IN_QTY_ROLL;             // 미입고ROLL
    @JsonProperty("DLVY_QTY")private Double DLVY_QTY;                           // 납품량
    @JsonProperty("DLVY_ROLL")private Double DLVY_ROLL;                         // 납품ROLL
    @JsonProperty("SCRAP_QTY")private Double SCRAP_QTY;                         // 스크랩 수량
    @JsonProperty("MAKER_LOT_NO")private String MAKER_LOT_NO;                   // 메이커LOT번호
    @JsonProperty("REMARK")private String REMARK;                               // 비고
    @JsonProperty("PUR_CUST_CD")private String PUR_CUST_CD;                     // 거래처코드
    @JsonProperty("BP_NM")private String BP_NM;                                 // 거래처명
    @JsonProperty("PUR_USER_ID")private String PUR_USER_ID;                     // 발주자명
    @JsonProperty("PLANT_TYPE")private String PLANT_TYPE;

}
