package com.haesolinfo.srm.vo.srm501w;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class SRM501WFileVo {
    private MultipartFile file;
    private String itemCd;
    private String custCd;
    private String fileNo;
    private String startDate;
}
