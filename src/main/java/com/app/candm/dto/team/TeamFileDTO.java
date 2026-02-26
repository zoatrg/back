package com.app.candm.dto.team;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.FileVO;
import com.app.candm.domain.FundingFileVO;
import com.app.candm.domain.TeamFileVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class TeamFileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
    private Long teamId;
    private String createdDatetime;
    private String updatedDatetime;

    public FileVO toFileVO(){
        return FileVO.builder()
                .id(id)
                .filePath(filePath)
                .fileName(fileName)
                .fileOriginalName(fileOriginalName)
                .fileSize(fileSize)
                .fileContentType(fileContentType)
                .createdDatetime(createdDatetime)
                .updatedDatetime(updatedDatetime)
                .build();
    }
    public TeamFileVO toTeamFileVO(){
        return TeamFileVO.builder()
                .id(id)
                .teamId(teamId)
                .build();
    }

}
