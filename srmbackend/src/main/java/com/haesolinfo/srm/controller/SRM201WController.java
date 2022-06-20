package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.SRM201WDto;
import com.haesolinfo.srm.service.SRM201WService;
import com.haesolinfo.srm.vo.SRM201WVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM201WController {

    private final SRM201WService srm201WService;

    @PostMapping("/api/SRM201W/list")
    public ResponseEntity<?> searchList1(@RequestBody SRM201WVO vo){

        log.info("SRM201WController : " + vo.toString());

        SRM201WDto result = srm201WService.findList(vo);

        log.info("SRM201WController Result : ",result.toString());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
