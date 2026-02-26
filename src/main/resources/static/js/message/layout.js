const messageLayout = (() => {

    const userTabContainer = document.querySelector('.msg-userTab');

    // 시간 포맷 (방금 전, n분 전, n시간 전, n일 전)
    const formatTimeAgo = (datetime) => {
        if (!datetime) return '';
        const now = new Date();
        const target = new Date(datetime);
        const diff = Math.floor((now - target) / 1000);

        if (diff < 60) return '방금 전';
        if (diff < 3600) return `${Math.floor(diff / 60)}분 전`;
        if (diff < 86400) return `${Math.floor(diff / 3600)}시간 전`;
        return `${Math.floor(diff / 86400)}일 전`;
    };

    // 채팅방 목록 렌더링
    const renderRoomList = (rooms) => {
        userTabContainer.innerHTML = '';

        if (!rooms || rooms.length === 0) {
            userTabContainer.innerHTML = `
                <div class="none-container">
                    <div class="none-wrap">
                        <p class="none-title">채팅 목록이 없습니다.</p>
                        <p class="none-content">새로운 메시지를 보내 대화를 시작해보세요.</p>
                    </div>
                </div>
            `;
            return;
        }

        rooms.forEach((room) => {
            const roomEl = document.createElement('div');
            roomEl.className = 'userTab-container';
            roomEl.dataset.roomId = room.messageRoomId;
            roomEl.dataset.memberId = room.invitedMemberId;
            roomEl.dataset.memberName = room.memberName;

            roomEl.innerHTML = `
                <div class="userTab-left">
                    <div class="userTab-img">
                        <div class="other-profile">${room.memberName.charAt(0)}</div>
                    </div>
                </div>
                <div class="userTab-right">
                    <div class="userTab-wrap">
                        <div>
                            <p class="msg-userTab-name">${room.memberName}</p>
                        </div>
                        <div>
                            <p class="msg-userTab-overdate">${formatTimeAgo(room.notificationDatetime)}</p>
                        </div>
                    </div>
                    <div>
                        <p class="msg-userTab-lastmsg">${room.messageContent}</p>
                    </div>
                </div>
            `;

            userTabContainer.appendChild(roomEl);
        });
    };

    return { renderRoomList };
})();
