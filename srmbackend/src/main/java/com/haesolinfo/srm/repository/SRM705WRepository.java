package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.srm705w.SRM705WDto;
import com.haesolinfo.srm.vo.srm705w.SRM705WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.sql.Date;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SRM705WRepository {

    private final EntityManager em;

    public List<SRM705WDto> findList(SRM705WVo vo) {
        log.info(vo.toString());
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM705W.USP_SRM_705W_QUERY");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ORDER_DT_FR", Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ORDER_DT_TO", Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("MOLD_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("MOLD_NM", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("ORDER_DT_FR", vo.getOrderDtFr());
        spq.setParameter("ORDER_DT_TO", vo.getOrderDtTo());
        spq.setParameter("MOLD_CD", vo.getMoldCd());
        spq.setParameter("MOLD_NM", vo.getMoldNm());
        spq.execute();

        List<SRM705WDto> resultList = (List<SRM705WDto>) spq.getResultList();
        log.info("SRM705W : " + resultList);
        return resultList;
    }
}
