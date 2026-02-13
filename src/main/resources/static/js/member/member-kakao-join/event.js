const joinBtn = document.querySelector('.goingbutton');
const allInputs = document.querySelectorAll("input");
console.log(allInputs);

joinBtn.addEventListener("click", (e) => {
    e.preventDefault();
    let isAllFilled = true;

    allInputs.forEach(input => {
        if(input.value.trim() === ""){
            isAllFilled = false;
        }
    })

    if(!isAllFilled){
        alert(" 핸드폰 번호를 입력해주세요.")
        return;
    }

    if(isAllFilled) {
        document.joinForm.submit();
    }
});