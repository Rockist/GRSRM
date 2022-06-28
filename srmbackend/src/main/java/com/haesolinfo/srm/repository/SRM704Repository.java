package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.srm501w.SRM501WFileDownDto;
import com.haesolinfo.srm.vo.srm501w.SRM501WFileDownVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SRM704Repository {

    private final EntityManager em;

    public List<SRM501WFileDownDto> fileDownload(SRM501WFileDownVo vo) {
        log.info("SRM501WFileDownVo : " + vo.toString());
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM501WFileDownDto.FILE_DOWNLOAD");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_NO", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_NAME", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_SEQ", Integer.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDiv_cd());
        spq.setParameter("FILE_NO", vo.getFile_no());
        spq.setParameter("FILE_NAME", vo.getFile_name());
        spq.setParameter("FILE_SEQ", vo.getFile_seq());
        spq.execute();

        List<SRM501WFileDownDto> resultList = spq.getResultList();
        return resultList;
    }
}
