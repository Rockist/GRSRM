package com.haesolinfo.srm.dto.srm204w;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SRM204WLabelSaveDto {
    @Id
    @JsonProperty("I_VALUE")private int I_VALUE;
    @JsonProperty("MSG_CD") private String MSG_CD;
    @JsonProperty("MSG_DETAIL")private String MSG_DETAIL;
}
