package com.app.candm.dto.funding;

import com.app.candm.common.enumeration.Status;
import com.app.candm.domain.FundingVO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class FundingDTO {
    private Long id;
    private Long fundingTargetAmount;
    private Long fundingCurrentAmount;
    private String fundingTitle;
    private String startDate;
    private String endDate;
    private String fundingUrl;
    private String fundingDescription;
    private String fundingContactEmail;
    private Status fundingStatus;
    private String createdDatetime;
    private Long teamId;

    private List<FundingFileDTO> fundingFiles = new ArrayList<>();
    // VO로 변환하는 메서드
    public FundingVO toFundingVO() {
        return FundingVO.builder()
                .id(id)
                .fundingTargetAmount(fundingTargetAmount)
                .fundingCurrentAmount(fundingCurrentAmount)
                .fundingTitle(fundingTitle)
                .startDate(startDate)
                .endDate(endDate)
                .fundingDescription(fundingDescription)
                .fundingContactEmail(fundingContactEmail)
                .fundingStatus(fundingStatus)
                .teamId(teamId)
                .fundingUrl(fundingUrl)
                .build();
    }
}