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

    return {sendMessage:sendMessage}
})();
