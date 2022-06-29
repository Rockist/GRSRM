package com.haesolinfo.srm.dto.popup;

import java.util.List;

public interface PopupDtoInterface {
    default boolean filter(String word) { return false; }

    public List<PopupHeader> getHeaderList();

    default PopupHeader getHeader(String header, String name) {
        return new PopupHeader(header, name);
    }
}
