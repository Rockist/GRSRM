package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.XM102WDtoPK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;

@NamedStoredProcedureQuery(
        name = "XM102W.SP_XM_102W_QUERY_01",
        procedureName = "SP_XM_102W_QUERY_01",
        resultClasses = XM102WDto.class
        /*parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class),
        }*/)
@Entity
@Data
@IdClass(XM102WDtoPK.class)
public class XM102WDto {
    @JsonProperty("GU")
    private String GU;

    @Id @JsonProperty("DIV_CD")
    private String DIV_CD;
    @Id @JsonProperty("MENU_ID")
    private String MENU_ID;
    @Id @JsonProperty("MENU_TAB_NO")
    private String MENU_TAB_NO;
    @Id @JsonProperty("COL_ID")
    private String COL_ID;


    @JsonProperty("MENU_NM")
    private String MENU_NM;
    @JsonProperty("COL_NO")
    private String COL_NO;



    @JsonProperty("COL_NM")
    private String COL_NM;
    @JsonProperty("COL_WIDTH")
    private String COL_WIDTH;
    @JsonProperty("COL_TYPE")
    private String COL_TYPE;
    @JsonProperty("COL_FIXED")
    private String COL_FIXED;
    @JsonProperty("COL_VA")
    private String COL_VA;
    @JsonProperty("COL_HA")
    private String COL_HA;
    @JsonProperty("COL_EDIT")
    private String COL_EDIT;
    @JsonProperty("COL_HIDDEN")
    private String COL_HIDDEN;
    @JsonProperty("COL_EDITTYPE")
    private String COL_EDITTYPE;
    @JsonProperty("COL_SUM")
    private String COL_SUM;
    @JsonProperty("COL_MERGE")
    private String COL_MERGE;
    @JsonProperty("COL_H_P1")
    private String COL_H_P1;
    @JsonProperty("COL_H_P2")
    private String COL_H_P2;
    @JsonProperty("COL_MCD")
    private String COL_MCD;
    @JsonProperty("COL_SQL")
    private String COL_SQL;
    @JsonProperty("COL_PK")
    private String COL_PK;
    @JsonProperty("COL_REQ")
    private String COL_REQ;
    @JsonProperty("INSERT_ID")
    private String INSERT_ID;
    @JsonProperty("INSERT_DT")
    private String INSERT_DT;
    @JsonProperty("UPDATE_ID")
    private String UPDATE_ID;
    @JsonProperty("UPDATE_DT")
    private String UPDATE_DT;
    @JsonProperty("TEMP_CD1")
    private String TEMP_CD1;
    @JsonProperty("TEMP_NO1")
    private String TEMP_NO1;
}
