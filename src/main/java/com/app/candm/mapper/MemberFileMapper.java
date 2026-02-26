package com.app.candm.mapper;

import com.app.candm.domain.MemberFileVO;
import com.app.candm.dto.member.MemberFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberFileMapper {
//    프로필사진 추가
    public void profileInsert(MemberFileVO memberFileVO);

//    프로필 조회
    public Optional<MemberFileDTO> selectByMemberId(Long id);

}
