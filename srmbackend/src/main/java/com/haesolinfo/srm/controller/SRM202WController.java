package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.service.SRM202WService;
import com.haesolinfo.srm.vo.SRM202WVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SRM202WController {
    private final SRM202WService srm202WService;

    @CrossOrigin
    @PostMapping("/api/SRM202W/list")
    public ResponseEntity<?> searchList(@RequestBody SRM202WVO vo){
        return new ResponseEntity<>(srm202WService.findList(vo), HttpStatus.OK);
    }
}
