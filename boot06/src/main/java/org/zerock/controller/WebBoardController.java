package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.WebBoard;
import org.zerock.persistence.CustomCrudRepository;
import org.zerock.persistence.WebBoardRepository;
import org.zerock.vo.PageMaker;
import org.zerock.vo.PageVO;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {
	@Autowired
	private WebBoardRepository boardRepo;
	private CustomCrudRepository customRepo;
	
//	@GetMapping("/list")
//	public void readlist(PageVO vo, Model model){
//		log.info("list called!");
//		
//		Pageable page = vo.makePageable(0, "bno");	//bno 역정렬
//		
//		Page<WebBoard> result = boardRepo.findAll(boardRepo.makePredicate(vo.getType(), vo.getKeyword()), page);
//		
//		log.info("" + page);
//		log.info("" + result);
//		
//		log.info("total page number : " + result.getTotalPages());
//		
//		model.addAttribute("result", new PageMaker(result));
//	}
	
	@GetMapping("list")
	public void list(@ModelAttribute("pageVO")PageVO vo, Model model){
		Pageable pageable = vo.makePageable(0, "bno");
		
		Page<Object[]> result = customRepo.getCustomPage(vo.getType(), vo.getKeyword(), pageable);
		
		log.info("" + pageable);
		log.info("" + result);
		
		log.info("total page number : " + result.getTotalPages());
		
		model.addAttribute("result", new PageMaker<>(result));
	}
	
	@GetMapping("/register")
	public void registerGET(@ModelAttribute("vo")WebBoard vo){
		log.info("register get");
	}
	
	@PostMapping("/register")
	public String registerPOST(@ModelAttribute("vo")WebBoard vo, RedirectAttributes rttr){
		log.info("register post");
		log.info("" + vo);
		
		boardRepo.save(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/boards/list";
	}
	
	@GetMapping("/view")
	public void view(Long bno, @ModelAttribute("pageVO")PageVO vo, Model model){
		log.info("bno : " + bno);
		
		boardRepo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
	}
	
	@GetMapping("/modify")
	public void modify(Long bno, @ModelAttribute("pageVO")PageVO vo, Model model){
		log.info("bno : " + bno);
		
		boardRepo.findById(bno).ifPresent(board -> model.addAttribute("vo", board));
	}
	
	@PostMapping("/delete")
	public String delete(Long bno, @ModelAttribute("pageVO")PageVO vo, RedirectAttributes rttr){
		log.info("bno : " + bno);
		
		boardRepo.deleteById(bno);
		
		rttr.addFlashAttribute("msg", "success");
		
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());
		
		return "redirect:/boards/list";
	}
	
	@PostMapping("modify")
	public String modify(WebBoard board, @ModelAttribute("pageVO")PageVO vo, RedirectAttributes rttr){
		log.info("bno : " + board);
		
		boardRepo.findById(board.getBno()).ifPresent(origin -> {
			origin.setTitle(board.getTitle());
			origin.setContent(board.getContent());
			
			boardRepo.save(origin);
			rttr.addFlashAttribute("msg", "success");
			rttr.addAttribute("bno", origin.getBno());
		});
		
		rttr.addAttribute("page", vo.getPage());
		rttr.addAttribute("size", vo.getSize());
		rttr.addAttribute("type", vo.getType());
		rttr.addAttribute("keyword", vo.getKeyword());
		
		return "redirect:/boards/list";
	}
}
