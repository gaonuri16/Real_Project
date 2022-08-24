package com.spring.pr.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pr.answer.service.AnswerService;
import com.spring.pr.answer.service.IAnswerService;
import com.spring.pr.command.AnswerVO;
import com.spring.pr.command.FaqVO;
import com.spring.pr.faq.service.FaqService;
import com.spring.pr.faq.service.IFaqService;
import com.spring.pr.util.PageCreater;
import com.spring.pr.util.PageVO;

@Controller
@RequestMapping("/faqans")
public class FaqAnsController {
	
	// 화면 확인용 controller 
	
	@Autowired
	private IFaqService faqService;
	
	@Autowired
	private IAnswerService ansService;
	
	@GetMapping("/write")
	public String write() {
		System.out.println("/faqans/write : GET");
		
		return "faq/faq_regist";
	}

	@PostMapping("/faqWrite")
	public String write_file(FaqVO faq, MultipartHttpServletRequest files) {
		// 여러 파일이 controller로 들어오기 때문에 MultipartHttpServletRequest 인터페이스를 통해 
		// 가져올 수 있음 
		
		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);
		
		
		// 서버에서 파일을 저장할 경로 
		String uploadPath = "/Users/sig6774/Desktop/Project_Workspace/IMAGE/FAQ"+filelocation;
		
		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}
		
		List<MultipartFile> fileList = files.getFiles("File");
		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		System.out.println("/faqans/faqWrite : POST ");
		

		for (MultipartFile file : fileList) {
			try {
				
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
//				System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄
				
				faq.setFaqFile(uploadPath + "/" + fileName);
				faq.setFaqFileReal(fileRealName);
				faq.setJOINID("userid");
				faqService.regist(faq);
			}
			// 반복문을 활용하여 값을 넣을 수 있음 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/faqans/list";
	}
	
	@GetMapping("/ansRegi/{faqNum}")
	public String move_ans(@PathVariable int faqNum,  Model model, PageVO page) {
		System.out.println("/faqans/ansRegi : GET");
		
		System.out.println("페이지 정보를 가지고 오는지 확인 : " + page.toString());
		model.addAttribute("pageInfo", page);
		
		faqService.upHit(faqNum);

		FaqVO faq = faqService.getContent(faqNum);
		
//		ansService.getContent(AnsNum)
		// 조회수 증가 로직 

		model.addAttribute("faq", faq);
		return "faq/faq_ans_regist";
	} 
	
	@PostMapping("/ansWrite")
	public String write_ans_file(AnswerVO ans, MultipartHttpServletRequest files) {
		// 여러 파일이 controller로 들어오기 때문에 MultipartHttpServletRequest 인터페이스를 통해 
		// 가져올 수 있음 
		
		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);
		
		
		// 서버에서 파일을 저장할 경로 
		String uploadPath = "/Users/sig6774/Desktop/Project_Workspace/IMAGE/ANSWER"+filelocation;
		
		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}
		
		List<MultipartFile> fileList = files.getFiles("File");
		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		System.out.println("/faqans/ansWrite : POST ");
		

		for (MultipartFile file : fileList) {
			try {
				
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
//				System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄
				
				ans.setAnsFile(uploadPath + "/" + fileName);
				ans.setAnsFileReal(fileRealName);
				ans.setMngrId("managerId");
				System.out.println("답변 내용 :  "+ ans.toString());
				ansService.regist(ans);
				
			}
			// 반복문을 활용하여 값을 넣을 수 있음 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/faqans/list";
	}
	
	
	@GetMapping("/list")
	public String listNotice(PageVO page, Model model) {
		System.out.println("faq/faq_list : GET");
		System.out.println(faqService.getList(page));
		model.addAttribute("faqList",faqService.getList(page));
		
		
		PageCreater pct = new PageCreater();
		pct.setPaging(page);
		pct.setArticleTotalCount(faqService.getTotal(page));
		System.out.println("페이지 객체 확인 : " + pct.toString());
		model.addAttribute("pct", pct);
		// 페이지 정보를 모델에 pct라는 이름으로 보내줌 

		return "faq/faq_list";
	}
	
	@GetMapping("/content/{faqNum}")
	public String contentBoard(@PathVariable int faqNum,  Model model) {
		System.out.println("/faqans/content : GET");
//		System.out.println("페이지 정보를 가지고 오는지 확인 : " + page.toStri  ng());
		System.out.println("페이지 번호 : " + faqNum);
//		model.addAttribute("pageInfo", page);
		
		faqService.upHit(faqNum);

		FaqVO faq = faqService.getContent(faqNum);
		// 여기서 못가져오는 것 같음 .. 
//		System.out.println("질문 내용 가져오는지 확인 " + faq);

		
//		ansService.getContent(AnsNum)
		// 조회수 증가 로직 

		model.addAttribute("faq", faq);
		
		
		AnswerVO ans = ansService.getContent(faqNum);
		
		if (ans != null) {
			System.out.println("답변 내용 가져오는지 확인 " + ans);
			ansService.upHit(ans.getAnsNum());

			model.addAttribute("ans", ans);
		}


		return "faq/faq_detail";
	}
	
	@GetMapping("/registAns/{faqNum}")
	public String registAns(@PathVariable int faqNum,  Model model, PageVO page) {
		System.out.println("/faqans/registAns : GET");
		System.out.println("페이지 정보를 가지고 오는지 확인 : " + page.toString());
		model.addAttribute("pageInfo", page);
		
		faqService.upHit(faqNum);

		FaqVO faq = faqService.getContent(faqNum);
		
//		ansService.getContent(AnsNum)
		// 조회수 증가 로직 

		model.addAttribute("faq", faq);

		return "faq/faq_ans_regist";
	}
	
	@GetMapping("/download")
	@ResponseBody
	public ResponseEntity<byte[]> download(@RequestParam("fileloca") String filelocation) {
		System.out.println("faqans/download : GET ");
		System.out.println("download 요청 값 가져오는지 확인 : " + filelocation );
		
		File file = new File(filelocation);
		
		ResponseEntity<byte[]> result = null;
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Disposition", "attachment; filename=" + filelocation);
		// 파일 명 변경할 수 있음 근데 각 파일마다 확장자를 붙여서 넣어줘야함 		
		
		try {
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@GetMapping("/faqmodify")
	public String moveModify(@RequestParam("num") int faqNum, Model model) {
		System.out.println("/faqans/faqmodify : GET");
		System.out.println("faq 수정 번호 확인 : " + faqNum );
		
		model.addAttribute("modifaq", faqService.getContent(faqNum)); 
		
		return "faq/faq_modify";
	}
	
	@PostMapping("/modify")
	public String update(FaqVO faq, RedirectAttributes ra, MultipartHttpServletRequest files) {
		System.out.println("/faqans/modify : POST");
		System.out.println("수정 내용 : " + faq.toString());
		
		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);
		
		
		// 서버에서 파일을 저장할 경로 
		String uploadPath = "/Users/sig6774/Desktop/Project_Workspace/IMAGE/FAQ"+filelocation;
		
		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}
		
		// 수정할 때 파일이 없으면 수정 안되는 현상 고치기 
		List<MultipartFile> fileList = files.getFiles("File");
		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		

		for (MultipartFile file : fileList) {
			try {
				
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
//						System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄
				
				faq.setFaqFile(uploadPath + "/" + fileName);
				faq.setFaqFileReal(fileRealName);
				System.out.println("수정 faq 내용 가져오는지 확인 " + faq);

				faqService.update(faq);
			}
			// 반복문을 활용하여 값을 넣을 수 있음 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/faqans/list";
	}
	
	@GetMapping("/ansmodify")
	public String moveModifyans(@RequestParam("num") int faqNum, Model model) {
		System.out.println("/faqans/ansmodify : GET");
		System.out.println("faq 수정 번호 확인 : " + faqNum );
		
		model.addAttribute("faq", faqService.getContent(faqNum)); 
		
		model.addAttribute("ans", ansService.getContent(faqNum));
		
		return "faq/faq_ans_modify";
	}
	
	
	@PostMapping("/ansmodifyreal")
	public String update(AnswerVO ans, RedirectAttributes ra, MultipartHttpServletRequest files) {
		System.out.println("/faqans/ansmodifyreal : POST");
		System.out.println("수정 내용 : " + ans.toString());
		
		// 날짜별로 폴더 생성해서 파일 관리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String filelocation = sdf.format(date);
		
		
		// 서버에서 파일을 저장할 경로 
		String uploadPath = "/Users/sig6774/Desktop/Project_Workspace/IMAGE/FAQ"+filelocation;
		
		File folder = new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs();
			// 폴더가 없다면 상위 폴더까지 모두 생성 
		}
		
		// 수정할 때 파일이 없으면 수정 안되는 현상 고치기 
		List<MultipartFile> fileList = files.getFiles("File");
		// getFiles안에는 Controller로 들어오는 파라미터 이름을 작성하면 list형태로 받을 수 있음
		

		for (MultipartFile file : fileList) {
			try {
				
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
//						System.out.println(saveFile.toString());

				file.transferTo(saveFile);
				// 위에서 지정한 경로로 값을 보냄
				
				ans.setAnsFile(uploadPath + "/" + fileName);
				ans.setAnsFileReal(fileRealName);
				System.out.println("수정 ans 내용 가져오는지 확인 " + ans);

				ansService.update(ans);
			}
			// 반복문을 활용하여 값을 넣을 수 있음 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/faqans/list";
	}
	
	@GetMapping("/faqdelete/{faqNum}")
	public String deleteFaq(@PathVariable int faqNum, RedirectAttributes ra) {
		System.out.println("삭제 요청 파라미터 가져오는지 확인 : " + faqNum);
		faqService.delete(faqNum);
		
		return "redirect:/faqans/list";
	}
	
	@GetMapping("/ansdelete/{ansNum}")
	public String deleteAns(@PathVariable int ansNum, RedirectAttributes ra) {
		System.out.println("삭제 요청 파라미터 가져오는지 확인 : " + ansNum);
		ansService.delete(ansNum);
		
		return "redirect:/faqans/list";
	}

}