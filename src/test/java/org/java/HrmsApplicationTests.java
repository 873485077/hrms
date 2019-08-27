package org.java;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HrmsApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void deploy(){

        System.out.println(UuidUtil.getTimeBasedUuid().toString());

    }
}
