package org.zerock;

import java.util.Arrays;
import java.util.stream.IntStream;

import javax.jdo.annotations.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.WebBoard;
import org.zerock.domain.WebReply;
import org.zerock.persistence.WebReplyRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebReplyRepositoryTests {
	@Autowired
	WebReplyRepository replyRepo;
	
	/*@Test
	public void insertDummies(){
		Long[] arr = {104L, 103L, 100L};
		
		Arrays.stream(arr).forEach(num -> {
			WebBoard b = new WebBoard();
			b.setBno(num);
			
			IntStream.range(0, 10).forEach(i -> {
				WebReply r = new WebReply();
				r.setReplyText("reply !!" + i);
				r.setReplyer("replyer" + i);
				r.setBoard(b);
				
				replyRepo.save(r);
			});
		});
	}*/
}
