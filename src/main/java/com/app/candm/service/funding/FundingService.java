package com.app.candm.service.funding;

import com.app.candm.common.enumeration.FileContentType;
import com.app.candm.domain.FundingVO;
import com.app.candm.dto.FileDTO;
import com.app.candm.dto.funding.FundingDTO;
import com.app.candm.dto.funding.FundingFileDTO;
import com.app.candm.repository.FileDAO;
import com.app.candm.repository.funding.FundingDAO;
import com.app.candm.repository.funding.FundingFileDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class FundingService {
    private final FundingDAO fundingDAO;
    private final FileDAO fileDAO;
    private final FundingFileDAO fundingFileDAO;

    // 펀딩 신규 등록
    public void register(FundingDTO fundingDTO) {
        log.info("Registering new funding: {}", fundingDTO);

        fundingDAO.save(fundingDTO);
    }

    // 특정 팀의 펀딩 목록 조회
    @Transactional(readOnly = true)
    public List<FundingDTO> getListByTeam(Long teamId) {
        return fundingDAO.findAllByTeamId(teamId);
    }

    // 펀딩 상세 정보 조회
    @Transactional(readOnly = true)
    public FundingVO getFunding(Long id) {
        return fundingDAO.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 펀딩이 존재하지 않습니다. ID: " + id)).toFundingVO();
    }

    // 펀딩 상태 변경 (승인/거절 또는 활성/비활성)
    public void changeStatus(Long id, String status) {
        fundingDAO.updateStatus(id, status);
    }

    // 파일
    public void write(FundingDTO fundingDTO, ArrayList<MultipartFile> multipartFiles) {
        String rootPath = "C:/file/";
        String todayPath = getTodayPath();
        String path = rootPath + todayPath;

        FileDTO fileDTO = new FileDTO();
        FundingFileDTO fundingFileDTO = new FundingFileDTO();


        fundingFileDTO.setFundingId(fundingDTO.getId());
        multipartFiles.forEach(multipartFile -> {
            if(multipartFile.getOriginalFilename().isEmpty()){
                return;
            }
            UUID uuid = UUID.randomUUID();
            fileDTO.setFilePath(todayPath);
            fileDTO.setFileSize(String.valueOf(multipartFile.getSize()));
            fileDTO.setFileOriginalName(multipartFile.getOriginalFilename());
            fileDTO.setFileName(uuid.toString() + "_" + multipartFile.getOriginalFilename());
            fileDTO.setFileContentType(multipartFile.getContentType().contains("image") ? FileContentType.IMAGE : FileContentType.OTHER);
            fileDAO.save(fileDTO);

            fundingFileDTO.setId(fileDTO.getId());
            fundingFileDAO.save(fundingFileDTO.toFundingFileVO());

            File directory = new File(rootPath + "/" + fileDTO.getFilePath());
            if(!directory.exists()){
                directory.mkdirs();
            }
            try {
                multipartFile.transferTo(new File(path, fileDTO.getFileName()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public String getTodayPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }
}