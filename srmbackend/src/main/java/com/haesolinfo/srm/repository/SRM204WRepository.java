package com.haesolinfo.srm.repository;

import com.haesolinfo.srm.dao.SRM204WPreviewSpDao;
import com.haesolinfo.srm.dto.SRM204WDtoSP1;
import com.haesolinfo.srm.dto.SRM204WDtoSP2;
import com.haesolinfo.srm.vo.SRM100RVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Repository
public class SRM204WRepository {
    private final EntityManager em;
    private SimpleJdbcCall simpleJdbcCall;
    private final JdbcTemplate jdbcTemplate;

    public List<SRM204WDtoSP1> findList1(SRM100RVO vo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM204WDtoSP1.USP_SRM_204W_QUERY1");
        spq.registerStoredProcedureParameter("DIV_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_FROM", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("DT_TO", LocalDate.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("PUR_CUST_CD", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_GROUP", String.class, ParameterMode.IN);

        spq.setParameter("DIV_CD", vo.getDivCd());
        spq.setParameter("DT_FROM", vo.getDtFrom());
        spq.setParameter("DT_TO", vo.getDtTo());
        spq.setParameter("PUR_CUST_CD", vo.getPurCustCd());
        spq.setParameter("USER_GROUP", vo.getUserGroup());

        spq.execute();

        List<SRM204WDtoSP1> resultList = spq.getResultList();

        return resultList;
    }

    public int labelSave(String GBN, String USER_ID, String ORDERNO) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("dbo.USP_LABEL_SAVE2");
        spq.registerStoredProcedureParameter("ORDERNO", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("ORDERSEQ", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("GBN", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("PRINT_QTY", Integer.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("USER_ID", String.class, ParameterMode.IN);

        spq.setParameter("ORDERNO", ORDERNO);
        spq.setParameter("ORDERSEQ", 0);
        spq.setParameter("GBN", GBN);
        spq.setParameter("PRINT_QTY", 1);
        spq.setParameter("USER_ID", USER_ID);

        spq.execute();
        return spq.getFirstResult();
    }

    public List<SRM204WDtoSP2> findList2(String dlvyNo) {
        StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("SRM204WDtoSP2.USP_SRM_204W_QUERY2");
        spq.registerStoredProcedureParameter("DLVY_NO", String.class, ParameterMode.IN);

        spq.setParameter("DLVY_NO", dlvyNo);
        spq.execute();

        List resultList = spq.getResultList();
        return resultList;
    }

    public List<SRM204WPreviewSpDao> findPreviewData(String GBN, String CUST_CD, String USER_GROUP) {
        /* 프로시저 내에서 선언된 테이블은 createNamedStoredProcedureQuery, createStoredProcedureQuery 로 가져올 수 없었기 때문에
         * resultSet 으로 가져왔습니다. 더 좋은 방법이있다면 수정하는걸 추천합니다.
         */
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("GRMES")
                .withSchemaName("dbo")
                .withProcedureName("USP_SRM_204W_PRINT")
                .returningResultSet("previewsp", (RowMapper<SRM204WPreviewSpDao>) (rs, rowNum) -> {
                    SRM204WPreviewSpDao dao = new SRM204WPreviewSpDao(
                            rs.getInt("CNT"),
                            rs.getNString("GUBUN"),
                            rs.getInt("GCNT"),
                            rs.getDate("DLVY_DT"),
                            rs.getNString("DLVY_NO"),
                            rs.getNString("BP_RGST_NO"),
                            rs.getNString("BP_NM"),
                            rs.getNString("REPRE_NM"),
                            rs.getNString("ADDR"),
                            rs.getNString("TEL_NO1"),
                            rs.getNString("FAX_NO"),
                            rs.getNString("IND_TYPE"),
                            rs.getNString("IND_CLASS"),
                            rs.getNString("REMARK"),
                            rs.getNString("ITEM_CD"),
                            rs.getNString("ITEM_NM"),
                            rs.getNString("SPEC"),
                            rs.getNString("BASIC_UNIT"),
                            rs.getBigDecimal("DLVY_QTY"),
                            rs.getBigDecimal("DLVY_ROLL"),
                            rs.getBigDecimal("SCRAP_QTY"),
                            rs.getBigDecimal("ITEM_PRICE"),
                            rs.getBigDecimal("AMT"),
                            rs.getNString("LOT_NO"),
                            rs.getNString("CUST_CD"),
                            rs.getInt("CNT2")
                    );
                    return dao;
                });

        // 파라미터 있는 경우 이거 쓰면됨.
        Map<String, Object> inParamMap = new HashMap<String, Object>();
        inParamMap.put("GBN", GBN);
        inParamMap.put("CUST_CD", CUST_CD);
        inParamMap.put("USER_GROUP", USER_GROUP);

        Map<String, Object> out = simpleJdbcCall.execute(inParamMap);
        List<SRM204WPreviewSpDao> listPreviews = (List<SRM204WPreviewSpDao>)  out.get("previewsp");
        return listPreviews;
    }
}
