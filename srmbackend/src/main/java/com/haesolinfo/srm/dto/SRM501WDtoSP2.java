package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dto.pk.SRM501WDtoSP2PK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedStoredProcedureQuery;
import java.time.LocalDate;

@NamedStoredProcedureQuery(
        name = "SRM501WDtoSP2.USP_SRM_501W_QUERY2",
        procedureName = "USP_SRM_501W_QUERY2",
        resultClasses = SRM501WDtoSP2.class)
@Data
@Entity
@IdClass(SRM501WDtoSP2PK.class)
public class SRM501WDtoSP2 {
    @JsonProperty("GU") private String GU;
    @JsonProperty("CHK") private String CHK;
    @Id @JsonProperty("ITEM_CD") private String ITEM_CD;
    @JsonProperty("VALID_DT") private String VALID_DT;
    @Id @JsonProperty("FILE_SEQ") private String FILE_SEQ;
    @Id @JsonProperty("FILE_NO") private String FILE_NO;
    @JsonProperty("FILE_NAME") private String FILE_NAME;
    @JsonProperty("FILE_EXTENSION") private String FILE_EXTENSION;
    @JsonProperty("FILE_IMAGE") private String FILE_IMAGE;
    @JsonProperty("DOWN") private String DOWN;
    @JsonProperty("DEL") private String DEL;
    @JsonProperty("OPEN_FILE") private String OPEN_FILE;

}
