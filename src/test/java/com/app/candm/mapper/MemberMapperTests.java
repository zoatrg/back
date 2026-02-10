package com.app.candm.mapper;

import com.app.candm.common.enumeration.Provider;
import com.app.candm.dto.member.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberMapperTests {
    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("tjdgh12@naver.com");
        memberDTO.setMemberPassword("1234");
        memberDTO.setMemberName("홍성호");
        memberDTO.setMemberPhoneNumber("01099139076");
        memberDTO.setProvider(Provider.CANDM);

        memberMapper.insert(memberDTO);
        memberMapper.insertOauth(memberDTO.toOAuthVO());
    }

}
