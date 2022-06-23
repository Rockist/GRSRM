package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SRM201WDto {
    @JsonProperty("Grid1")
    private List<SRM201WDtoSP1> sp1List;
    @JsonProperty("Grid2")
    private List<SRM201WDtoSP2> sp2List;

    public void crateSRM201WDto(List<SRM201WDtoSP1> sp1List, List<SRM201WDtoSP2> sp2List){
        this.sp1List = sp1List;
        this.sp2List = sp2List;
    }
}
