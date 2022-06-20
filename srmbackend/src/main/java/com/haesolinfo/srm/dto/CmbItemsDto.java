package com.haesolinfo.srm.dto;

import com.haesolinfo.srm.domain.BA_SUB_CD;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class CmbItemsDto {
    @Column(name = "SUB_NM")
    private String text;
    @Id
    @Column(name = "SUB_CD")
    private String value;

    public CmbItemsDto(BA_SUB_CD item){
        text = item.getSUB_NM();
        value = item.getSUB_CD();
    }
}
