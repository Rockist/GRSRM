package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.CmbItemsDto;
import com.haesolinfo.srm.dto.pk.UserQueryDto;
import com.haesolinfo.srm.service.CmbItemsService;
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
public class CmbItemsController {

    private final CmbItemsService cmbItemsService;

    @CrossOrigin
    @PostMapping("/api/CmbItems/SubCd")
    public ResponseEntity<?> getSubCodeList(@RequestBody Map<String, String> str){
        log.info(str.toString());
        List<CmbItemsDto> cmbItemList = cmbItemsService.findCmbList(str.get("COL_MCD"));
        return new ResponseEntity<>(cmbItemList, HttpStatus.OK);
    }

    @PostMapping("/api/CmbItems/SubSubCd")
    public ResponseEntity<?> getSubCodeCodeList(@RequestBody  Map<String, String> mainCd) {
        log.info("ddfdfdfdfd : " + mainCd.toString());
        List<CmbItemsDto> cmbItemsDtoList = cmbItemsService.findCmbCmbList(mainCd.get("COL_MCD"));
        return new ResponseEntity<>(cmbItemsDtoList, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/api/cmbItems/UserQuery")
    public ResponseEntity<?> getUserQueryList(@RequestBody Map<String, String> query){
        List<UserQueryDto> result = cmbItemsService.findUserQueryList(query.get("query"));
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
