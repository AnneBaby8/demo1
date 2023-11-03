package com.xsfh.demo1;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;
@Slf4j
@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
        long timestamp = System.currentTimeMillis();
        Random random = new Random();
        int randomNum = random.nextInt(1000);
        log.info(timestamp + "" + randomNum);
    }

}
