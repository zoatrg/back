package com.app.candm.service.message;

import com.app.candm.dto.message.MessageDTO;
import com.app.candm.repository.message.MessageDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MessageService {
    private final MessageDAO messageDAO;

    // 작성
    public void write(MessageDTO messageDTO) {
        messageDAO.save(messageDTO);
    }
}
