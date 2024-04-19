package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class UserTest {
    private static final Logger logger = LoggerFactory.getLogger(UserTest.class);

    private User userUnderTest;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean
        userUnderTest = (User) context.getBean("user");
        logger.info("根据id获取bean: {}", userUnderTest);
        // 根据id和类型获取bean
        userUnderTest = context.getBean("user", User.class);
        logger.info("根据id和类型获取bean: {}", userUnderTest);
        // 根据类型获取bean，如果有多个，会抛出异常
        // org.springframework.beans.factory.NoUniqueBeanDefinitionException:
        // No qualifying bean of type 'org.example.User' available:
        // expected single matching bean but found 2: user,user1
        userUnderTest = context.getBean(User.class);
        logger.info("根据类型获取bean: {}", userUnderTest);
    }

    @Test
    void testRun() {
        userUnderTest.run();
    }

}
