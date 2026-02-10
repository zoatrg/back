package com.app.candm.repository.member;

import com.app.candm.domain.OauthVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAO {

    private final MemberMapper memberMapper;
//    회원가입
    public void save(MemberDTO memberDTO){memberMapper.insert(memberDTO);}
//    oauth
    public void saveOauth(OauthVO oauthVO){memberMapper.insertOauth(oauthVO);}
}
