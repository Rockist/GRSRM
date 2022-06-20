package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.SRM202WDto;
import com.haesolinfo.srm.vo.SRM202WVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class SRM202WRepository {

    private final EntityManager em;

    public List<SRM202WDto> findList(SRM202WVO vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM202WDto.USP_SRM_202W_QUERY");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("PUR_CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_FROM", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_TO", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("PUR_CUST_CD", vo.getPurCustCd());
        spq.setParameter("DT_FROM", vo.getDtFrom());
        spq.setParameter("DT_TO", vo.getDtTo());
        spq.setParameter("USER_GROUP", vo.getUserGroup());

        spq.execute();

        List<SRM202WDto> lists = spq.getResultList();
        return lists;
    }
}
