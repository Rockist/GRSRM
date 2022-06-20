package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.SRM100RDto;
import com.haesolinfo.srm.vo.SRM100RVO;
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
public class SRM100RRepository{
    private final EntityManager em;

    public List<SRM100RDto> findList(SRM100RVO vo){
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM100RDto.USP_SRM_100R_QUERY");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(3, LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(4, LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);

        spq.setParameter(1, vo.getDivCd());
        spq.setParameter(2, vo.getPurCustCd());
        spq.setParameter(3, vo.getDtFrom());
        spq.setParameter(4, vo.getDtTo());
        spq.setParameter(5, vo.getDtGbn());
        spq.setParameter(6, vo.getUserGroup());

        spq.execute();

        List<SRM100RDto> lists = spq.getResultList();

        return lists;

    }

}
