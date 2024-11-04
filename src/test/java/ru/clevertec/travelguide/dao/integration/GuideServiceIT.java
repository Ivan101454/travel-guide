package ru.clevertec.travelguide.dao.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.dao.GuideRepository;
import ru.clevertec.travelguide.dto.GuideDto;
import ru.clevertec.travelguide.service.AuthorService;
import ru.clevertec.travelguide.service.GuideService;
import ru.clevertec.travelguide.utils.HibernateUtil;

import java.lang.reflect.Proxy;
import java.util.Optional;

public class GuideServiceIT {

    static SessionFactory sessionFactory;
    static Session session;
    static GuideRepository guideRepository;
    static GuideService guideService;

    @BeforeAll
    static void initDatabaseSession() {
        sessionFactory = HibernateUtil.buildSessionFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
        guideRepository = new GuideRepository(session);
        guideService = new GuideService(guideRepository);
    }

    @Test
    void shouldReturnListOfCharter() {
        session.beginTransaction();
        Optional<GuideDto> biId = guideService.findById(1L);
        biId.get().getContentsCharter().forEach(System.out::println);
        session.getTransaction().commit();
    }

    @AfterAll
    static void closeDatabase() {
        sessionFactory.close();
    }
}
