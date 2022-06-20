package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.SRM501WDtoSP1;
import com.haesolinfo.srm.dto.SRM501WDtoSP2;
import com.haesolinfo.srm.vo.SRM501WVo;
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
}
