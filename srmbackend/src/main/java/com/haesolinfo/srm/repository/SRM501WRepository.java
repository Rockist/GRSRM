package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.srm501w.SRM501WDtoSP1;
import com.haesolinfo.srm.dto.srm501w.SRM501WDtoSP2;
import com.haesolinfo.srm.dto.srm501w.SRM501WFileDto;
import com.haesolinfo.srm.vo.srm501w.SRM501WFileVo;
import com.haesolinfo.srm.vo.srm501w.SRM501WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.Base64;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SRM501WRepository {

    private final EntityManager em;
    public List<SRM501WDtoSP1> findList1(SRM501WVo vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM501WDtoSP1.USP_SRM_501W_QUERY1");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ITEM_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_CUST", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("CUST_CD", vo.getCustCd());
        spq.setParameter("ITEM_CD", vo.getItemCd());
        spq.setParameter("USER_GROUP", vo.getUserGroup());
        spq.setParameter("USER_CUST", vo.getUserCust());
        spq.execute();

        List<SRM501WDtoSP1> resultList = spq.getResultList();

        return resultList;
    }

    public List<SRM501WDtoSP2> findList2(SRM501WVo vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM501WDtoSP2.USP_SRM_501W_QUERY2");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ITEM_CD", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("CUST_CD", vo.getCustCd());
        spq.setParameter("ITEM_CD", vo.getItemCd());
        spq.execute();

        List<SRM501WDtoSP2> resultList = spq.getResultList();

        log.info("findList2 : " + resultList.toString());

        return resultList;
    }
    public int fileUpload(SRM501WFileDto dto)  {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("dbo.FILE_SAVE");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ITEM_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_NO", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_IMAGE", byte[].class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_NAME", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("FILE_EXTENSION", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("WIDTH", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("HEIGHT", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("INSERT_ID", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("VALID_DT", String.class, ParameterMode.IN);

//        Base64.getEncoder().encodeToString(dto.getFILE_IMAGE())
        spq.setParameter("DIV_CD", dto.getDIV_CD());
        spq.setParameter("CUST_CD", dto.getCUST_CD());
        spq.setParameter("ITEM_CD", dto.getITEM_CD());
        spq.setParameter("FILE_NO", dto.getFILE_NO());
        spq.setParameter("FILE_IMAGE", dto.getFILE_IMAGE());
        spq.setParameter("FILE_NAME", dto.getFILE_NAME());
        spq.setParameter("FILE_EXTENSION", dto.getFILE_EXTENSION());
        spq.setParameter("WIDTH", dto.getWIDTH());
        spq.setParameter("HEIGHT", dto.getHEIGHT());
        spq.setParameter("INSERT_ID", dto.getINERT_ID());
        spq.setParameter("VALID_DT", dto.getVALID_DT());
        spq.execute();

        return spq.getFirstResult();
    }
}
