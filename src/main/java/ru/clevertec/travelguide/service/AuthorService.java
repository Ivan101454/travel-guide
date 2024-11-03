package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.dto.AuthorDto;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.mapper.AuthorMapper;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Optional<AuthorDto> findById(Long id) {
        return authorRepository.finById(id).map(AuthorMapper.INSTANCE::authorToAuthorDto);
    }

    public List<AuthorDto> findAllAuthor() {
        return authorRepository.findAll().stream().map(AuthorMapper.INSTANCE::authorToAuthorDto).toList();
    }

    public Author create(AuthorDto authorDto) {
        Author author = AuthorMapper.INSTANCE.authorDtoToAuthor(authorDto);
        return authorRepository.save(author);
    }

    public void update(AuthorDto authorDto) {
        authorRepository.update(AuthorMapper.INSTANCE.authorDtoToAuthor(authorDto));
    }

    public boolean delete(Long id) {
        Optional<Author> author = authorRepository.finById(id);
        author.ifPresent(a -> authorRepository.delete(a.getId()));
        return author.isPresent();
    }

}
