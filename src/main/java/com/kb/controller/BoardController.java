package com.kb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("list")
	public void list(Model model) {
		//얘가 list로 오면 목록을 찍어라.
		//파일이 없을 때는 당연히 웹에 나오지 않지만 console에는 목록이 찍힌다.
		log.info("목록");
		//view에다 값을 던지는 것.
		model.addAttribute("list", service.getList());
		
		
	}
	
	
}
