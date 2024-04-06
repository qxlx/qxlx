package com.minispring;

import com.minispring.context.ClassPathXmlAppcationContext;


/**
 * @author qxlx
 * @date 2024/4/5 22:10
 */
public class MiniSpringTest {

    public static void main(String[] args) throws Exception {
        ClassPathXmlAppcationContext classPathXmlAppcationContext =
                new ClassPathXmlAppcationContext("beans.xml");
        Person person = (Person)classPathXmlAppcationContext.getBean("person");
        person.run();
    }

}
