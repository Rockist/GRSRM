package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.SRM501WDto;
import com.haesolinfo.srm.dto.SRM501WDtoSP1;
import com.haesolinfo.srm.dto.SRM501WDtoSP2;
import com.haesolinfo.srm.repository.SRM501WRepository;
import com.haesolinfo.srm.vo.SRM501WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class SRM501WService {
    private final SRM501WRepository srm501WRepository;

    public SRM501WDto findList(SRM501WVo vo) {
        List<SRM501WDtoSP1> list1 = srm501WRepository.findList1(vo);

        SRM501WDtoSP1 dtoSP1 = list1.get(1);

        log.info("SRM501WService dtoSP1");

        SRM501WVo voSP2 = new SRM501WVo();
        voSP2.setDivCd(vo.getDivCd());
        voSP2.setCustCd(dtoSP1.getCUST_CD());
        voSP2.setItemCd(dtoSP1.getITEM_CD());

        log.info("voSP2 : " + voSP2.toString());

        List<SRM501WDtoSP2> list2 = srm501WRepository.findList2(voSP2);

        SRM501WDto dto = new SRM501WDto();
        dto.createSRM501WDto(list1, list2);
        return dto;
    }

    public SRM501WDto findList2(SRM501WVo vo) {
        List<SRM501WDtoSP2> list2 = srm501WRepository.findList2(vo);

        SRM501WDto dto = new SRM501WDto();
        dto.createSRM501WDto(null, list2);

        return dto;
    }
}
