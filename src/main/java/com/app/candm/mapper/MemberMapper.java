package com.app.candm.mapper;

import com.app.candm.domain.OauthVO;
import com.app.candm.dto.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

//    회원가입
    public void insert(MemberDTO memberDTO);
//    oauth
    public void insertOauth(OauthVO oauthVO);

}
