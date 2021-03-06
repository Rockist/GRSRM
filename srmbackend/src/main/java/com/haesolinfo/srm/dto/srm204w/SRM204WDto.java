package com.haesolinfo.srm.dto.srm204w;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SRM204WDto {
    @JsonProperty("Grid1")
    private List<SRM204WDtoSP1> sp1List;
    @JsonProperty("Grid2")
    private List<SRM204WDtoSP2> sp2List;

    public void crateSRM204WDto(List<SRM204WDtoSP1> sp1List, List<SRM204WDtoSP2> sp2List){
        this.sp1List = sp1List;
        this.sp2List = sp2List;
    }
}
