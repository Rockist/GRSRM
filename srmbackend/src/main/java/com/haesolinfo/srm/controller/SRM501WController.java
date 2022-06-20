package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.SRM501WDto;
import com.haesolinfo.srm.service.SRM501WService;
import com.haesolinfo.srm.vo.SRM501WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM501WController {
    private final SRM501WService srm501WService;

    @PostMapping("api/SRM501W/list")
    public ResponseEntity<?> serarchList(@RequestBody SRM501WVo vo){
        SRM501WDto result = srm501WService.findList(vo);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("api/SRM501W/sp2")
    public ResponseEntity<?> serarchSP2(@RequestBody SRM501WVo vo){
        SRM501WDto result = srm501WService.findList2(vo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
