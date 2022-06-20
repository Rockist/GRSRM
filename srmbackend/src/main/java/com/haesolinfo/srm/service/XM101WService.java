package com.haesolinfo.srm.service;

import com.haesolinfo.srm.dto.XM101WDto;
import com.haesolinfo.srm.repository.XM101WRepository;
import com.haesolinfo.srm.vo.XM101WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class XM101WService {

    private final XM101WRepository xm101WRepository;

    public List<XM101WDto> findList(XM101WVo vo) {
        List<XM101WDto> list = xm101WRepository.findList(vo);
        return list;
    }

    public int saveList(Map<String, Object> map) {

        List<XM101WDto> list = (List<XM101WDto>) map.get("XM101WDto");

        log.info("XM101WService List : " + list.toString());

        List<XM101WDto> saveList = list.stream().filter(c -> c.getGU().equalsIgnoreCase("")).collect(Collectors.toList());
        XM101WVo vo = (XM101WVo) map.get("XM101WVo");

        log.info("XM101WService saveList : " + saveList.toString());
        log.info("XM101WService VO : " + vo.toString());


        //int result = xm101WRepository.saveList(saveList, vo);
        return 0;
    }
}
