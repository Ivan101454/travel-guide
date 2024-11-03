package ru.clevertec.travelguide.service;

import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.AuthorDto;
import ru.clevertec.travelguide.dto.Dto;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Service<E extends BaseEntity<K>, DTO extends Dto, K extends Serializable> {

    Optional<DTO> findById(K id);
    List<DTO> findAllAuthor();
    E create(DTO dto);
    public void update(DTO dto);
    public boolean delete(K id);
}
