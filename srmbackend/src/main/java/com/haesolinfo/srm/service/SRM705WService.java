package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.srm705w.SRM705WDto;
import com.haesolinfo.srm.repository.SRM705WRepository;
import com.haesolinfo.srm.vo.srm705w.SRM705WVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SRM705WService {

    private final SRM705WRepository srm705WRepository;

    public List<SRM705WDto> findList(SRM705WVo vo) {
        List<SRM705WDto> result = srm705WRepository.findList(vo);
        return result;
    }
}
