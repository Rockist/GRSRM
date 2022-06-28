package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.XM102WDto;
import com.haesolinfo.srm.service.SRM704WService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/* 금형 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM704WController {

    private final SRM704WService srm704WService;


}
