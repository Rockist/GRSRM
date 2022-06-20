package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.SRM100RDto;
import com.haesolinfo.srm.vo.SRM100RVO;
import com.haesolinfo.srm.repository.SRM100RRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class SRM100RService {

    private final SRM100RRepository srm100RRepository;

    public List<SRM100RDto> findList(SRM100RVO vo){
        return srm100RRepository.findList(vo);
    }
}
