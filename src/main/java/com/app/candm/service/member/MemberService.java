package com.app.candm.service.member;

import com.app.candm.common.enumeration.Provider;
import com.app.candm.dto.member.MemberDTO;
import com.app.candm.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberService {
    private final MemberDAO memberDAO;

    public void join(MemberDTO memberDTO){
        memberDTO.setProvider(Provider.CANDM);
        memberDAO.save(memberDTO);
        memberDAO.saveOauth(memberDTO.toOAuthVO());
    }
}
