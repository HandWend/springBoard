package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kb.domain.BoardVO;
import com.kb.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

// 이 컨트롤러에 사용되는 애들은 다 board다.
@RequestMapping("/board/*")
@Controller
@Log4j
@AllArgsConstructor
public class BoardController {
	
	//service 객체 생성 
	//service.메소드() 호출하여 매퍼까지 호출 가능
	private BoardService service;
	
	//controller에서 값을 view에 줄 때 request.setAttribute사용했음.
	//그게 spring에서는 model이다.
	
	// /board/list
	@GetMapping("list")
	public void list(Model model) {
		//얘가 list로 오면 목록을 찍어라.
		//파일이 없을 때는 당연히 웹에 나오지 않지만 console에는 목록이 찍힌다.
		log.info("목록");
		//view에다 값을 던지는 것.
		//<collection>에 해당한다. 컨트롤러에서 뷰로 모델을 통해 값을 전달한다.
		model.addAttribute("list", service.getList());
		
	}
	/* 아래의 RequestMapping 과 같음. return이 없는 void와 return이 있는 String의 차이
	 * public String register() { return "register"; }
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public void register() {
		
	}
	
	// 오버로딩_메소드명은 같지만 변수명을 달리주는 것.
	@RequestMapping(value = "/register", method = RequestMethod.POST) 
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		
		service.register(board);
		
		return "redirect:/board/list";
	}
	
	/*
	 * @RequestMapping(value = "/get", method = RequestMethod.GET)
	 * // @requestParam("도메인과 일치") public void get(@RequestParam("bno") int bno) {
	 * model.addAttribute("board", service.get(bno)); System.out.println(bno);
	 * 
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	//public void get(int bno) {
	public void get(@RequestParam("bno") int bno, Model model) {
		
		model.addAttribute("board", service.get(bno));

	}
	
	/*@RequestMapping(value = "/get", method = RequestMethod.POST)
	//public void get(int bno) {
	public void get(BoardVO board) {
		
		boolean result = service.modify(board);
		if(result) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/get";
		}*/
		@RequestMapping(value = "/get", method = RequestMethod.POST)
		//public void get(int bno) {
		public String get(BoardVO board) {
			
			boolean result = service.modify(board);
			if(result) {
				return "redirect:/board/list";
			} else {
				return "redirect:/board/get?bno="+board.getBno();
			}

		}
		//GET 방식 삭제
		@RequestMapping(value = "/remove", method = RequestMethod.GET)
		//public void get(int bno) {
		public String remove(@RequestParam("bno") int bno) {
			
			service.remove(bno);

			return "redirect:/board/list";
		}
		
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		//public void get(int bno) {
		// param은 get 방식
		public String remove(BoardVO board) {
			
			service.remove(board.getBno());

			return "redirect:/board/list";
		}
		
	}
	
	
	

