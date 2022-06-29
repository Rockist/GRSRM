package com.haesolinfo.srm.service;

import com.haesolinfo.srm.domain.BA_SUB_CD;
import com.haesolinfo.srm.dto.CmbItemsDto;
import com.haesolinfo.srm.dto.pk.UserQueryDto;
import com.haesolinfo.srm.repository.CmbItemsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CmbItemsService {
    private final CmbItemsRepository cmbItemsRepository;

    public List<CmbItemsDto> findCmbList(String str){
        List<BA_SUB_CD> list = cmbItemsRepository.findAllWithSubCode(str);

        List<CmbItemsDto> items = list.stream().map(i -> new CmbItemsDto(i)).collect(Collectors.toList());
        return items;
    }

    public List<CmbItemsDto> findCmbCmbList(String str) {
        List<BA_SUB_CD> list = cmbItemsRepository.findSubCode(str);
        return list.stream().map(data -> new CmbItemsDto(data.getSUB_CD(), data.getSUB_NM())).collect(Collectors.toList());
    }

    public List<UserQueryDto> findUserQueryList(String query) {
        return cmbItemsRepository.findAllWithUserQuery(query).stream().map(c -> new UserQueryDto(c)).collect(Collectors.toList());
    }
}
