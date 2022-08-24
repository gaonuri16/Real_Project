package com.spring.pr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pr.command.GhVO;
import com.spring.pr.gh.service.IGhService;

@Controller
@RequestMapping("/apply")
public class GhController {

	@Autowired
	private IGhService service;

	//일반 조력자 기본정보 등록 화면
	@GetMapping("/ghRegist")
	public void ghRegist() {}

	//일반 조력자 기본정보 등록 처리
	@PostMapping("/ghRegistForm")
	public String registForm(GhVO gh, @RequestParam("file") List<MultipartFile> fileList, RedirectAttributes ra) {
		// 여러 파일이 controller로 들어오기 때문에 MultipartHttpServletRequest 인터페이스를 통해 
		// 가져올 수 있음 

		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);


		// 서버에서 파일을 저장할 경로 
		String uploadPath = "/Users/sig6774/Desktop/Project_Workspace/IMAGE/gh" + filelocation;

		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}

		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		System.out.println("/apply/ghRegist : POST ");

		try {
			
			int idx = 0;
			for (MultipartFile file : fileList) {
				
				
				// 파일 명을 고유한 랜덤 문자로 생성
				UUID uuid = UUID.randomUUID();
				String uuids = uuid.toString().replaceAll("-", "");

				String fileRealName = file.getOriginalFilename();
				// 파일 이름 가져오기

				long size = file.getSize();
				// 파일 크기 가져오기 

				String fileExtention = fileRealName.substring(fileRealName.indexOf("."), fileRealName.length());
				String fileName = uuids + fileExtention;


				System.out.println("파일 이름 : " + fileName);
				System.out.println("파일 크기 : " + size);
				System.out.println("폴더명: " + filelocation);

				File saveFile = new File(uploadPath + "\\" + fileName);
				// File객체를 사용해서 경로 지정 
				// System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄
				
				if(idx == 0) {
					gh.setGhAcadBackFile(uploadPath + "\\" + fileName);
					gh.setGhAcadBackFileReal(fileRealName);					
				} else {
					gh.setGhCarrerFile(uploadPath + "\\" + fileName);
					gh.setGhCarrerFileReal(fileRealName);					
				}
				idx++;
			}
			
			System.out.println(gh);
			service.regist(gh);
		}
		// 반복문을 활용하여 값을 넣을 수 있음 
		catch (Exception e) {
			e.printStackTrace();
		}


		ra.addFlashAttribute("msg", "정상 등록 처리되었습니다.");
		return "redirect:/apply/success";
	}	

}
