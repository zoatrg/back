package com.app.candm.mapper;

import com.app.candm.dto.message.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MessageMapperTests {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    public void testInsert() {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setSenderId(1L);
        messageDTO.setReceiverId(2L);
        messageDTO.setMessageContent("집에가고싶다");
        messageDTO.setMessageRoomId(1L);
        messageMapper.insert(messageDTO);
    }
}
