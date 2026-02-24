package com.app.candm.repository.mypage;

import com.app.candm.dto.FileDTO;
import com.app.candm.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository( "mypagefileDAO")
@RequiredArgsConstructor
public class FileDAO {
    private final FileMapper fileMapper;

    //    추가
    public void save(FileDTO fileDTO) {
        fileMapper.insert(fileDTO);
    }
}
