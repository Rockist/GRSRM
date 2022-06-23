package com.haesolinfo.srm.service;


import com.haesolinfo.srm.dto.popup.SRM501WPopDto1;
import com.haesolinfo.srm.dto.popup.SRM501WPopDto2;
import com.haesolinfo.srm.repository.PopupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class PopupService {
    private final PopupRepository popupRepository;

    public List<SRM501WPopDto1> find501WPopup1(String word){
        return popupRepository.find501WPopup1().stream()
                .map(data -> new SRM501WPopDto1(data.getBP_CD(), data.getBP_FULL_NM()))
                .filter(data -> data.filter(word.trim()))
                .collect(Collectors.toList());
    }

    public List<SRM501WPopDto2> find501WPopup2(String user_group, String user_code, String word){
        return popupRepository.find501WPopup2(user_group, user_code).stream()
                .map(data -> new SRM501WPopDto2(data.getPUR_CUST_CD(), data.getBP_NM(), data.getITEM_CD(), data.getITEM_NM()))
                .filter(data -> data.filter(word))
                .collect(Collectors.toList());
    }
}
