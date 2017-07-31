package org.zerock.controller;

import java.util.List;

import javax.jdo.annotations.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.WebBoard;
import org.zerock.domain.WebReply;
import org.zerock.persistence.WebReplyRepository;

import lombok.extern.java.Log;

@RestController
@RequestMapping("/replies/*")
@Log
public class WebReplyController {
	@Autowired
	private WebReplyRepository replyRopo;
	
	//댓글 추가
	@Transactional
	@PostMapping("/{bno}")
	public ResponseEntity<List<WebReply>> addReply(@PathVariable("bno")Long bno, @RequestBody WebReply reply){
		log.info("add REPLY");
		log.info("bno : " + bno);
		log.info("reply : " + reply);
		
		WebBoard b = new WebBoard();
		b.setBno(bno);
		
		reply.setBoard(b);
		
		replyRopo.save(reply);
		
		return new ResponseEntity<>(getListByBoard(b), HttpStatus.CREATED);
	}
	
	//댓글 삭제
	@Transactional
	@DeleteMapping("/{bno}/{rno}")
	public ResponseEntity<List<WebReply>> remove(@PathVariable("bno")Long bno, @PathVariable("rno")Long rno){
		log.info("delete REPLY");
		log.info("bno : " + bno);
		log.info("rno : " + rno);
		
		replyRopo.deleteById(rno);
		
		WebBoard b = new WebBoard();
		b.setBno(bno);
		
		return new ResponseEntity<>(getListByBoard(b), HttpStatus.OK);
	}
	
	//댓글 수정
	@Transactional
	@PutMapping("/{bno}")
	public ResponseEntity<List<WebReply>> modify(@PathVariable("bno")Long bno, @RequestBody WebReply reply){
		log.info("modify reply : " + reply);
		
		replyRopo.findById(reply.getRno()).ifPresent(origin -> {
			origin.setReplyText(reply.getReplyText());
			
			replyRopo.save(origin);
		});
		
		WebBoard b = new WebBoard();
		b.setBno(bno);
		
		return new ResponseEntity<>(getListByBoard(b), HttpStatus.CREATED);
	}
	
	@GetMapping("/{bno}")
	public ResponseEntity<List<WebReply>> getReplies(@PathVariable("bno")Long bno){
		log.info("get all replies");
		
		WebBoard b = new WebBoard();
		b.setBno(bno);
		
		return new ResponseEntity<List<WebReply>>(getListByBoard(b), HttpStatus.OK);
	}

	private List<WebReply> getListByBoard(WebBoard board) throws RuntimeException{
		log.info("getListByBoard : " + board);
		
		return replyRopo.getRepliesOfBoard(board);
	}
}
