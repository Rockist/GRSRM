package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.SRM302RDto;
import com.haesolinfo.srm.service.SRM302RService;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM302RController {
    private final SRM302RService srm302RService;

    @CrossOrigin
    @PostMapping("/api/SRM302R/list")
    public ResponseEntity<?> searchList(@RequestBody SRM100RVO vo){
        log.info(vo.toString());
        return new ResponseEntity(srm302RService.findList(vo), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/api/SRM302R/save")
    public ResponseEntity<?> saveList(@RequestBody Map<String, Object> map){
        //log.info(vo.toString());
        log.info(map.toString());

        List<SRM302RDto> dto = (List<SRM302RDto>) map.get("SRM302RDto");
        log.info(dto.toString());

        Map<String, ?> voMap = (Map<String, ?>) map.get("SRM100RVO");
        log.info(voMap.get("divCd").toString());
        log.info(voMap.get("dtFrom").getClass().getName());
        log.info(voMap.get("dtFrom").getClass().toString());

        SRM100RVO vo = new SRM100RVO();
        /*vo.setDtFrom((LocalDate) voMap.get("dtFrom"));*/
        log.info(map.get("SRM100RVO").toString());

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
