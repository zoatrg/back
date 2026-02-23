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
        const response = await fetch(`/mypage/${memberId}`);
        const data = await response.json();
        if(callback){
            callback(data);
        }
    }

    // 삭제
    const deleteCareer = async (careerId) => {
        await fetch(`/mypage/${careerId}`, {method: 'DELETE'});
    }

    return {register: register, getList: getList, deleteCareer: deleteCareer};
})();
