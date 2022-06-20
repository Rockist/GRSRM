package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.XM102WDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class XM102WRepository {
    private final EntityManager em;

    public List<XM102WDto> findList(String div_cd, String menu_id) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("XM102W.SP_XM_102W_QUERY_01");
        spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

        spq.setParameter(1, div_cd);
        spq.setParameter(2, menu_id);

        spq.execute();

        List<XM102WDto> result = spq.getResultList();

        return result;

    }
}
