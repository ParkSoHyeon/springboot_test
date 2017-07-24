package org.zerock;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.persistence.PDSBoardRepository;

import lombok.extern.java.Log;

@SuppressWarnings("unused")
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Transactional
@Commit
public class PDSBoardTests {
	@Autowired
	PDSBoardRepository repo;
	
	/*@Test
	public void testInsertPDS() {
		PDSBoard pds = new PDSBoard();
		pds.setPname("DOCUMENT 1-2");
		
		PDSFile file1 = new PDSFile();
		file1.setPdsfile("file1.doc");		
		
		PDSFile file2 = new PDSFile();
		file2.setPdsfile("file2.doc");		
		
		pds.setFiles(Arrays.asList(file1, file2));
		
		log.info("try to save pds");
		
		repo.save(pds);
	}
	
	@Test
	public void testUpdateFileName1() {
		Long fno = 1L;
		String newName ="updateFile1.doc";
		
		int cnt = repo.updatePDSFile(fno, newName);
		
		log.info("update count : " + cnt);
	}
	
	@Test
	public void testUpdateFileName2() {
		String newName = "updateFile2.doc";
		
		Optional<PDSBoard> result = repo.findById(1L);
		
		result.ifPresent(pds -> {
			log.info("데이터가 존재하므로 update 시도");
			
			PDSFile target = new PDSFile();
			target.setFno(2L);
			target.setPdsfile(newName);
			
			int idx = pds.getFiles().indexOf(target);
			
			if(idx > -1) {
				List<PDSFile> list = pds.getFiles();
				list.remove(idx);
				list.add(target);
				
				pds.setFiles(list);
			}
			
			repo.save(pds);
		});
	}
	
	@Test
	public void testDeletePDSFile() {
		Long fno = 1L;
		
		int cnt = repo.deletePDSFile(fno);
		
		log.info("Delete PDSFile : " + cnt);
	}
	
	@Test
	public void testInsertDummies() {
		List<PDSBoard> list = new ArrayList<>();
		
		IntStream.range(1, 100).forEach(i -> {
			PDSBoard pds = new PDSBoard();
			pds.setPname("자료 : " + i);
			
			PDSFile file1 = new PDSFile();
			file1.setPdsfile("file1.doc");
			
			PDSFile file2 = new PDSFile();
			file2.setPdsfile("file2.doc");
			
			pds.setFiles(Arrays.asList(file1, file2));
			
			lotg.info("try to save pds");
			
			list.add(pds);
		});
		
		repo.saveAll(list);
	}*/
	
	@Test 
	public void testSummary() {
		repo.getSummary()
			.forEach(p -> System.out.println(Arrays.toString(p)));
	}
	
}
