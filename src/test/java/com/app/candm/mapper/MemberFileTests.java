package com.app.candm.mapper;

import com.app.candm.dto.member.MemberFileDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MemberFileTests {

    @Autowired
    private MemberFileMapper memberFileMapper;

    @Test
    public void testInsert() {
    }

    @Test
    public void testSelect() {
        Optional<MemberFileDTO> profile = memberFileMapper.selectByMemberId(5L);

        log.info("{},,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,",profile);

    }

}
