package com.haesolinfo.srm.dao.srm704w;

import com.haesolinfo.srm.dto.popup.PopupDtoInterface;
import com.haesolinfo.srm.dto.popup.PopupHeader;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@NamedStoredProcedureQuery(
        name = "SRM704WDto.USP_PU_ITEM",
        procedureName = "USP_PU_ITEM",
        resultClasses = SRM704WPopupDao.class)
@Data
@Entity
public class SRM704WPopupDao  {
    @Id
    private String ITEM_CD;
    private String ITEM_NM;
    private String SPEC;
    private String ITEM_ACCT;
    private String UNIT;
    private String PROC_TP;
    private String CAVITY;
    private String WIDTH;
    private String BOM_YN;
    private String DIVISION;
    private String PAY_CUST;
    private String LAST_ASSEM;
    private String SPEC_CUST;
    private String MODEL;
    private String PROJECT;
}
