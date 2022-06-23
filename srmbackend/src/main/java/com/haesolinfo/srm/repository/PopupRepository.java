package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.domain.BA_BIZ_PARTNER;
import com.haesolinfo.srm.domain.BA_SUB_CD;
import com.haesolinfo.srm.domain.PUR_CUST_CD_JOIN;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PopupRepository {
    private final EntityManager em;

    public List<BA_BIZ_PARTNER> find501WPopup1(){
        return em.createQuery("SELECT B FROM BA_BIZ_PARTNER B WHERE B.USE_YN = 'Y' AND B.BP_TYPE IN ('CS', 'S')", BA_BIZ_PARTNER.class)
                .getResultList();
    }

    public List<PUR_CUST_CD_JOIN> find501WPopup2(String user_group, String user_code) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM501WPopup2.PUR_CUST_CD_QUERY");
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_CODE", String.class, ParameterMode.IN);

        spq.setParameter("USER_GROUP", user_group);
        spq.setParameter("USER_CODE", user_code);

        spq.execute();
        List resultList = spq.getResultList();
        return resultList;
    }
}
