package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.srm705w.SRM705WDto;
import com.haesolinfo.srm.service.SRM705WService;
import com.haesolinfo.srm.vo.srm705w.SRM705WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM705WController {

    private final SRM705WService srm705WService;

    @PostMapping("api/SRM705W/list")
    public ResponseEntity<?> serarchList(@RequestBody SRM705WVo vo){
        List<SRM705WDto> result = srm705WService.findList(vo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
