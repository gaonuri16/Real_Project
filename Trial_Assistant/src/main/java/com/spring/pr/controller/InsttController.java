package com.spring.pr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pr.command.FaqVO;
import com.spring.pr.command.InsttVO;
import com.spring.pr.instt.service.InsttService;
import com.spring.pr.util.ExcelRequestManager;

@RequestMapping("/apply")
@Controller
public class InsttController {

	@Autowired
	private InsttService service;

	//기관 신청 화면
	@GetMapping("insttRegist")
	public void insttRegist() {}

	@PostMapping("/insttRegistForm")
	public String createApplicant_action(
			@ModelAttribute("insttVO") InsttVO instt,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request,
			MultipartHttpServletRequest multiRequest,
			ModelMap model) {

		Map<String, Object> resMap = new HashMap<String, Object>();


		try {

			ExcelRequestManager em = new ExcelRequestManager();
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			List<HashMap<String, String>> apply = null; 

			apply = em.parseExcelSpringMultiPart(files,"applicant", 0, "", "reserve");

			for(int i = 0; i < apply.size(); i++) {
				instt.setInsttName(apply.get(i).get("cell_0"));
				instt.setInsttSocNum(apply.get(i).get("cell_1"));
				instt.setInsttHomeNum(apply.get(i).get("cell_2"));
				instt.setInsttPhoneNum(apply.get(i).get("cell_3"));
				instt.setInsttJob(apply.get(i).get("cell_4"));
				instt.setInsttEmail(apply.get(i).get("cell_5"));
				instt.setInsttDtlSrttn(apply.get(i).get("cell_6"));
				instt.setInsttSrttn(apply.get(i).get("cell_7"));
				instt.setInsttBsnsNum(apply.get(i).get("cell_8"));
				instt.setInsttFax(apply.get(i).get("cell_9"));
				instt.setInsttOfcName(apply.get(i).get("cell_10"));
				instt.setInsttAcadBack(apply.get(i).get("cell_11"));
				instt.setInsttCarrer(apply.get(i).get("cell_12"));
				instt.setInsttBank(apply.get(i).get("cell_13"));
				instt.setInsttAccHol(apply.get(i).get("cell_14"));
				instt.setInsttBankNum(apply.get(i).get("cell_15"));
				instt.setInsttPostNum(apply.get(i).get("cell_16"));
				instt.setInsttAddr(apply.get(i).get("cell_17"));
				instt.setInsttDtlAddr(apply.get(i).get("cell_18"));
				System.out.println(instt.toString());
				service.regist(instt);

			}


			resMap.put("res", "ok");
			resMap.put("msg", "txt.success");
			System.out.println(resMap.toString());

		}
		catch(Exception e){
			System.out.println(e.toString());
			resMap.put("res", "error"); 
			resMap.put("msg", "txt.fial"); 
		}

		redirectAttributes.addFlashAttribute("resMap", resMap);
		return "apply/insttRegist";

	}

	@PostMapping("/insttFile")
	public String insttFile(InsttVO instt, MultipartHttpServletRequest files) {
		// 여러 파일이 controller로 들어오기 때문에 MultipartHttpServletRequest 인터페이스를 통해 
		// 가져올 수 있음 

		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);


		// 서버에서 파일을 저장할 경로 
		String uploadPath = "C:\\Users\\user\\Desktop\\upload" + filelocation;

		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}

		List<MultipartFile> fileList = files.getFiles("File");
		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		System.out.println("/apply/insttFile: POST ");


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

				File saveFile = new File(uploadPath + "/" + fileName);
				// File객체를 사용해서 경로 지정 
				// System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄

				if(idx == 0) {
					instt.setInsttAcadBackFile(uploadPath + "\\" + fileName);
					instt.setInsttAcadBackFileReal(fileRealName);					
				} else {
					instt.setInsttCarrerFile(uploadPath + "\\" + fileName);
					instt.setInsttCarrerFileReal(fileRealName);					
				}
				idx++;
			}

			System.out.println(instt);
			service.regist(instt);
		}
		// 반복문을 활용하여 값을 넣을 수 있음 
		catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/apply/success";

	}

}
