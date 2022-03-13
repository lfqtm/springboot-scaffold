package com.qlk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedisApplicationTests {

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Test
  void contextLoads() {

    ValueOperations valueOperations = redisTemplate.opsForValue();
    valueOperations.set("testkey", "testvalue");

    Object testkey = valueOperations.get("testkey");
    System.out.println("testkey = " + testkey);

  }

  @Test
  void stringRedisTemplateTest() {
    ValueOperations<String, String> sops = stringRedisTemplate.opsForValue();
    sops.set("testkey", "忽然之间");
    String testkey = sops.get("testkey");
    System.out.println("testkey = " + testkey);
  }

}
