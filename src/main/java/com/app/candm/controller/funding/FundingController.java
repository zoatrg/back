package com.app.candm.controller.funding;

import com.app.candm.domain.FundingVO;
import com.app.candm.dto.funding.FundingDTO;
import com.app.candm.service.funding.FundingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/funding")
@RequiredArgsConstructor
@Slf4j
public class FundingController {

    private final FundingService fundingService;

    /* ================= 펀딩 등록 ================= */

    @GetMapping("/funding-regist")
    public String goToRegisterForm(@RequestParam("teamId") Long teamId, Model model) {
        FundingDTO dto = new FundingDTO();
        dto.setTeamId(teamId);
        model.addAttribute("fundingDTO", dto);
        return "funding/funding-regist";
    }

    @PostMapping("/funding-regist")
    public RedirectView register(FundingDTO fundingDTO) {
        fundingService.register(fundingDTO);

        // 🔥 funding/funding-list 로 이동
        return new RedirectView("/funding/funding-list?teamId=" + fundingDTO.getTeamId());
    }

    /* ================= 펀딩 목록 ================= */

    @GetMapping("/funding-list")
    public String showFundingList(@RequestParam("teamId") Long teamId, Model model) {
        List<FundingDTO> fundingList = fundingService.getListByTeam(teamId);
        model.addAttribute("fundingList", fundingList);
        model.addAttribute("teamId", teamId);
        return "funding/funding-list";
    }

    /* ================= 펀딩 상세 ================= */

    @GetMapping("/funding-detail")
    public String showFundingDetail(@RequestParam("fundingId") Long fundingId, Model model) {
        FundingVO funding = fundingService.getFunding(fundingId);
        model.addAttribute("funding", funding);
        return "funding/funding-detail";
    }
}
