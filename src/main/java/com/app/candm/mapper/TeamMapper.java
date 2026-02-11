package com.app.candm.mapper;

import com.app.candm.dto.TeamDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeamMapper {
//    추가
    public void insert(TeamDTO  teamDTO);
}
