package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.haesolinfo.srm.config.ForceNullDoubleSerializer;
import com.haesolinfo.srm.dto.pk.SRM204WDtoSP2PK;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM204WDtoSP2.USP_SRM_204W_QUERY2",
        procedureName = "USP_SRM_204W_QUERY2",
        resultClasses = SRM204WDtoSP2.class)
@Data
@Entity
@IdClass(SRM204WDtoSP2PK.class)
public class SRM204WDtoSP2 {
    @Id @JsonProperty("DLVY_NO")private String DLVY_NO;                 // 납품번호
    @Id @JsonProperty("DLVY_SEQ")private String DLVY_SEQ;               // 순번
    @JsonProperty("DLVY_DT")private LocalDate DLVY_DT;                  // 납품일자
    @Id @JsonProperty("PUR_ORDER_NO")private String PUR_ORDER_NO;       // 발주번호
    @Id @JsonProperty("ITEM_CD")private String ITEM_CD;                 // 품목코드
    @Id @JsonProperty("ITEM_NM")private String ITEM_NM;                 // 원단사모델명
    @JsonProperty("THICK") private String THICK;                        // 두께

    @JsonProperty("WIDTH") private Double WIDTH;                        // 폭
    @JsonProperty("LENGTH") private Double LENGTH;                      // 길이
    @JsonProperty("BASIC_UNIT") private String BASIC_UNIT;              // 단위
    @JsonProperty("DLVY_QTY") private Double DLVY_QTY;                  // 납품량
    @JsonProperty("DLVY_ROLL") private Double DLVY_ROLL;                // 납품롤
    @JsonProperty("SCRAP_QTY") private Double SCRAP_QTY;                // 스크랩 수량
    @JsonProperty("MAKER_LOT_NO") private String MAKER_LOT_NO;          // 메이커LOT번호
    @JsonProperty("PUR_PRICE") private Double PUR_PRICE;                // 단가
    @JsonProperty("AMT") private Double AMT;                            // 금액
    @JsonProperty("SHIP_RPT") private String SHIP_RPT;                  // 출하성적서
    @JsonProperty("RPT_YN") private String RPT_YN;                      // 출력여부
}
