package com.haesolinfo.srm.dto.popup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PopupHeader {
    @JsonProperty("header")
    private String header;

    @JsonProperty("name")
    private String name;
}
