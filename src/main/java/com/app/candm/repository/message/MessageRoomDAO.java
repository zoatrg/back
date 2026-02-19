package com.app.candm.repository.message;

import com.app.candm.dto.message.MessageRoomDTO;
import com.app.candm.mapper.MessageRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MessageRoomDAO {
    private final MessageRoomMapper messageRoomMapper;

    // 방 생성
    public void save(MessageRoomDTO messageRoomDTO) {
        messageRoomMapper.insert(messageRoomDTO);
    }
}
