const myPageService = (() => {

//     추가
    const register = async (career) => {
        await fetch('/mypage/regist', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(career)
        })
    }

    // 목록
    const getList = async (memberId, callback) => {
        const response = await fetch(`/mypage?memberId=${memberId}`);
        const careers = await response.json();
        if(callback){
            callback(careers);
        }
    }


    return {register: register, getList: getList};
})();
