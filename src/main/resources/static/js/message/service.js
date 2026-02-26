const messageService = (() => {

//     추가
    const sendMessage = async (message) => {
        await fetch('/message/send', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(message)
        })
    }
    const selectMessageList = async (memberId) => {
        const response = await fetch(`/message/list?memberId=${memberId}`);
        return await response.json();
    }

    return {sendMessage:sendMessage,
            selectMessageList:selectMessageList
    }
})();


