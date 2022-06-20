package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dto.XM101WDto;
import com.haesolinfo.srm.vo.XM101WVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class XM101WRepository {

    private final EntityManager em;

    public List<XM101WDto> findList(XM101WVo vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("XM101WDto.SP_XM_101W_QUERY");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("P_MENU_ID", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USE_YN", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("P_MENU_ID", vo.getPMenuId());
        spq.setParameter("USE_YN", vo.getUseYN());

        spq.execute();

        List<XM101WDto> resultList = spq.getResultList();
        return resultList;
    }

    public int saveList(List<XM101WDto> saveList, XM101WVo vo) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("SP_XM_101W_SAVE");
        spq.registerStoredProcedureParameter("MSG_CD", String.class, ParameterMode.OUT);
        spq.registerStoredProcedureParameter("MSG_DETAIL", String.class, ParameterMode.OUT);
        spq.registerStoredProcedureParameter("I_VALUE", String.class, ParameterMode.OUT);

        for(int i=0;i<saveList.size();i++){
            spq.setParameter(i+1, saveList.get(i));
            spq.setParameter("CUD_CHAR", saveList.get(i).getGU());
            spq.setParameter("DIV_CD", vo.getDivCd());
            spq.setParameter("P_MENU_ID", saveList.get(i).getP_MENU_ID());
            spq.setParameter("P_MENU_TYPE", saveList.get(i).getP_MENU_TYPE());
            spq.setParameter("C_MENU_ID", saveList.get(i).getC_MENU_ID());
            spq.setParameter("C_MENU_NM", saveList.get(i).getC_MENU_NM());
            spq.setParameter("C_MENU_TYPE", saveList.get(i).getC_MENU_TYPE());
            spq.setParameter("MENU_LBL", saveList.get(i).getMENU_LVL());
            spq.setParameter("MENU_SEQ", saveList.get(i).getMENU_SEQ());
            spq.setParameter("USE_YN", saveList.get(i).getUSE_YN());
            spq.setParameter("ICON_NO", saveList.get(i).getICON_NO());

            spq.setParameter("USER_ID", "admin");   // userid 필요

            boolean result = spq.execute();

            log.info("excute result : " + result);

        }

        return spq.getUpdateCount();
    }
}
