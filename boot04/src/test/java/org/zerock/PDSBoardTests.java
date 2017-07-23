package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDSBoard;
import org.zerock.domain.PDSFile;
import org.zerock.persistence.PDSBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
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
	}*/
	
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
		
		Optional<PDSBoard> results = repo.findById(2L);
		
		results.ifPresent(pds -> {
			log.info("데이터 존재");
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
}
