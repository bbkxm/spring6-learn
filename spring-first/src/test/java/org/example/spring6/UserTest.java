package org.example.spring6;

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
//        userUnderTest = new User();
//        org.springframework.beans.factory.support.DefaultListableBeanFactory.beanDefinitionMap
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        userUnderTest = context.getBean("user", User.class);
        logger.info("1: {}", userUnderTest);
    }

    @Test
    void testAdd() {
        // Setup
        // Run the test
        logger.info("2: ");
        userUnderTest.add();

        // Verify the results
    }

    // 反射创建对象
    @Test
    void testAdd2() throws Exception {
        // 获取class对象
        Class<?> clazz = Class.forName("org.example.spring6.User");
        // 调用方法创建对象
//        Object object = clazz.newInstance();
        User user = (User) clazz.getDeclaredConstructor().newInstance();
        logger.info("3: {}", user);
    }
}
