package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.MemberCriteria;
import com.kb.domain.MemberPageDTO;
import com.kb.domain.MemberVO;
import com.kb.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 이 컨트롤러에 사용되는 애들은 다 member다.
@RequestMapping("/member/*")
@Controller
@Log4j
@AllArgsConstructor
public class MemberController {
	
	//service 객체 생성 
	//service.메소드() 호출하여 매퍼까지 호출 가능
	private MemberService service;
	
	//controller에서 값을 view에 줄 때 request.setAttribute사용했음.
	//그게 spring에서는 model이다.
	
	// /member/list
//	@GetMapping("list")
//	public void list(Model model) {
//		//얘가 list로 오면 목록을 찍어라.
//		//파일이 없을 때는 당연히 웹에 나오지 않지만 console에는 목록이 찍힌다.
//		log.info("목록");
//		//view에다 값을 던지는 것.
//		//<collection>에 해당한다. 컨트롤러에서 뷰로 모델을 통해 값을 전달한다.
//		model.addAttribute("list", service.getList());
//		
//	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET) 
	public void list(MemberCriteria cri, Model model) {
		log.info(cri);
		model.addAttribute("list", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new MemberPageDTO(service.getListWithCnt(cri), cri));
	}
	
	/* 아래의 RequestMapping 과 같음. return이 없는 void와 return이 있는 String의 차이
	 * public String register() { return "register"; }
	 */
	
	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public void register() {
		
	}
	
	// 오버로딩_메소드명은 같지만 변수명을 달리주는 것.
	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public String register(MemberVO member, RedirectAttributes rttr) {
		
		
		service.register(member);
		
		return "redirect:/member/list";
	}
	
	/*
	 * @RequestMapping(value = "/get", method = RequestMethod.GET)
	 * // @requestParam("도메인과 일치") public void get(@RequestParam("num") int num) {
	 * model.addAttribute("member", service.get(num)); System.out.println(num);
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	//public void get(int num) {
	public void get(@RequestParam("num") int num, Model model) {
		
		model.addAttribute("member", service.get(num));

	}
	
	/*@RequestMapping(value = "/get", method = RequestMethod.POST)
	//public void get(int num) {
	public void get(memberVO member) {
		
		boolean result = service.modify(member);
		if(result) {
			return "redirect:/member/list";
		} else {
			return "redirect:/member/get";
		}*/
		@RequestMapping(value = "/get", method = RequestMethod.POST)
		//public void get(int num) {
		public String get(MemberVO member) {
			
			boolean result = service.modify(member);
			if(result) {
				return "redirect:/member/list";
			} else {
				return "redirect:/member/get?num="+member.getNum();
			}

		}
		//GET 방식 삭제
		@RequestMapping(value = "/remove", method = RequestMethod.GET)
		//public void get(int num) {
		public String remove(@RequestParam("num") int num) {
			
			service.remove(num);

			return "redirect:/member/list";
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		//public void get(int num) {
		// param은 get 방식
		public String remove(MemberVO member) {
			
			service.remove(member.getNum());

			return "redirect:/member/list";
		}
		
	}
	
	
	

