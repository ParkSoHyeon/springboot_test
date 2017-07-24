package org.zerock;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.persistence.FreeBoardReplyRepository;
import org.zerock.persistence.FreeBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
//@Transactional
@Commit
public class FreeBoardTests {
	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	/*@Test
	public void insertDummy() {
		IntStream.range(1, 200).forEach(i -> {
			FreeBoard b = new FreeBoard();
			b.setTitle("Free Board : " + i);
			b.setContent("Free Content : " + i);
			b.setWriter("user" + (i%10));
			
			boardRepo.save(b);
		});
	}
	
	@Transactional
	@Test
	public void insertReply2Way() {
		Optional<FreeBoard> result = boardRepo.findById(199L);
		
		result.ifPresent(board -> {
			List<FreeBoardReply> replies = board.getReplies();
			
			FreeBoardReply reply = new FreeBoardReply();
			reply.setReply("Replay!!");
			reply.setReplyer("replyer00");
			reply.setBoard(board);
			
			replies.add(reply);
			
			board.setReplies(replies);
			
			boardRepo.save(board);
		});
	}
	
	@Test
	public void insertReply1Way() {
		FreeBoard board = new FreeBoard();
		board.setBno(199L);
		
		FreeBoardReply reply = new FreeBoardReply();
		reply.setReply("ReplayReplay!!");
		reply.setReplyer("replyer00");
		reply.setBoard(board);
		
		replyRepo.save(reply);
	}
	
	@Test
	public void testList() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.findByBnoGreaterThan(0L, page).forEach(b -> {
				log.info(b.getBno() + " - " + b.getTitle());
			});
	}
	
	@Transactional
	@Test
	public void testList2() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.findByBnoGreaterThan(0L, page).forEach(b -> {
			log.info(b.getBno() + " - " + b.getTitle() + "( " + b.getReplies().size() + " )");
		});
	}*/
	
	@Transactional
	@Test public void testList3() {
		Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
		
		boardRepo.getPage(page).forEach(b -> {
			log.info(Arrays.toString(b));
		});
	}
}
