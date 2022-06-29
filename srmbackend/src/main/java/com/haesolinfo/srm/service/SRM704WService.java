package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.srm704w.SRM704WDto;
import com.haesolinfo.srm.repository.SRM704WRepository;
import com.haesolinfo.srm.vo.srm704w.SRM704WVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SRM704WService {

    private final SRM704WRepository srm704WRepository;

    public List<SRM704WDto> findList(SRM704WVo vo) {
        List<SRM704WDto> result = srm704WRepository.findList(vo);
        return result;
    }
}
