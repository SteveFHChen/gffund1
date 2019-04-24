package com.ycnet.dbank;

import com.ycnet.Application;
import com.ycnet.mirage.test.MirageTest;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

/**
 * 单元测试基础类
 * Created with IntelliJ IDEA.
 * User: guozp
 * Date: 14-3-14
 * Time: 下午1:30
 * To change this template use File | Settings | File Templates.
 */
@ContextConfiguration(classes = Application.class,loader = SpringApplicationContextLoader.class)
@ActiveProfiles("junit")
public class DbankTest extends MirageTest{
    @Test
    public void test(){
        logger.info("junit success!");
    }


}
