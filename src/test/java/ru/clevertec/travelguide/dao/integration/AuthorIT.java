package ru.clevertec.travelguide.dao.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.entities.Guide;
import ru.clevertec.travelguide.utils.HibernateUtil;

import java.lang.reflect.Proxy;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuthorIT {
    static SessionFactory sessionFactory;
    static Session session;
    static AuthorRepository authorRepository;

    @BeforeAll
    static void initDatabaseSession() {
        sessionFactory = HibernateUtil.buildSessionFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
        authorRepository = new AuthorRepository(session);
    }
    @Test
    void shouldSaveAuthor() {
        session.beginTransaction();
        Author agatha = Author.builder().nameAuthor("Agatha").build();
        Author save = authorRepository.save(agatha);
        assertEquals(agatha.getNameAuthor(), save.getNameAuthor());
        session.getTransaction().commit();
    }


    @Test
    void shouldFindAuthorById() {
        session.beginTransaction();
        Optional<Author> author = authorRepository.finById(1L);
        assertEquals("Agatha", author.get().getNameAuthor());
        session.getTransaction().commit();
    }

    @AfterAll
    static void closeDatabase() {
        sessionFactory.close();
    }
}
