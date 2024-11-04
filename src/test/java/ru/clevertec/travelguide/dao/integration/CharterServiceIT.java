package ru.clevertec.travelguide.dao.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.travelguide.dao.CharterRepository;
import ru.clevertec.travelguide.dao.GuideRepository;
import ru.clevertec.travelguide.service.CharterService;
import ru.clevertec.travelguide.service.GuideService;
import ru.clevertec.travelguide.utils.HibernateUtil;

import java.lang.reflect.Proxy;

public class CharterServiceIT {
    static SessionFactory sessionFactory;
    static Session session;
    static CharterRepository charterRepository;
    static CharterService charterService;

    @BeforeAll
    static void initDatabaseSession() {
        sessionFactory = HibernateUtil.buildSessionFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
        charterRepository = new CharterRepository(session);
        charterService = new CharterService(charterRepository);
    }

    @Test
    void shouldFindCharterById() {
        session.beginTransaction();
        charterService.findById(1L);
        session.getTransaction().commit();
    }

    @AfterAll
    static void closeDatabase() {
        sessionFactory.close();
    }
}
