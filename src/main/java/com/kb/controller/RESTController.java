package com.kb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kb.domain.AuthorVO;
import com.kb.domain.MemberVO;
import com.kb.domain.SampleVO;
import com.kb.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@RestController
@RequestMapping("/data/*")
@Log4j
public class RESTController {

	@Setter(onMethod_ = @Autowired)
	MemberService service;
	
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info(MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	
	/*
	 * @GetMapping(value="/getSample", produces =
	 * {MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE,
	 * MediaType.APPLICATION_XML_VALUE}) public SampleVO getSample() { return new
	 * SampleVO(113, "스타", "로드"); }
	 */
	//object type return
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, 
			MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(113, "스타", "로드");
	}
	
	//collection type return
	@GetMapping(value="/getSample2")
	public List<SampleVO> getsample2() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		for(int i = 0; i < 10; i ++) {
			list.add(new SampleVO(i, "스타"+i, "로드"+i));
		}
		return list;
	}
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("first", new SampleVO(103, "스타", "로드"));
		map.put("second", new SampleVO(113, "스타", "로드"));
		return map;
	}
	/*
	 * @GetMapping(value="/check", params= {"height", "weight"}) public
	 * ResponseEntity<SampleVO> check(Double height, Double weight) { SampleVO vo =
	 * new SampleVO(0, ""+height, ""+weight);
	 * 
	 * ResponseEntity<SampleVO> result = null;
	 * 
	 * if(height < 150) { result =
	 * ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo); } else {
	 * ResponseEntity.status(HttpStatus.OK).body(vo); }
	 * 
	 * return result; }
	 */
	@GetMapping(value = "/check", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid};
	}
	
	@RequestMapping(value = "/members/new", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseStatus(HttpStatus.CREATED)
	public String membersNew(@RequestBody MemberVO member) {
		log.info(member);
		
		List<AuthorVO> list = new ArrayList<AuthorVO>();
		AuthorVO authorvo = new AuthorVO();
		authorvo.setUid(member.getUid());
		authorvo.setAuthority("ROLE_MEMBER");
		
		list.add(authorvo);
		
		member.setAuthList(list);
		service.register(member);
		return "OK";
	}
	
	@GetMapping("/members/{num}")
	public MemberVO read(@PathVariable("num") Integer num) {
		
		//memberVO RETURN하겠죠?
		return service.get(num);
	}
	
	@PutMapping("/members/{num}")
	public boolean update(@PathVariable("num") Integer num, @RequestBody MemberVO member) {
		member.setNum(num);
		return service.modify(member);
	}
	
	@DeleteMapping("/member/{num}")
	public boolean delete(@PathVariable("num") Integer num) {
		
		return service.remove(num);
	}
}
