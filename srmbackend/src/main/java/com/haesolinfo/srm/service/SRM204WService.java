package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dao.SRM204WPreviewSpDao;
import com.haesolinfo.srm.dto.*;
import com.haesolinfo.srm.exception.LabelSaveException;
import com.haesolinfo.srm.repository.SRM204WRepository;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SRM204WService {
    private final SRM204WRepository srm204WRepository;

    public SRM204WDto findList1(SRM100RVO vo) {

        List<SRM204WDtoSP1> list1 = srm204WRepository.findList1(vo);
        List<SRM204WDtoSP2> list2 = srm204WRepository.findList2(list1.get(0).getDLVY_NO());

        SRM204WDto dto = new SRM204WDto();
        dto.crateSRM204WDto(list1, list2);

        return dto;
    }

    public SRM204WDto findList2(String dlvyNo) {

        //List<SRM204WDtoSP1> list1 = new ArrayList<>();
        List<SRM204WDtoSP2> list2 = srm204WRepository.findList2(dlvyNo);

        SRM204WDto dto = new SRM204WDto();
        dto.crateSRM204WDto(null, list2);

        return dto;
    }

    /* USP_LABEL_SAVE 프로시저에 문제생겼을때 롤백 합니다. 테스트를 해보지 않아서 코드상 문제가 생길 수 있습니다. */
    @Transactional(rollbackFor = LabelSaveException.class)
    public int labelSave(String GBN, String USER_ID, String dilvy_no) throws LabelSaveException {
        int v = srm204WRepository.labelSave(GBN, USER_ID, dilvy_no);
        if (v > 0) throw new LabelSaveException("LABEL_SAVE 프로시저에서 문제가 생겼습니다.");
        return v;
    }

    public SRM204PreviewDto findPreviewData(String GBN, String CUST_CD, String USER_GROUP) {
        List<List<SRM204WPreviewSpDao>> senderList = new ArrayList<>();  // 공급자
        List<List<SRM204WPreviewSpDao>> receiveList = new ArrayList<>(); // 공급받는자

        List<SRM204WPreviewSpDao> listPreviews = srm204WRepository.findPreviewData(GBN, CUST_CD, USER_GROUP);
        Map<String, Map<String, List<SRM204WPreviewSpDao>>> groupByDilvy_noAndGubun = listPreviews.stream()
                .filter(srm204WPreviewSpDto -> !Objects.isNull(srm204WPreviewSpDto.getDLVY_NO()))
                .collect(groupingBy(SRM204WPreviewSpDao::getDLVY_NO,
                        groupingBy(SRM204WPreviewSpDao::getGUBUN)
                ));

        groupByDilvy_noAndGubun.forEach((dilvy_no, map) -> {
            map.forEach((gubun, dataList) -> {
                int i = 0;
                if (dataList.size() > 10) {
                    while (i < dataList.size()) {
                        setDataList(gubun, dataList, i, senderList, receiveList);
                        i += 10;
                    }
                } else {
                    setDataList(gubun, dataList, i, senderList, receiveList);
                }
            });
        });
        SRM204PreviewDto dto = new SRM204PreviewDto(senderList, receiveList);
        log.info("공급자용 데이터 : " + senderList);
        log.info("공급받는자용 데이터 : " + receiveList);
        return dto;
    }

    private void setDataList(String gubun, List<SRM204WPreviewSpDao> list, int i, List<List<SRM204WPreviewSpDao>> senderList, List<List<SRM204WPreviewSpDao>> receiveList) {
        if (gubun.equals("공급자용")) {
            senderList.add(list.subList(i, Math.min(i + 10, list.size())));
        } else {
            receiveList.add(list.subList(i, Math.min(i + 10, list.size())));
        }
    }
}
