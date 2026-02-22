const myPageLayout = (() => {
    const showList = (careers) => {
        const careerContainer = document.querySelector('.user-content-history-content-wrap');
        let text = ``;

        careers.forEach(career => {
            text += `<div class="career-card">
                <p class="career-title">${career.affiliationTitle || ''}</p>
                
                <div class="career-info">
                    <span class="career-badge">${career.memberEmploymentType || ''}</span>
                    <span class="career-badge">${career.memberRole || ''}</span>
                    <span class="career-period">${career.startTime || ''} ~ ${career.endTime || ''}</span>
                </div>
                
                <div class="career-actions">
                    <a href="javascript:void(0)" 
                       data-id="${career.id}" 
                       class="career-delete-btn">삭제</a>
                </div>
            </div>`;
        })

        careerContainer.innerHTML = text;
    }

    return {showList: showList};
})();