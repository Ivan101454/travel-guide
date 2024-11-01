package ru.clevertec.travelguide.dao;

import jakarta.persistence.EntityManager;
import ru.clevertec.travelguide.entities.Charter;

public class CharterRepository extends RepositoryBase<Long, Charter>{

    public CharterRepository(EntityManager entityManager) {
        super(Charter.class, entityManager);
    }
}
