package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.XM102WDto;
import com.haesolinfo.srm.repository.XM102WRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class XM102WService {

    private final XM102WRepository xm102WRepository;

    public List<XM102WDto> findMenuList(String divCd, String menuId){
        return xm102WRepository.findList(divCd, menuId);
    }
}
