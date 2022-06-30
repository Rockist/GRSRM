package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.srm501w.SRM501WFileDownDto;
import com.haesolinfo.srm.dto.srm704w.SRM704WDto;
import com.haesolinfo.srm.vo.srm704w.SRM704WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SRM704WRepository {

    private final EntityManager em;

    public List<SRM704WDto> findList(SRM704WVo vo) {
        log.info("SRM704WDto : " + vo.toString());
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM704W.USP_PD_703W_QUERY2");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ORDER_DT_FR", Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ORDER_DT_TO", Date.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ITEM_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("MOLD_TYPE", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("MOLD_CLASS", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("ORDER_DT_FR", vo.getOrderDtFr());
        spq.setParameter("ORDER_DT_TO", vo.getOrderDtTo());
        spq.setParameter("ITEM_CD", vo.getItemCd());
        spq.setParameter("MOLD_TYPE", vo.getMoldType());
        spq.setParameter("MOLD_CLASS", vo.getMoldClass());
        spq.execute();
        return (List<SRM704WDto>) spq.getResultList();
    }
}
