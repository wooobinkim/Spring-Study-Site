package edu.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ssafy.dto.MemDTO;
import edu.ssafy.service.MemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api")
@Api("MEMBER REST API")
public class RestMemberController {
	
	@Autowired
	private MemService memser;
	
	@RequestMapping(value="/idcheck/{id}", method = {RequestMethod.GET})
	@ApiOperation(value = "member id check service")
	private @ResponseBody ResponseEntity<Map<String,Object>> idCheck(@PathVariable("id") String id) throws Exception {
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		HashMap<String, Object> map = new HashMap();
		
		if(memser.idCheck(id)) {
			map.put("resMsg", "로그인 데이터");
			map.put("resstatus", "사용할 수 있는 아이디 입니다");
		}else {
			map.put("resMsg", "로그인 데이터");
			map.put("resstatus", "사용할 없는 아이디 입니다");
		}
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity; 
	}
	
	@GetMapping(value="/login/{id}/{pw}")
	@ApiOperation(value = "member login service")
	private @ResponseBody ResponseEntity<Map<String,Object>> login(@PathVariable("id") String id, @PathVariable("pw") String pw, HttpSession session) throws Exception {
		
		boolean login = memser.login(id, pw);
		ResponseEntity<Map<String,Object>> resEntity = null;
		HashMap<String, Object> map = new HashMap();
		
		if(login) {
			session.setAttribute("id", id);
			map.put("resMsg", "로그인 데이터");
			map.put("resValue", id+" "+pw);
			map.put("resstatus", "login 성공");
		}else {
			map.put("resstatus", "login 실패");
		}
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
	
	@RequestMapping(value="/logout", method = {RequestMethod.GET,RequestMethod.POST})
	@ApiOperation(value = "member logout service")
	private @ResponseBody ResponseEntity<Map<String,Object>> logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		HashMap<String, Object> map = new HashMap();
		
		map.put("resMsg", "로그아웃 데이터");
		map.put("resstatus", "logout 성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity; 
	}
	
	@PutMapping(value="/member")
	@ApiOperation(value = "member update service")
	private @ResponseBody ResponseEntity<Map<String,Object>> updateMember(@RequestBody MemDTO m) throws Exception {
		
		memser.updateMember(m);
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap();
		
		map.put("resMsg", "회원수정 데이터");
		map.put("resValue", m);
		map.put("resstatus", "수정성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
	
	@DeleteMapping(value="/member/{id}")
	@ApiOperation(value = "member delete service")
	private @ResponseBody ResponseEntity<Map<String,Object>> deleteMember(@PathVariable("id") String id) throws Exception {
		
		MemDTO memDTO = new MemDTO();
		memDTO.setId(id);
		memser.deleteMember(memDTO);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap();
		
		map.put("resMsg", "회원삭제 데이터");
		map.put("resValue", memDTO);
		map.put("resstatus", "삭제성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
	
	@GetMapping(value="/member/{id}")
	@ApiOperation(value = "member info service")
	private @ResponseBody ResponseEntity<Map<String,Object>> viewMember(@PathVariable("id")String id) throws Exception {
		MemDTO m = new MemDTO();
		m.setId(id);
		MemDTO member = memser.viewMember(m);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String,Object> map = new HashMap();
		
		map.put("resMsg", "단일회원조회 데이터");
		map.put("resValue", member);
		map.put("resstatus", "조회성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity; 
	}
	
	
	@GetMapping(value="/member")
	@ApiOperation(value = "member infolist service")
	private @ResponseBody ResponseEntity<Map<String,Object>> listMember(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, ServletException {
		List<MemDTO> list = memser.listMember();
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map<String, Object> map = new HashMap();
		
		map.put("resMsg", "회원조회 데이터");
		map.put("resValue", list);
		map.put("resstatus", "조회성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
	
	@PostMapping(value="/member")
	@ApiOperation(value = "member create service")
	private @ResponseBody ResponseEntity<Map<String,Object>> regMember(@RequestBody MemDTO mem) throws Exception, IOException {
		
		memser.regMember(mem);
		
		ResponseEntity<Map<String,Object>> resEntity = null;
		Map <String, Object> map = new HashMap();
		
		map.put("resMsg", "회원등록 데이터");
		map.put("resValue", mem);
		map.put("resstatus", "입력성공");
		
		resEntity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		return resEntity;
	}
	
		
}


