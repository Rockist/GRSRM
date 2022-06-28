package com.haesolinfo.srm.dto.srm501w;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.srm501w.SRM501WDtoSP1PK;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;


@NamedStoredProcedureQuery(
        name = "SRM501WDtoSP1.USP_SRM_501W_QUERY1",
        procedureName = "USP_SRM_501W_QUERY1",
        resultClasses = SRM501WDtoSP1.class)
@Data
@Entity
@IdClass(SRM501WDtoSP1PK.class)
public class SRM501WDtoSP1 {
    @Id @JsonProperty("CUST_CD") private String CUST_CD;
    @JsonProperty("CUST_NM") private String CUST_NM;
    @Id @JsonProperty("ITEM_CD") private String ITEM_CD;
    @JsonProperty("ITEM_NM") private String ITEM_NM;
}
