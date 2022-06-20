package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.SRM202WDto;
import com.haesolinfo.srm.repository.SRM202WRepository;
import com.haesolinfo.srm.vo.SRM202WVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class SRM202WService {
    private final SRM202WRepository srm202WRepository;

    public List<SRM202WDto> findList(SRM202WVO vo) {
        return srm202WRepository.findList(vo);
    }
}
