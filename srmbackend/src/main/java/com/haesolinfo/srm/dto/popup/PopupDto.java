package com.haesolinfo.srm.dto.popup;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class PopupDto<T> {

    @JsonProperty("POPUP_LIST")
    private List<T> popupList;

    @JsonProperty("HEADER_LIST")
    private List<PopupHeader> headerList;
}
