package ru.clevertec.travelguide;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.clevertec.travelguide.entities.User;

public class ApplicationRunner {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(context.getBean(User.class));
    }
}
