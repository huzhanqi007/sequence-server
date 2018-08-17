package com.dzh.microservice.sequence;

import com.dzh.microservice.sequence.utils.RedisIdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SequenceServerApplicationTests {
    @Autowired
	RedisIdWorker redisIdWorker;
	@Test
	public void contextLoads() {
		for (int i=0;i<100;i++){
			System.out.println(redisIdWorker.incrementHash("redisIdWorker","redisIdWorker",1l));
		}
	}

}
