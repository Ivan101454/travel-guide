package ru.clevertec.travelguide.dao;

import jakarta.persistence.EntityManager;
import ru.clevertec.travelguide.entities.Guide;

public class GuideRepository extends RepositoryBase<Long, Guide> {

    public GuideRepository(EntityManager entityManager) {
        super(Guide.class, entityManager);
    }
}
