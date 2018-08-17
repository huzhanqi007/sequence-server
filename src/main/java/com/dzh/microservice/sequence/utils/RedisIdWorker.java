package com.dzh.microservice.sequence.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

/**
 * Created by herbert on 2018/8/17.
 */
@Service
public class RedisIdWorker {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取唯一Id
     * @param key
     * @param hashKey
     * @param delta 增加量（不传采用1）
     * @return
     */
    public Long incrementHash(String key,String hashKey,Long delta){
        try {
            if (null == delta) {
                delta=1L;
            }
            return redisTemplate.opsForHash().increment(key, hashKey, delta);
        } catch (Exception e) {//redis宕机时采用uuid的方式生成唯一id
            int first = new Random(10).nextInt(8) + 1;
            int randNo= UUID.randomUUID().toString().hashCode();
            if (randNo < 0) {
                randNo=-randNo;
            }
            return Long.valueOf(first + String.format("%016d", randNo));
        }
    }
    public static void main(String[] args){
        RedisIdWorker redisIdWorker = new RedisIdWorker();
        for (int i=0;i<100;i++){
            System.out.println(redisIdWorker.incrementHash("qq","ww",null));
        }
    }
}
