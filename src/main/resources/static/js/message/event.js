const msgTabs = document.querySelectorAll(".tab-button");

msgTabs.forEach(addTab => {
    addTab.addEventListener("click", (e)=> {
        msgTabs.forEach(removeTab => {removeTab.classList.remove("active");})
        addTab.classList.add("active");
    })
})


document.addEventListener('DOMContentLoaded', () => {
    const chatContent = document.querySelector('.chat-content');
    const messageInput = document.getElementById('messageInput');
    const sendBtn = document.getElementById('sendBtn');
    const fileInput = document.getElementById('fileInput');

    // 1. 메시지 추가 함수 (HTML 구조 삽입)
    const appendMessage = (content, isMe = true, isImage = false) => {
        const now = new Date();
        const timeString = now.toLocaleTimeString('ko-KR', { hour: '2-digit', minute: '2-digit', hour12: true });
        
        const messageRow = document.createElement('div');
        messageRow.className = `message-row ${isMe ? 'me' : 'other'}`;

        // 이미지가 들어올 경우와 텍스트가 들어올 경우 구분
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
            // 상대방 메시지 포맷 (필요시 호출하여 사용)
            messageRow.innerHTML = `
                <div class="other-profile-area profile-area"><div class="other-profile">상대</div></div>
                <div class="other-bubble bubble">${displayContent}</div>
                <div class="other-time time">${timeString}</div>
            `;
        }

        chatContent.appendChild(messageRow);
        
        // 스크롤 아래로 이동
        chatContent.scrollTop = chatContent.scrollHeight;
    };

    // 2. 텍스트 메시지 전송 이벤트
    const handleSendMessage = () => {
        const text = messageInput.value.trim();
        if (text) {
            // 화면에 말풍선 표시
            appendMessage(text, true, false);
            messageInput.value = '';
            sendBtn.classList.remove('active');

            // 백엔드로 전송 → DB 저장
            fetch('/message/write', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    messageContent: text,
                    messageRoomId: 1,
                    senderId: 1,
                    receiverId: 2
                })
            })
            .then(response => response.text())
            .then(result => console.log('DB 저장 완료:', result));
        }
    };

    sendBtn.addEventListener('click', handleSendMessage);

    messageInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') handleSendMessage();
    });

    // 3. 입력창 상태에 따른 버튼 활성화
    messageInput.addEventListener('input', () => {
        if (messageInput.value.trim() !== '') {
            sendBtn.classList.add('active');
        } else {
            sendBtn.classList.remove('active');
        }
    });

    // 4. 파일(이미지) 전송 처리
    fileInput.addEventListener('change', (e) => {
        const file = e.target.files[0];
        if (file && file.type.startsWith('image/')) {
            const reader = new FileReader();
            reader.onload = (event) => {
                appendMessage(event.target.result, true, true);
            };
            reader.readAsDataURL(file);
        }
        // 같은 파일 재선택 가능하도록 초기화
        e.target.value = '';
    });
});