myProfileService = (() => {

//     추가
    const profileRegister = async (formData) => {
        await fetch('/mypage/profile/regist', {
            method: 'POST',
            body: formData
        })

    }

    const profileSelect = async (memberId, callback) => {
        const response = await fetch(`/mypage/profile/${memberId}`);
        const profile = await response.json();
        if(callback){
            callback(profile);
        }
    }

    return {profileRegister: profileRegister, profileSelect: profileSelect};
})();