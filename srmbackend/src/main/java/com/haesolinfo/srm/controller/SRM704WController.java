package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.srm704w.SRM704WDto;
import com.haesolinfo.srm.service.SRM704WService;
import com.haesolinfo.srm.vo.srm704w.SRM704WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM704WController {

    private final SRM704WService srm704WService;

    @PostMapping("api/SRM704W/list")
    public ResponseEntity<?> serarchList(@RequestBody SRM704WVo vo){
        List<SRM704WDto> result = srm704WService.findList(vo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
