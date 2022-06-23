package com.haesolinfo.srm.domain;

import com.haesolinfo.srm.dto.pk.popup.PUR_CUST_CD_JOIN_PK;
import lombok.Data;
import javax.persistence.*;

@NamedStoredProcedureQuery(
        name = "SRM501WPopup2.PUR_CUST_CD_QUERY",
        procedureName = "PUR_CUST_CD_QUERY",
        resultClasses = PUR_CUST_CD_JOIN.class)
@Entity
@Data
@IdClass(PUR_CUST_CD_JOIN_PK.class)
public class PUR_CUST_CD_JOIN {
    @Id
    private String PUR_CUST_CD;
    @Id
    private String BP_NM;
    @Id
    private String ITEM_CD;
    @Id
    private String ITEM_NM;
    @Id
    private String SPEC;
}
