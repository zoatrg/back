package com.app.candm.repository.member;

import com.app.candm.domain.MemberVO;
import com.app.candm.domain.OauthVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;
//    회원가입
    public void save(MemberDTO memberDTO){memberMapper.insert(memberDTO);}
//    카카오 회원가입
    public void saveKakao(MemberDTO memberDTO){
        memberMapper.kakaoInsert(memberDTO);
    }
//    oauth
    public void saveOauth(OauthVO oauthVO){memberMapper.insertOauth(oauthVO);}
//    이메일검사
    public Optional<MemberDTO> findByMemberEmail(String memberEmail){
        return memberMapper.selectByMemberEmail(memberEmail);
    }
//    로그인
    public Optional<MemberVO> findForLogin (MemberDTO memberDTO){
        return memberMapper.selectMemberForLogin(memberDTO);
    }
}
