package com.app.candm.repository.member;

import com.app.candm.domain.FileVO;
import com.app.candm.domain.MemberFileVO;
import com.app.candm.dto.member.MemberFileDTO;
import com.app.candm.mapper.MemberFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberFileDAO {
    private final MemberFileMapper memberFileMapper;

//    프로필 추가
    public void save(MemberFileVO memberFileVO){
        memberFileMapper.profileInsert(memberFileVO);
    }

//    프로필 조회
    public Optional<MemberFileDTO> findProfileByMemberId(Long id){
        return memberFileMapper.selectByMemberId(id);
    }
}
