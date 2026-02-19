package com.app.candm.repository.message;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageDAO {
    private final MessageMapper messageMapper;

    // 작성
    public void save(MessageDTO messageDTO) {
        messageMapper.insert(messageDTO);
    }
}
