package com.haesolinfo.srm.dto.pk;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.domain.BA_BIZ_PARTNER;
import lombok.Data;

@Data
public class UserQueryDto {
    @JsonProperty("value")
    private String code;
    @JsonProperty("text")
    private String name;

    public UserQueryDto(BA_BIZ_PARTNER item) {
        code = item.getBP_CD();
        name = item.getBP_NM();
    }
}
