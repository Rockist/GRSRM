package com.haesolinfo.srm.dto.popup;

import java.util.List;

public interface PopupDtoInterface {
    public boolean filter(String word);

    public List<PopupHeader> getHeaderList();

    default PopupHeader getHeader(String header, String name) {
        return new PopupHeader(header, name);
    }
}
