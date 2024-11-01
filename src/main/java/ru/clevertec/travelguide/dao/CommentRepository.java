package ru.clevertec.travelguide.dao;

import jakarta.persistence.EntityManager;
import ru.clevertec.travelguide.entities.Comment;

public class CommentRepository extends RepositoryBase<Long, Comment> {

    public CommentRepository(EntityManager entityManager) {
        super(Comment.class, entityManager);
    }
}
