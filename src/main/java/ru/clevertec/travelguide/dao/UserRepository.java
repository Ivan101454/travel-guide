package ru.clevertec.travelguide.dao;


import jakarta.persistence.EntityManager;
import ru.clevertec.travelguide.entities.User;

public class UserRepository extends RepositoryBase<Long, User> {

    public UserRepository(Class<User> clazz, EntityManager entityManager) {
        super(clazz, entityManager);
    }
}
