const loginForm = document.querySelector(".login-form");
const loginButton = document.querySelector(".goingbutton");
const allInputs = document.querySelectorAll("input");
console.log(allInputs);


if(login ==="fail"){
    alert("아이디 또는 비밀번호를 다시 확인해주세요")
}

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    let isAllFilled = true;

    allInputs.forEach(input => {
        if(input.value.trim() === "") {
            isAllFilled = false;
        }
    })

    if(!isAllFilled) {
        alert("아이디 또는 비밀번호를 입력해주세요.")
        return;
    }

    loginForm.submit();

})

const kakaoButton = document.querySelector(".fourth-button");
kakaoButton.addEventListener("click", (e) =>{
    location.href = "https://kauth.kakao.com/oauth/authorize?client_id=6453f1e570d210ce0a85c1a67c2f5c3f&redirect_uri=http://3.34.50.211:10000/kakao/login&response_type=code";
});
