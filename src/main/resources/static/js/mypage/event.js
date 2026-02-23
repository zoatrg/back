const modalTabbtns = document.querySelectorAll(".modal-sidebar .tab-container");
const changeModalBtns = document.querySelectorAll(".modal-detail .change");
// const modalTabbtn = () => {
    
// }

// 마이페이지 LNB영역 버튼 이벤트
modalTabbtns.forEach(modalTabbtn => {
    modalTabbtn.addEventListener("click", (e) => {
        modalTabbtns.forEach(modalTabbtn => modalTabbtn.classList.remove("active"));
        modalTabbtn.classList.add("active");
    })
    modalTabbtn.addEventListener("mousedown", (e) => {
        modalTabbtn.classList.add("down");
    })
    modalTabbtn.addEventListener("mouseup", (e) => {
        modalTabbtn.classList.remove("down");
    })
    modalTabbtn.addEventListener("mouseout", (e) => {
        modalTabbtn.classList.remove("down");
    })
    
})

changeModalBtns.forEach(changeModalBtn => {
    changeModalBtn.addEventListener("click", (e) => {
        const forms = document.querySelectorAll("#form-modal .form-group");
        const _this = e.currentTarget.id.replace("Change", "");
        const _thisForm = document.getElementById(_this+"Form");
        forms.forEach(form => {
            form.classList.add("none");
        })
        _thisForm.classList.remove("none")
    })
})

const registerBtn = document.getElementById("save-career-btn");
const affilationTitle = document.getElementById("career-company");
const careerType = document.getElementById("career-type");
const startYear = document.getElementById("career-start-year");
const endYear = document.getElementById("career-end-year");
const startMonth = document.getElementById("career-start-month");
const endMonth = document.getElementById("career-end-month");
const careerSkill = document.getElementById("career-skills");
const careerRole = document.getElementById("career-role");
const careerDescription = document.getElementById("career-desc");
let memberId = null;
const memberIdInput = document.getElementById("member-id");
const closeModal = document.getElementById("career-modal");
const careerInput = document.querySelector(".modal-container");
const careerContainer = document.querySelector('.user-content-history-content-wrap');

console.log(careerInput)

if(memberIdInput){
    memberId = memberIdInput.value;
}


myPageService.getList(memberId, myPageLayout.showList);

registerBtn.addEventListener("click", async (e) => {
    await myPageService.register(
        {
            affiliationTitle : affilationTitle.value,
            memberEmploymentType : careerType.value,
            startYear : startYear.value,
            endYear : endYear.value,
            startMonth : startMonth.value,
            endMonth : endMonth.value,
            memberSkill : careerSkill.value,
            memberRole : careerRole.value,
            introDetailed : careerDescription.value,
            memberId : memberId
        });
    await myPageService.getList(memberId, myPageLayout.showList);

    careerInput.querySelectorAll("input", "textarea", "select").forEach(input => {
        if(input.type === "select"){
            input.selectedIndex = 0;
        } else {
            input.value = "";
        }
    });
    closeModal.style.display = "none";
})


careerContainer.addEventListener("click", async (e) => {
    e.preventDefault();
    const careerId = e.target.dataset.id;

    if(e.target.classList.contains("career-delete-btn")){
        await myPageService.deleteCareer(careerId);
        await myPageService.getList(memberId, myPageLayout.showList);
    }
})