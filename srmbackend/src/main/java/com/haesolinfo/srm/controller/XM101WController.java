package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.XM101WDto;
import com.haesolinfo.srm.service.XM101WService;
import com.haesolinfo.srm.vo.XM101WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class XM101WController {
    private final XM101WService xm101WService;

    @PostMapping("api/XM101W/list")
    public ResponseEntity<?> serarchList(@RequestBody XM101WVo vo){

        if(vo.getPMenuId() == null){
            vo.setPMenuId("");
        }

        log.info("XM101W Controller : " + vo.toString());

        List<XM101WDto> result = xm101WService.findList(vo);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("api/XM101W/save")
    public ResponseEntity<?> saveList(@RequestBody Map<String, Object> map){

        log.info("XM101WController list : " + map.toString());

        int result = xm101WService.saveList(map);
        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
