package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.Member;
import org.zerock.persistence.MemberRepository;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/member/")
public class MemberController {
	@Autowired
	PasswordEncoder pwEncoder;
	
	@Autowired
	MemberRepository memberRepo;
	
	@GetMapping("/join")
	public void join(){
		
	}
	
	@PostMapping("/join")
	public String joinPost(@ModelAttribute("member")Member member){
		log.info("member : " + member);
		
		String encryptPW = pwEncoder.encode(member.getUpw());
		
		log.info("en : " + encryptPW);
		
		member.setUpw(encryptPW);
		
		memberRepo.save(member);
		
		return "/member/joinResult";
	}
}