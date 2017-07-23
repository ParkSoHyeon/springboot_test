package org.zerock;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
	@Autowired
	BoardRepository repo;
	
//	@Test
//	public void inspect() {
//		Class<?> clz = repo.getClass();
//		
//		System.out.println(clz.getName());
//		
//		Class<?>[] interfaces = clz.getInterfaces();
//		
//		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
//		
//		Class<?> superclass = clz.getSuperclass();
//		
//		System.out.println(superclass.getName());
//	}
	
	@Test
	public void testInsert() {
		Board board = new Board();
		board.setTitle("게시물의 제목2");
		board.setContent("게시물 내용 넣기2");
		board.setWriter("elmo2");
		
		repo.save(board);
	}
	
	@Test
	public void testRead() {
		System.out.println(repo.findOne(1L));
	}
	
	@Test
	public void testUpdate() {
		Board b = repo.findOne(2L);
		
		b.setTitle("수정된 제목");
		
		repo.save(b);
	}
	
	@Test
	public void testDelete() {
		repo.delete(5L);
	}
}
