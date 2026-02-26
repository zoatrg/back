// 더미 로그인 유저 ID (세션 적용 시 교체)
const CURRENT_MEMBER_ID = 2;

const msgTabs = document.querySelectorAll(".tab-button");

msgTabs.forEach(addTab => {
    addTab.addEventListener("click", (e) => {
        msgTabs.forEach(removeTab => { removeTab.classList.remove("active"); })
        addTab.classList.add("active");
    })
})

document.addEventListener('DOMContentLoaded', async () => {
    const messageInput = document.getElementById('messageInput');
    const sendBtn = document.getElementById('sendBtn');
    const fileInput = document.getElementById('fileInput');
    const msgRight = document.querySelector('.msg-right');
    const noneContainer = msgRight.querySelector('.none-container');
    const userTabContainer = document.querySelector('.msg-userTab');

    // 현재 선택된 채팅방 상태
    let currentRoomId = null;
    let currentReceiverId = null;

    // chat-content 영역 동적 생성
    let chatContent = msgRight.querySelector('.chat-content');
    if (!chatContent) {
        chatContent = document.createElement('div');
        chatContent.className = 'chat-content';
        chatContent.style.display = 'none';
        noneContainer.after(chatContent);
    }

    // 페이지 로드 시 채팅방 목록 불러오기
    const rooms = await messageService.selectMessageList(CURRENT_MEMBER_ID);
    messageLayout.renderRoomList(rooms);

    // 1. 메시지 추가 함수
    const appendMessage = (content, isMe = true, isImage = false) => {
        const now = new Date();
        const timeString = now.toLocaleTimeString('ko-KR', { hour: '2-digit', minute: '2-digit', hour12: true });

        const messageRow = document.createElement('div');
        messageRow.className = `message-row ${isMe ? 'me' : 'other'}`;

        const displayContent = isImage ? `<img src="${content}" style="max-width: 100%; border-radius: 8px;">` : content;

        if (isMe) {
            messageRow.innerHTML = `
                <div class="me-bubble bubble">${displayContent}</div>
                <div class="me-status-group status-group">
                    <div class="me-read-status read-status">1</div>
                    <div class="me-time time">${timeString}</div>
                </div>
            `;
        } else {
            messageRow.innerHTML = `
                <div class="other-profile-area profile-area"><div class="other-profile">상대</div></div>
                <div class="other-bubble bubble">${displayContent}</div>
                <div class="other-time time">${timeString}</div>
            `;
        }

        chatContent.appendChild(messageRow);
        chatContent.scrollTop = chatContent.scrollHeight;
    };

    // 2. 채팅방 클릭 이벤트
    userTabContainer.addEventListener('click', (e) => {
        const roomEl = e.target.closest('.userTab-container');
        if (!roomEl) return;

        // 활성 탭 변경
        document.querySelectorAll('.userTab-container').forEach(el => el.classList.remove('active'));
        roomEl.classList.add('active');

        // 상태 업데이트
        currentRoomId = Number(roomEl.dataset.roomId);
        currentReceiverId = Number(roomEl.dataset.memberId);

        // 채팅 영역 활성화
        noneContainer.style.display = 'none';
        chatContent.style.display = '';
        chatContent.innerHTML = '';
    });

    // 3. 텍스트 메시지 전송
    const handleSendMessage = async () => {
        const text = messageInput.value.trim();
        if (!text || !currentReceiverId) return;

        appendMessage(text, true, false);

        await messageService.sendMessage({
            messageContent: text,
            senderId: CURRENT_MEMBER_ID,
            receiverId: currentReceiverId
        });

        messageInput.value = '';
        sendBtn.classList.remove('active');

        // 채팅방 목록 갱신
        const updatedRooms = await messageService.selectMessageList(CURRENT_MEMBER_ID);
        messageLayout.renderRoomList(updatedRooms);

        // 현재 선택된 방 다시 active 처리
        const activeRoom = userTabContainer.querySelector(`[data-room-id="${currentRoomId}"]`);
        if (activeRoom) activeRoom.classList.add('active');
    };

    sendBtn.addEventListener('click', handleSendMessage);

    messageInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') handleSendMessage();
    });

    // 4. 입력창 상태에 따른 버튼 활성화
    messageInput.addEventListener('input', () => {
        if (messageInput.value.trim() !== '') {
            sendBtn.classList.add('active');
        } else {
            sendBtn.classList.remove('active');
        }
    });

    // 5. 파일(이미지) 전송 처리
    fileInput.addEventListener('change', (e) => {
        const file = e.target.files[0];
        if (file && file.type.startsWith('image/')) {
            const reader = new FileReader();
            reader.onload = (event) => {
                appendMessage(event.target.result, true, true);
            };
            reader.readAsDataURL(file);
        }
        e.target.value = '';
    });
});
