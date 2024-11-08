package ru.clevertec.travelguide.dao.integration;

import jakarta.transaction.Transactional;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.dao.GuideRepository;
import ru.clevertec.travelguide.dto.GuideDto;
import ru.clevertec.travelguide.interceptor.TransactionInterceptor;
import ru.clevertec.travelguide.service.AuthorService;
import ru.clevertec.travelguide.service.GuideService;
import ru.clevertec.travelguide.service.UserService;
import ru.clevertec.travelguide.utils.HibernateUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Optional;

public class GuideServiceIT {

    static SessionFactory sessionFactory;
    static Session session;
    static GuideRepository guideRepository;
    static GuideService guideService;

    @Transactional
    @BeforeAll
    static void initDatabaseSession() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        sessionFactory = HibernateUtil.buildSessionFactory();
        session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                ((proxy, method, args) -> method.invoke(sessionFactory.getCurrentSession(), args)));
        guideRepository = new GuideRepository(session);
        var guideService1 = new GuideService(guideRepository);


        TransactionInterceptor transactionInterceptor = new TransactionInterceptor(sessionFactory);
        guideService = new ByteBuddy()
                .subclass(GuideService.class)
                .method(ElementMatchers.any())
                .intercept(MethodDelegation.to(transactionInterceptor))
                .make()
                .load(UserService.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor(GuideRepository.class)
                .newInstance(guideRepository);
    }

    @Test
    void shouldReturnListOfCharter() {
//        session.beginTransaction();
        Optional<GuideDto> biId = guideService.findById(1L);
        biId.get().getContentsCharter().forEach(System.out::println);
//        session.getTransaction().commit();
    }

    void shouldCreateNewGuide() {

    }


    @AfterAll
    static void closeDatabase() {
        sessionFactory.close();
    }
}
