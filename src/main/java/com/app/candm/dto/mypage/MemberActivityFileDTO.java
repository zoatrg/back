package com.app.candm.dto.mypage;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.FileVO;
import com.app.candm.domain.MemberActivityFileVO;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of="id")
@NoArgsConstructor
public class MemberActivityFileDTO {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileOriginalName;
    private String fileSize;
    private FileContentType fileContentType;
    private Long memberId;
    private Long memberActivityId;
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

    public MemberActivityFileVO toMemberActivityFileVO(){
        return MemberActivityFileVO.builder()
                .id(id)
                .memberId(memberId)
                .memberActivityId(memberActivityId)
                .build();
    }
}
