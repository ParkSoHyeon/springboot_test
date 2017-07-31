package org.zerock;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.WebBoard;
import org.zerock.persistence.WebBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class WebBoardRepositoryTests {
	@Autowired
	WebBoardRepository boardRepo;
	
	/*@Test
	public void insertDummies(){
		IntStream.range(0, 300).forEach(i -> {
			WebBoard b = new WebBoard();
			b.setTitle("sample board title " + i);
			b.setContent("content sample " + i);
			b.setWriter("user0" + i%10);
			
			boardRepo.save(b);
		});
	}
	
	@Test
	public void testList1(){
		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
		
		Page<WebBoard> result = boardRepo.findAll(boardRepo.makePredicate(null, null), pageable);
		
		log.info("PAGE : " + result.getPageable());
		
		result.getContent().forEach(board -> log.info("" + board));
	}
	
	@Test
	public void testList2(){
		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
		
		Page<WebBoard> result = boardRepo.findAll(boardRepo.makePredicate("t", "10"), pageable);
		
		result.getContent().forEach(board -> log.info("" + board));
	}*/
}
