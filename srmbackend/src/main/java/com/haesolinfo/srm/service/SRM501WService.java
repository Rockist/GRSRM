package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.srm501w.SRM501WDto;
import com.haesolinfo.srm.dto.srm501w.SRM501WDtoSP1;
import com.haesolinfo.srm.dto.srm501w.SRM501WDtoSP2;
import com.haesolinfo.srm.dto.srm501w.SRM501WFileDto;
import com.haesolinfo.srm.repository.SRM501WRepository;
import com.haesolinfo.srm.vo.srm501w.SRM501WFileVo;
import com.haesolinfo.srm.vo.srm501w.SRM501WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sun.jvm.hotspot.utilities.BitMap;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class SRM501WService {

    @Value("${file.path}")
    private String filePath;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final SRM501WRepository srm501WRepository;

    public SRM501WDto findList(SRM501WVo vo) {
        List<SRM501WDtoSP1> list1 = srm501WRepository.findList1(vo);

        SRM501WDtoSP1 dtoSP1 = list1.get(1);

        log.info("SRM501WService dtoSP1");

        SRM501WVo voSP2 = new SRM501WVo();
        voSP2.setDivCd(vo.getDivCd());
        voSP2.setCustCd(dtoSP1.getCUST_CD());
        voSP2.setItemCd(dtoSP1.getITEM_CD());

        log.info("voSP2 : " + voSP2.toString());

        List<SRM501WDtoSP2> list2 = srm501WRepository.findList2(voSP2);

        SRM501WDto dto = new SRM501WDto();
        dto.createSRM501WDto(list1, list2);
        return dto;
    }

    public SRM501WDto findList2(SRM501WVo vo) {
        List<SRM501WDtoSP2> list2 = srm501WRepository.findList2(vo);

        SRM501WDto dto = new SRM501WDto();
        dto.createSRM501WDto(null, list2);

        return dto;
    }

    public int fileUpload(SRM501WFileVo vo) {
        log.info(vo.toString());
        UUID uuid = UUID.randomUUID();
        String originalFilename = vo.getFile().getOriginalFilename();

        assert originalFilename != null;
        String fileName = originalFilename;
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String width = "";
        String height = "";
        byte[] fileImage = null;

        String imageFileName = uuid + "_" + originalFilename;
        Path imagePath = Paths.get(filePath + imageFileName);

        try {
            fileImage = vo.getFile().getBytes();
            if (imageCheck(fileExtension)) {
                Files.write(imagePath, fileImage);
                BufferedImage bitmap = ImageIO.read(imagePath.toFile());
                width = String.valueOf(bitmap.getWidth());
                height = String.valueOf(bitmap.getHeight());
                Files.delete(imagePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date date = new Date(vo.getStartDate());
        // sesion 에서 유저 정보 들고와야 함.
        SRM501WFileDto dto = new SRM501WFileDto("01", vo.getCustCd(), vo.getItemCd(), vo.getFileNo(), fileImage,
                fileName, fileExtension, width, height, "admin", sdf.format(date));
        int result = srm501WRepository.fileUpload(dto);
        return result;
    }

    private boolean imageCheck(String fileExtension) {
        return fileExtension.equalsIgnoreCase(".jpg") || fileExtension.equalsIgnoreCase(".bmp") || fileExtension.equalsIgnoreCase(".png") || fileExtension.equalsIgnoreCase(".tif") ||
                fileExtension.equalsIgnoreCase(".jpeg") || fileExtension.equalsIgnoreCase(".gif");
    }
}
