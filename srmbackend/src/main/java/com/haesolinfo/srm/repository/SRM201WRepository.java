package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.srm201w.SRM201WDtoSP1;
import com.haesolinfo.srm.dto.srm201w.SRM201WDtoSP2;
import com.haesolinfo.srm.vo.SRM201WVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SRM201WRepository {
    private final EntityManager em;

    public List<SRM201WDtoSP1> findList1(SRM201WVO vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM201WDtoSP1.USP_SRM_201W_QUERY1");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_FROM", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_TO", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("PUR_CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_GBN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("NP_YN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("DT_FROM", vo.getDtFrom());
        spq.setParameter("DT_TO", vo.getDtTo());
        spq.setParameter("PUR_CUST_CD", vo.getPurCustCd());
        spq.setParameter("DT_GBN", vo.getDtGbn());
        spq.setParameter("NP_YN", vo.getNpYn());
        spq.setParameter("USER_GROUP", vo.getUserGroup());

        spq.execute();

        List<SRM201WDtoSP1> resultList = spq.getResultList();
        return resultList;
    }


    public List<SRM201WDtoSP2> findList2(SRM201WVO vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM201WDtoSP2.USP_SRM_201W_QUERY2");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("PUR_CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DLVY_FR", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DLVY_TO", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DLVY_NO", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("PUR_CUST_CD", vo.getPurCustCd());
        spq.setParameter("DLVY_FR", vo.getDlvyFr());
        spq.setParameter("DLVY_TO", vo.getDlvyTo());
        spq.setParameter("DLVY_NO", vo.getDlvyNo());
        spq.setParameter("USER_GROUP", vo.getUserGroup());

        spq.execute();

        List resultList = spq.getResultList();

        log.info(resultList.toString());

        return resultList;
    }
}
