package org.zerock;

import java.util.Arrays;
import java.util.Optional;

import javax.management.relation.Role;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Member;
import org.zerock.domain.MemberRole;
import org.zerock.persistence.MemberRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTests {
	@Autowired
	MemberRepository memberRepo;
	
	/*@Test
	public void testInsert(){
		for(int i = 0; i <= 100; i++){
			Member m = new Member();
			m.setUid("user"+i);
			m.setUpw("pw" + i);
			m.setUname("사용자"+i);
			
			MemberRole r = new MemberRole();
			if(i <= 80){
				r.setRoleName("BASIC");
			}
			else if(i <= 90){
				r.setRoleName("MANAGER");
			}
			else{
				r.setRoleName("ADMIN");
			}
			
			m.setRoles(Arrays.asList(r));
			
			memberRepo.save(m);
		}
	}*/
	
	@Test
	public void testRead(){
		Optional<Member> result = memberRepo.findById("user85");
		
		result.ifPresent(m -> log.info("member : "+ m));
	}
}
