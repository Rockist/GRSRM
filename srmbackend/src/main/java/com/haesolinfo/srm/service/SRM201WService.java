package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.srm201w.SRM201WDto;
import com.haesolinfo.srm.dto.srm201w.SRM201WDtoSP1;
import com.haesolinfo.srm.dto.srm201w.SRM201WDtoSP2;
import com.haesolinfo.srm.repository.SRM201WRepository;
import com.haesolinfo.srm.vo.SRM201WVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class SRM201WService {

    private final SRM201WRepository srm201WRepository;

    public SRM201WDto findList(SRM201WVO vo) {
        List<SRM201WDtoSP1> list1 = srm201WRepository.findList1(vo);
        List<SRM201WDtoSP2> list2 = srm201WRepository.findList2(vo);

        log.info("SRM201WDto list 2 : " + list2.toString());

        SRM201WDto result = new SRM201WDto();
        result.crateSRM201WDto(list1, list2);

        return result;
    }
}
