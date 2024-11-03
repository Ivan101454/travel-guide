package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.CommentDto;
import ru.clevertec.travelguide.entities.Comment;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommentService implements Service<Comment, CommentDto, Long> {

    private final Repository<Long, Comment> commentRepository;

    @Override
    public Optional<CommentDto> findById(Long id) {
        return commentRepository.finById(id).map(MapperGuide.INSTANCE::commentToCommentDto);
    }

    @Override
    public List<CommentDto> findAllAuthor() {
        return commentRepository.findAll().stream().map(MapperGuide.INSTANCE::commentToCommentDto).toList();
    }

    @Override
    public Comment create(CommentDto dto) {
        return commentRepository.save(MapperGuide.INSTANCE.commentDtoToComment(dto));
    }

    @Override
    public void update(CommentDto dto) {
        commentRepository.update(MapperGuide.INSTANCE.commentDtoToComment(dto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Comment> comment = commentRepository.finById(id);
        comment.ifPresent(c -> commentRepository.delete(c.getId()));
        return comment.isPresent();
    }
}
