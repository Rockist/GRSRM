package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dao.srm704w.SRM704WPopupDao;
import com.haesolinfo.srm.dto.CmbItemsDto;
import com.haesolinfo.srm.dto.popup.PopupDto;
import com.haesolinfo.srm.dto.srm501w.SRM501WPopDto1;
import com.haesolinfo.srm.dto.srm501w.SRM501WPopDto2;
import com.haesolinfo.srm.dto.srm704w.SRM704WPopupDto;
import com.haesolinfo.srm.service.CmbItemsService;
import com.haesolinfo.srm.service.PopupService;
import com.haesolinfo.srm.vo.srm704w.SRM704WPopupVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PopupController {
    private final PopupService popupService;
    private final CmbItemsService cmbItemsService;

    @PostMapping("/api/Popup/SRM501Wpopup1")
    public ResponseEntity<?> get501WPopupData1(@RequestBody String word) {
        List<SRM501WPopDto1> result = popupService.find501WPopup1(word);
        PopupDto<SRM501WPopDto1> popupDto = new PopupDto<>(result, new SRM501WPopDto1().getHeaderList());
        return new ResponseEntity<>(popupDto, HttpStatus.OK);
    }

    @PostMapping("/api/Popup/SRM501Wpopup2")
    public ResponseEntity<?> get501WPopupData2(@RequestBody String word) {
        // 이것도 세션에서 유저 정보와, 유저 그룹 을 가지고 오면 될듯함다.
        List<SRM501WPopDto2> result = popupService.find501WPopup2("S", "admin", word);
        PopupDto<SRM501WPopDto2> popupDto = new PopupDto<>(result, new SRM501WPopDto2().getHeaderList());
        return new ResponseEntity<>(popupDto, HttpStatus.OK);
    }

    @PostMapping("/api/Popup/SRM704Wpopup")
    public ResponseEntity<?> get704WPopupData(@RequestBody SRM704WPopupVo vo) {
        log.info("SRM704WPopupDto : " + vo.toString());
        List<CmbItemsDto> cmbItemsDtoList = cmbItemsService.findCmbCmbList("1002");

        List<SRM704WPopupDao> daoList = popupService.find704WPopup(vo);
        List<SRM704WPopupDto> result = daoList.stream().map(data -> new SRM704WPopupDto().mapping(data, cmbItemsDtoList)).collect(Collectors.toList());
        PopupDto<SRM704WPopupDto> popupDto = new PopupDto<>(result, new SRM704WPopupDto().getHeaderList());
        return new ResponseEntity<>(popupDto, HttpStatus.OK);
    }
}
