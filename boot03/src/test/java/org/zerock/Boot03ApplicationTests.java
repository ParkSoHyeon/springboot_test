package org.zerock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Boot03ApplicationTests {

	@Autowired
	BoardRepository repo;
	
//	@Test
//	public void testInsert200() {
//		for(int i = 1; i <= 200; i++) {
//			Board board = new Board();
//			
//			board.setTitle("제목 : " + i);
//			board.setContent("내용 : " + i + " 채우기");
//			board.setWriter("elmo : " + (i%10));
//			
//			repo.save(board);
//		}
//	}
	
	/*@Test
	public void testByTitle() {
		repo.findBoardByTitle("제목 : 4")
			.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByWriter() {
		Collection<Board> results = repo.findByWriter("elmo : 5");
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByWriterContaining() {
		Collection<Board> results = repo.findByWriterContaining("elmo");
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByTitleContainingOrContentContaining() {
		Collection<Board> results = repo.findByTitleContainingOrContentContaining("30", "30");
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByTitleContainingAndBnoGreaterThan() {
		Collection<Board> results = repo.findByTitleContainingAndBnoGreaterThan("3", 100L);
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByBnoGreaterThanOrderByDesc() {
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(100L);
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testBnoOrderByPaging() {
		Pageable paging = new PageRequest(0, 10);
		
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(100L, paging);
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testBnoPagingSort() {
		Pageable paging = new PageRequest(0, 10, Sort.Direction.DESC, "bno");
		
		Collection<Board> results = repo.findByBnoGreaterThan(100L, paging);
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testBnoPagingSort() {
		Pageable paging = new PageRequest(0, 10, Sort.Direction.ASC, "bno");
		
		Page<Board> results = repo.findByBnoGreaterThan(100L, paging);
		
		System.out.println("Page Size : " + results.getSize());
		System.out.println("Total Pages : " + results.getTotalPages());
		System.out.println("Total Count : " + results.getTotalElements());
		System.out.println("Next : " + results.nextPageable());
		
		results.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByTitle() {
		repo.findByTitle("17")
			.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByContent() {
		repo.findByContent("27")
			.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByWriter() {
		repo.findByWriter("elmo")
			.forEach(b -> System.out.println(b));
	}
	
	@Test
	public void testByTitle() {
		repo.findByTitle("10")
			.forEach(bArray -> System.out.println(Arrays.toString(bArray)));
	}
	
	@Test
	public void testByTitle() {
		repo.findByTitle("11")
			.forEach(bArray -> System.out.println(bArray));
	}*/
	@Test
	public void testByPaging() {
		Pageable paging = new PageRequest(0, 10);
		
		repo.findByPage(paging)
			.forEach(b -> System.out.println(b));
		
	}
	
//	@Test
//	public void testPredicate() {
//		String type="t";
//		String keyword = "17";
//		
//		BooleanBuilder builder = new BooleanBuilder();
//		
//		QBoard board = QBoard.board;
//		
//		//QBoard board = QBoard.board;
//		
//		if(type.equals("t")) {
//			builder.and(board.title.like("%" + keyword + "%"));
//		}
//		
//		builder.and(board.bno.get(0L));
//		
//		Pageable paging = new PageRequest(0, 10);
//		
//		Page<Board> results = repo.findAll(builder, paging);
//		
//		System.out.println("Page Size : " + results.getSize());
//		System.out.println("Total Pages : " + results.getTotalPages());
//		System.out.println("Total Count : " + results.getTotalElements());
//		System.out.println("Next : " + results.nextPageable());
//		
//		List<Board> list = results.getContent();
//		
//		list.forEach(b -> System.out.println(b));
//	}

//	@Test
//	public void contextLoads() {
//	}

}

