package com.app.candm.service.member;

import com.app.candm.common.enumeration.Provider;
import com.app.candm.common.exception.LoginFailException;
import com.app.candm.domain.MemberVO;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberService {
    private final MemberDAO memberDAO;

//    이메일 검사(true: 사용가능)
    public boolean checkEmail(String memberEmail){
        return memberDAO.findByMemberEmail(memberEmail).isEmpty();
    }

//    화면 실제 회원가입
    public void join(MemberDTO memberDTO){
        memberDTO.setProvider(Provider.CANDM);
        memberDAO.save(memberDTO);
        memberDAO.saveOauth(memberDTO.toOauthVO());
    }

//    화면 실제 로그인
    public MemberDTO login(MemberDTO memberDTO){
        Optional<MemberVO> foundmember = memberDAO.findForLogin(memberDTO);
        return toDTO(foundmember.orElseThrow(LoginFailException::new));
    }

    public MemberDTO toDTO(MemberVO memberVO){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberVO.getId());
        memberDTO.setMemberEmail(memberVO.getMemberEmail());
        memberDTO.setMemberPassword(memberVO.getMemberPassword());
        memberDTO.setMemberName(memberVO.getMemberName());
        memberDTO.setMemberPhoneNumber(memberVO.getMemberPhoneNumber());
        memberDTO.setCreatedDatetime(memberVO.getCreatedDatetime());
        memberDTO.setUpdatedDatetime(memberVO.getUpdatedDatetime());
        return memberDTO;
    }
}
