package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.SRM100RDto;
import com.haesolinfo.srm.vo.SRM100RVO;
import com.haesolinfo.srm.service.SRM100RService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM100RController {

    private final SRM100RService srm100RService;

    @PostMapping("/api/SRM100R/list")
    public ResponseEntity<?> searchList(@RequestBody SRM100RVO vo){

        log.info("SRM100R" + vo.toString());
        List<SRM100RDto> result = srm100RService.findList(vo);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /*@PostMapping("/api/SRM_100R/save")
    public ResponseEntity<?> saveOrders(){

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }*/

}
