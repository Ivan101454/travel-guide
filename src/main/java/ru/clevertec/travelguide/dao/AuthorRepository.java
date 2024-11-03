package ru.clevertec.travelguide.dao;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.entities.Author;

public class AuthorRepository extends RepositoryBase<Long, Author>{

    public AuthorRepository(EntityManager entityManager) {
        super(Author.class, entityManager);
    }
}
