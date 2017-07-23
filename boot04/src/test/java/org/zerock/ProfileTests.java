package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Member;
import org.zerock.domain.Profile;
import org.zerock.persistence.MemberRepository;
import org.zerock.persistence.ProfileRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class ProfileTests {
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	ProfileRepository profileRepo;
	
	/*@Test
	public void testInsertMember() {
		IntStream.range(1, 101).forEach(i -> {
			Member m = new Member();
			m.setUid("user" + i);
			m.setUpw("pw" + i);
			m.setUname("사용자" + i);
			
			memberRepo.save(m);
		});
	}
	
	@Test
	public void testInsertProfile() {
		Member m = new Member();
		m.setUid("user3");
		
		for(int i = 1; i < 5; i++) {
			Profile p = new Profile();
			p.setFname("face" + i + ".jpg");
			
			if(i == 3) {
				p.setCurrent(true);
			}
			
			p.setMember(m);
			
			profileRepo.save(p);
		}
	}
	
	@Test
	public void testFetchJoin1() {
		List<Object[]> results = memberRepo.getMemberWithProfileCount("user3");
		
		results.forEach(m -> System.out.println(Arrays.toString(m)));
	}*/
	
	@Test
	public void testFetchJoin2() {
		List<Object[]> results = memberRepo.getMemberWithProfile("user3");
		
		results.forEach(m -> System.out.println(Arrays.toString(m)));
	}
}
