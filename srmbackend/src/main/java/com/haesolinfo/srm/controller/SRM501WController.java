package com.haesolinfo.srm.controller;

        import com.haesolinfo.srm.dto.srm501w.SRM501WDto;
        import com.haesolinfo.srm.dto.srm501w.SRM501WFileDownDto;
        import com.haesolinfo.srm.service.SRM501WService;
        import com.haesolinfo.srm.vo.srm501w.SRM501WFileDelVo;
        import com.haesolinfo.srm.vo.srm501w.SRM501WFileDownVo;
        import com.haesolinfo.srm.vo.srm501w.SRM501WFileVo;
        import com.haesolinfo.srm.vo.srm501w.SRM501WVo;
        import lombok.RequiredArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.core.io.InputStreamResource;
        import org.springframework.core.io.Resource;
        import org.springframework.http.ContentDisposition;
        import org.springframework.http.HttpHeaders;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.File;
        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.Objects;

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

    @PostMapping("api/SRM501W/file_upload")
    public ResponseEntity<?> uploadFile(SRM501WFileVo vo)  {
        log.info("SRM501WFileVo : " + vo.toString());

        if(vo.getFile() == null)
            return new ResponseEntity<>("파일이 존재하지 않습니다.", HttpStatus.OK);
        int result = srm501WService.fileUpload(vo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("api/SRM501W/file_download")
    public ResponseEntity<?> downloadFile(@RequestParam("divCd") String divCd,
                                          @RequestParam("fileNo") String fileNo,
                                          @RequestParam("fileName") String fileName,
                                          @RequestParam("fileSeq") int fileSeq) {

        SRM501WFileDownVo vo = new SRM501WFileDownVo(divCd, fileNo, fileName, fileSeq);
        Resource resource = srm501WService.fileDownload(vo);
        if(Objects.isNull(resource)) {
            return new ResponseEntity<>("파일 다운로드 실패!", HttpStatus.OK);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(vo.getFile_name()).build()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @PostMapping("api/SRM501W/file_delete")
    public ResponseEntity<?> deleteFile(@RequestBody SRM501WFileDelVo vo) {
        int result = srm501WService.deleteFile(vo);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
