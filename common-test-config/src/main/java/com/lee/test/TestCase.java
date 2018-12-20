package com.lee.test;

import com.lee.test.config.TestConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @author liwei
 */
@SpringBootTest(classes = TestConfig.class)
public class TestCase extends AbstractTransactionalJUnit4SpringContextTests {
}
