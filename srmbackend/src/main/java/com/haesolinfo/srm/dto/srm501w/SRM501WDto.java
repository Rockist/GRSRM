package com.haesolinfo.srm.dto.srm501w;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SRM501WDto {
    @JsonProperty("Grid1")
    private List<SRM501WDtoSP1> sp1List;

    @JsonProperty("Grid2")
    private List<SRM501WDtoSP2> sp2List;

    public void createSRM501WDto(List<SRM501WDtoSP1> list1, List<SRM501WDtoSP2> list2) {
        this.sp1List = list1;
        this.sp2List = list2;
    }
}
