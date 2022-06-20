package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.SRM302RDto;
import com.haesolinfo.srm.repository.SRM302RRepository;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class SRM302RService {
    private final SRM302RRepository srm302RRepository;

    public List<SRM302RDto> findList(SRM100RVO vo){
        return srm302RRepository.findList(vo);
    }

    public void save(List<SRM302RDto> list) {
        srm302RRepository.save(list);
    }
}
