package com.app.candm.repository.team;

import com.app.candm.domain.FundingFileVO;
import com.app.candm.domain.TeamFileVO;
import com.app.candm.dto.funding.FundingFileDTO;
import com.app.candm.dto.team.TeamFileDTO;
import com.app.candm.mapper.TeamFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamFileDAO {
    private final TeamFileMapper teamFileMapper;

    //    추가
    public void save(TeamFileVO teamFileVO) {
        teamFileMapper.insert(teamFileVO);
    }

    //    목록
    public List<TeamFileDTO> findAllByTeamId(Long id) {
        return teamFileMapper.selectAllByTeamId(id);
    }

    //    삭제
    public void delete(Long id){
        teamFileMapper.delete(id);
    }

}
