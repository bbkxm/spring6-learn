package org.example.spring6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    // 创建Logger对象
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    /**
     * 反射创建对象
     * 1/加载bean.xml配置文件
     * 2/对xml文件进行解析操作
     * 3/获取xml文件中的bean标签，id和class
     * 4/使用反射根据类的全路径创建对象
     */
    public User() {
        logger.info("0: 无参数构造");
    }

    // 创建一个方法add
    public void add() {
        logger.info("add...");
    }
}
