package com.app.candm.mapper;

import com.app.candm.domain.FileVO;
import com.app.candm.domain.FundingFileVO;
import com.app.candm.domain.TeamFileVO;
import com.app.candm.dto.funding.FundingFileDTO;
import com.app.candm.dto.team.TeamFileDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeamFileMapper {
    //    추가
    public void insert(TeamFileVO teamFileVO);
    //    목록
    public List<TeamFileDTO> selectAllByTeamId(Long id);
    //    삭제
    public void delete(Long id);
}
