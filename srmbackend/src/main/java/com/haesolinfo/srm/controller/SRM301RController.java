package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.service.SRM301RService;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SRM301RController {
    private final SRM301RService srm301RService;

    @CrossOrigin
    @PostMapping("/api/SRM301R/list")
    public ResponseEntity<?> searchList(@RequestBody SRM100RVO vo){
        return new ResponseEntity(srm301RService.findList(vo), HttpStatus.OK);
    }
}
