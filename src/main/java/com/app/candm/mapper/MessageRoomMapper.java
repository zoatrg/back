package com.app.candm.mapper;

import com.app.candm.dto.message.MessageRoomDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageRoomMapper {
    // 방 생성
    public void insert(MessageRoomDTO messageRoomDTO);

    // 내 채팅방 목록
    public List<MessageRoomDTO> selectAllByMemberId(Long memberId);
}
