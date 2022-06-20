package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.XM102WDto;
import com.haesolinfo.srm.service.XM102WService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class XM102WController {

    private final XM102WService xm102WService;

    @GetMapping("/api/XM102W/list")
    public ResponseEntity<?> list(@RequestParam("divCd") String divCd, @RequestParam("menuId") String menuId){

        List<XM102WDto> menuList = xm102WService.findMenuList(divCd, menuId);

        for (XM102WDto dto: menuList
             ) {
            log.info("XM102W. SRM_100R : " + dto.toString());
        }

        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }
}
