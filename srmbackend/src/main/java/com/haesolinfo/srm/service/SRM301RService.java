package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.SRM301RDto;
import com.haesolinfo.srm.repository.SRM301RRepository;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class SRM301RService {
    private final SRM301RRepository srm301RRepository;

    public List<SRM301RDto> findList(SRM100RVO vo){
        return srm301RRepository.findList(vo);
    }
}
