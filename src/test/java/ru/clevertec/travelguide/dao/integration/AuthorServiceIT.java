package ru.clevertec.travelguide.dao.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.dto.AuthorDto;
import ru.clevertec.travelguide.service.AuthorService;
import ru.clevertec.travelguide.utils.HibernateUtil;

import java.lang.reflect.Proxy;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorServiceIT {
    static SessionFactory sessionFactory;
    static Session session;
    static AuthorRepository authorRepository;
    static AuthorService authorService;

    @BeforeAll
    static void initDatabaseSession() {
        sessionFactory = HibernateUtil.buildSessionFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
        authorRepository = new AuthorRepository(session);
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void shouldFindAllAuthor() {
        session.beginTransaction();
        authorService.findAllAuthor().forEach(System.out::println);
        session.getTransaction().commit();
    }

    @Test
    void shouldFindAuthor() {
        session.beginTransaction();
        Optional<AuthorDto> byId = authorService.findById(1L);
        byId.get().getNameAuthor();
        assertEquals("Agatha", byId.get().getNameAuthor());
        session.getTransaction().commit();
    }


    @AfterAll
    static void closeDatabase() {
        sessionFactory.close();
    }
}
