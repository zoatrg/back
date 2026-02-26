package com.app.candm.mapper;

import com.app.candm.dto.funding.FundingDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FundingRegistMapperTests {
    @Autowired
    private FundingMapper fundingMapper;

    @Test
    public void fundingMapperTest() {
        FundingDTO fundingDTO = new FundingDTO();
        fundingDTO.setTeamId(3L);
        fundingDTO.setFundingTitle("펀딩");
        fundingDTO.setFundingContactEmail("pundding@gmail.com");
        fundingDTO.setFundingTargetAmount(10000L);
        fundingDTO.setStartDate("2018-05-20");
        fundingDTO.setEndDate("2018-06-20");

        fundingMapper.insert(fundingDTO);
    }
}
