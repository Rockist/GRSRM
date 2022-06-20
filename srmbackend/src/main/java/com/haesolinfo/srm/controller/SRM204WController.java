package com.haesolinfo.srm.controller;

import com.haesolinfo.srm.dto.SRM204PreviewDto;
import com.haesolinfo.srm.dto.SRM204WDto;
import com.haesolinfo.srm.service.SRM204WService;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SRM204WController {
    private final SRM204WService srm204WService;

    @PostMapping("api/SRM204W/list")
    public ResponseEntity<?> searchList(@RequestBody SRM100RVO vo) {

        log.info("api/SRM204W/list : " + vo.toString());

        SRM204WDto result = srm204WService.findList1(vo);

        log.info("api/SRM204W/list result : " + result.toString());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("api/SRM204W/sp2")
    public ResponseEntity<?> searchSP2(@RequestBody Map<String, Object> map) {

        log.info("dlvyNo : " + map.get("dlvyNo"));

        SRM204WDto result = srm204WService.findList2(map.get("dlvyNo").toString());

        log.info("SRM204W SP2 result : " + result.toString());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("api/SRM204W/prv_sp")
    public ResponseEntity<?> searchPreviewSp(@RequestBody String DILVY_NO) { // 납품번호 리스트만 가져옴
        // 제생각엔 로그인 정보를 세션을 유지한다음에 세션에서 가져오면 될듯 합니다.
        // 구분은 비주얼 스튜디오 코드에서 직접 매핑한상태 입니다.
        String[] dil_no_array = DILVY_NO.replace("\"", "").split(",");

        int result = 0;
        for (String dilvy_no : dil_no_array) {
            result += srm204WService.labelSave("SRM_204W", "admin", dilvy_no) > 0 ? 0 : 1;
        }

        log.info("result count : " + result);

        if (result > 0) {
            SRM204PreviewDto previewDto = srm204WService.findPreviewData("SRM_204W", "1000", "S");
            log.info("previewDto : " + previewDto.toString());
            return new ResponseEntity<>(previewDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("데이터를 가져오지 못했습니다.", HttpStatus.BAD_GATEWAY);
    }
}
