package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.AuthorRepository;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.AuthorDto;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthorService implements Service<Author, AuthorDto, Long>{

    private final Repository<Long, Author> authorRepository;

    public Optional<AuthorDto> findById(Long id) {
        return authorRepository.finById(id).map(MapperGuide.INSTANCE::authorToAuthorDto);
    }

    public List<AuthorDto> findAllAuthor() {
        return authorRepository.findAll().stream().map(MapperGuide.INSTANCE::authorToAuthorDto).toList();
    }

    public Author create(AuthorDto authorDto) {
        Author author = MapperGuide.INSTANCE.authorDtoToAuthor(authorDto);
        return authorRepository.save(author);
    }

    public void update(AuthorDto authorDto) {
        authorRepository.update(MapperGuide.INSTANCE.authorDtoToAuthor(authorDto));
    }

    public boolean delete(Long id) {
        Optional<Author> author = authorRepository.finById(id);
        author.ifPresent(a -> authorRepository.delete(a.getId()));
        return author.isPresent();
    }

}
