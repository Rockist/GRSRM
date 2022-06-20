package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.domain.BA_BIZ_PARTNER;
import com.haesolinfo.srm.domain.BA_SUB_CD;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CmbItemsRepository {
    private final EntityManager em;

    public List<BA_SUB_CD> findAllWithSubCode(String str){

        return em.createQuery("select s from BA_SUB_CD s where s.MAIN_CD = :main_cd", BA_SUB_CD.class)
                .setParameter("main_cd", str)
                .getResultList();
    }

    public List<BA_BIZ_PARTNER> findAllWithUserQuery(String query) {
        List<BA_BIZ_PARTNER> resultList = em.createQuery(query, BA_BIZ_PARTNER.class).getResultList();

        log.info(resultList.toString());

        return resultList;
    }
}
