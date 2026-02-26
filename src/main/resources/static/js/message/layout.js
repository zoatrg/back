const messageRoomLayout = (() => {
    const showList = (messageList) => {
        const messageRoomContainer = document.querySelector('.msg-left');

        let text = ``;

        text = `
            <div class="msg-head">
                <div class="msg-search-cotainer">
                    <div class="msg-search-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="#12131466" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" > <circle cx="11" cy="11" r="8"></circle> <line x1="21" y1="21" x2="16.65" y2="16.65"></line> </svg>
                    </div>
                    <input type="text" placeholder="대화 상대 찾기">
                </div>
            </div>
            <div class="msg-tab-cotainer">
                <div class="tab-button">
                    <p>전체</p>
                </div>
                <div class="tab-button">
                    <p>사람</p>
                </div>
                <div class="tab-button active">
                    <p>기업</p>
                </div>
            </div>
        `
        messageRoomContainer.innerHTML = text;


        messageList.forEach((messageRoom) => {
            text += `
                <div class="msg-userTab">
                     <div class="userTab-container active">
                        <div class="userTab-left">
                            <div class="userTab-img">
                                <img src="../../static/image/ex/ex_profile.png" alt="프로필">
                            </div>
                        </div>
                        <div class="userTab-right">
                            <div class="userTab-wrap">
                                <div>
                                    <p class="msg-userTab-name">박하민</p>
                                </div>
                                <div>
                                    <p class="msg-userTab-overdate">1일 전</p>
                                </div>
                            </div>
                            <div class="">
                                <p class="msg-userTab-lastmsg">헹ㅇ</p>
                            </div>
                        </div>
                    </div>
                </div>
            `

        

        } )




    }

    return {showList: showList};
})();