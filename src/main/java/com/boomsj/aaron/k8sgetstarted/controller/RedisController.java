package com.boomsj.aaron.k8sgetstarted.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author aaron
 * @version 1.0
 * @date 2021/7/20 16:18
 */
@RestController
@RequestMapping("redis")
@AllArgsConstructor
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("/string/{key}/{value}")
    public void set(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @GetMapping("/string/{key}")
    public String get(@PathVariable String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
