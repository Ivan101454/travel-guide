package ru.clevertec.travelguide.dao;

import jakarta.persistence.EntityManager;
import ru.clevertec.travelguide.entities.Picture;

public class PictureRepository extends RepositoryBase<Long, Picture>{

    public PictureRepository(EntityManager entityManager) {
        super(Picture.class, entityManager);
    }
}
