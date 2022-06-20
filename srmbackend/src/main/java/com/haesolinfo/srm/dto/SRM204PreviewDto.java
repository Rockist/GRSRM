package com.haesolinfo.srm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.haesolinfo.srm.dao.SRM204WPreviewSpDao;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
public class SRM204PreviewDto {

    static DecimalFormat format_1 = new DecimalFormat("#,###.0000"); // 777,777,0000
    static DecimalFormat format_2 = new DecimalFormat("#,###.00"); // 777,777.00
    @JsonProperty("senderList")
    private List<WrapperSRM204PreviewDto> senderList;
    @JsonProperty("receiveList")
    private List<WrapperSRM204PreviewDto> receiveList;

    public SRM204PreviewDto(List<List<SRM204WPreviewSpDao>> senderList , List<List<SRM204WPreviewSpDao>> receiveList) {
        this.senderList = senderList.stream().map(WrapperSRM204PreviewDto::new).collect(Collectors.toList());
        this.receiveList = receiveList.stream().map(WrapperSRM204PreviewDto::new).collect(Collectors.toList());
    }

    interface CommonInterface {
        public BigDecimal useDecimal(SRM204WPreviewSpDao dto);
    }

    static class WrapperSRM204PreviewDto {
        @JsonProperty("id")
        private String id;

        @JsonProperty("nestedList")
        private List<SRM204WPreviewSpDto> nestedList;

        @JsonProperty("total_dlvy_qty")
        private String total_dlvy_qty;

        @JsonProperty("total_dlvy_roll")
        private String total_dlvy_roll;

        @JsonProperty("total_scrap_qty")
        private String total_scrap_qty;

        @JsonProperty("total_amt")
        private String total_amt;

        @JsonProperty("total_amt_sup")
        private String total_amt_sup;

        @JsonProperty("add_value_price")
        private String add_value_price;

        @JsonProperty("total")
        private String total;

        public WrapperSRM204PreviewDto(List<SRM204WPreviewSpDao> nestedList) {
            this.id = String.valueOf(UUID.randomUUID());
            BigDecimal total = filterData(nestedList, SRM204WPreviewSpDao::getAMT);
            /* 면적합계, ROLL 합계, SCRAP 합계, AMT 합계 */
            this.total_dlvy_qty = filterData(format_2, nestedList, SRM204WPreviewSpDao::getDLVY_QTY);
            this.total_dlvy_roll = filterData(format_2, nestedList, SRM204WPreviewSpDao::getDLVY_ROLL);
            this.total_scrap_qty = filterData(format_2, nestedList, SRM204WPreviewSpDao::getSCRAP_QTY);
            this.total_amt = format_1.format(total);

            /* 공급가액 합계, 부가가치세, 총계 */
            this.total_amt_sup = format_2.format(total);
            this.add_value_price = format_1.format(total.divide(new BigDecimal(10)));
            this.total = format_1.format(total.add(total.divide(new BigDecimal(10))));

            this.nestedList = nestedList.stream()
                    .map(dao -> new SRM204WPreviewSpDto().toDto(dao, format_1, format_2))
                    .collect(Collectors.toList());
        }

        private BigDecimal filterData(List<SRM204WPreviewSpDao> nestedList, CommonInterface commonInterface) {
            return nestedList.stream()
                            .map(commonInterface::useDecimal)
                            .reduce(BigDecimal::add)
                            .get();
        }

        private String filterData(DecimalFormat format, List<SRM204WPreviewSpDao> nestedList, CommonInterface commonInterface) {
            return format.format(nestedList.stream()
                    .map(commonInterface::useDecimal)
                    .reduce(BigDecimal::add)
                    .get());
        }
    }
}
