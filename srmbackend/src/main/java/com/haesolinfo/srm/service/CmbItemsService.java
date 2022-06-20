package com.haesolinfo.srm.service;

import com.haesolinfo.srm.domain.BA_SUB_CD;
import com.haesolinfo.srm.dto.CmbItemsDto;
import com.haesolinfo.srm.dto.pk.UserQueryDto;
import com.haesolinfo.srm.repository.CmbItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CmbItemsService {
    private final CmbItemsRepository cmbItemsRepository;

    public List<CmbItemsDto> findCmbList(String str){
        List<BA_SUB_CD> list = cmbItemsRepository.findAllWithSubCode(str);
        List<CmbItemsDto> items = list.stream().map(i -> new CmbItemsDto(i)).collect(Collectors.toList());
        return items;
    }

    public List<UserQueryDto> findUserQueryList(String query) {
        return cmbItemsRepository.findAllWithUserQuery(query).stream().map(c -> new UserQueryDto(c)).collect(Collectors.toList());
    }
}
