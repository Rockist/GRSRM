package com.haesolinfo.srm.vo;

import com.haesolinfo.srm.dto.SRM302RDto;
import lombok.Data;

import java.util.List;

@Data
public class SRM302RSaveVO {
    private SRM100RVO vo;
    private List<SRM302RDto> dtoList;
}
