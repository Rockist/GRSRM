package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM202WDtoPK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM202WDto.USP_SRM_202W_QUERY",
        procedureName = "USP_SRM_202W_QUERY",
        resultClasses = SRM202WDto.class)
@Data
@Entity
@IdClass(SRM202WDtoPK.class)
public class SRM202WDto {

    @JsonProperty("GU")private String GU;
    @JsonProperty("CHK")private Boolean CHK;                                     // 선택(기본 : False)
    @JsonProperty("PRINT_QTY")private Integer PRINT_QTY;                        // 출력매수
    @Id @JsonProperty("DLVY_NO")private String DLVY_NO;                      // 납품번호
    @Id @JsonProperty("DLVY_SEQ")private String  DLVY_SEQ;                    // 순번
    @JsonProperty("DLVY_DT")private LocalDate DLVY_DT;                          // 납품일
    @JsonProperty("PUR_ORDER_NO")private String PUR_ORDER_NO;                   // 발주번호
    @JsonProperty("ITEM_CD")private String ITEM_CD;                             // 품목코드
    @JsonProperty("ITEM_NM")private String ITEM_NM;                             // 원단사모델명
    @JsonProperty("THICK")private String THICK;                                 // 두께
    @JsonProperty("WIDTH")private String WIDTH;                                 // 폭
    @JsonProperty("LENGTH")private String LENGTH;                               // 길이
    @JsonProperty("BASIC_UNIT")private String BASIC_UNIT;                       // 단위
    @JsonProperty("PUR_QTY")private Double PUR_QTY;                             // 발주량
    @JsonProperty("PUR_QTY_ROLL")private Double PUR_QTY_ROLL;                   // 발주ROLL
    @JsonProperty("DLVY_QTY")private Double DLVY_QTY;                           // 납품량
    @JsonProperty("DLVY_ROLL")private Double DLVY_ROLL;                         // 납품ROLL
    @JsonProperty("MAKER_LOT_NO")private String MAKER_LOT_NO;                   // 메이커LOT번호
    @JsonProperty("PRINT_YN")private String PRINT_YN;                           // 발행여부
    @JsonProperty("PUR_CUST_CD")private String PUR_CUST_CD;                     // 거래처코드
    @JsonProperty("BP_NM")private String BP_NM;                                 //

}
