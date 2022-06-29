package com.haesolinfo.srm.dto.srm704w;


import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@NamedStoredProcedureQuery(
        name = "SRM704W.USP_PD_703W_QUERY",
        procedureName = "USP_PD_703W_QUERY",
        resultClasses = SRM704WDto.class)
public class SRM704WDto {
    private String GU;
    @Id
    private String ORDER_NO;
    private Date ORDER_DT;
    private String MAKER;
    private String PUR_USER_ID;
    private String REQ_TYPE;
    private String MOLD_CD;
    private String MOLD_NM;
    private String MOLD_CLASS;
    private String ITEM_CD;
    private String ITEM_NM;
    private String ROUT_NO;
    private String PROC_CD;
    private int REQ_QTY;
    private String DRAW_NO;
    private String MOLD_TYPE;
    private int ORDER_QTY;
    private BigDecimal MOLD_PRICE;
    private BigDecimal MOLD_AMT;
    private Date DLVY_DT;
    private Date IN_DATE;
    private String REMARK;
}
