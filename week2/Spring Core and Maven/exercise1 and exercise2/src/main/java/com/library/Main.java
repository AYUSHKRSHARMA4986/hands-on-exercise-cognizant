package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class Main {
    public static void main(String[] args) {
        // 1. Load the Spring application context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. Ask Spring to hand us the fully configured BookService bean
        BookService service = (BookService) context.getBean("bookService");

        // 3. Test the application
        service.manageBooks();
    }
}