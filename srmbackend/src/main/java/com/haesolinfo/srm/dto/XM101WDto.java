package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.XM101WDtoPK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "XM101WDto.SP_XM_101W_QUERY",
        procedureName = "SP_XM_101W_QUERY",
        resultClasses = XM101WDto.class)
@Data
@Entity
@IdClass(XM101WDtoPK.class)
public class XM101WDto {

    @JsonProperty("GU")private String GU;
    @Id @JsonProperty("P_MENU_ID")private String P_MENU_ID;                       // 상위메뉴ID
    @JsonProperty("P_MENU_NM")private String P_MENU_NM;                           // 상위메뉴명
    @Id @JsonProperty("P_MENU_TYPE")private String P_MENU_TYPE;                   // 상위메뉴타입
    @Id @JsonProperty("C_MENU_ID")private String  C_MENU_ID;                      // 메뉴ID
    @JsonProperty("C_MENU_NM")private String  C_MENU_NM;                          // 메뉴명
    @Id @JsonProperty("C_MENU_TYPE")private String C_MENU_TYPE;                   // 메뉴타입
    @JsonProperty("MENU_LVL")private String MENU_LVL;                             // 메뉴레벨
    @JsonProperty("MENU_SEQ")private String MENU_SEQ;                             // 메뉴순번
    @JsonProperty("USE_YN")private String USE_YN;                                 // 사용여부
    @JsonProperty("ICON_NO")private String ICON_NO;                               // 아이콘NO
    @JsonProperty("INSERT_ID")private String INSERT_ID;                           // 등록자
    @JsonProperty("INSERT_DT")private LocalDate INSERT_DT;                        // 등록일자
    @JsonProperty("UPDATE_ID")private String UPDATE_ID;                           // 수정자
    @JsonProperty("UPDATE_DT")private LocalDate UPDATE_DT;                        // 수정일자
    @JsonProperty("TEMP_CD1")private String TEMP_CD1;                             // 여유컬럼코드1
    @JsonProperty("TEMP_CD2")private String TEMP_CD2;                             // 여유컬럼코드2
    @JsonProperty("TEMP_CD3")private String TEMP_CD3;                             // 여유컬럼코드3
    @JsonProperty("TEMP_NO1")private Double TEMP_NO1;                             // 여유컬럼숫자1
    @JsonProperty("TEMP_NO2")private Double TEMP_NO2;                             // 여유컬럼숫자2
    @JsonProperty("TEMP_NO3")private Double TEMP_NO3;                             // 여유컬럼숫자3

}
