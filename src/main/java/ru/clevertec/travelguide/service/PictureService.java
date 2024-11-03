package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.PictureDto;
import ru.clevertec.travelguide.entities.Picture;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PictureService implements Service<Picture, PictureDto, Long> {

    private final Repository<Long, Picture> pictureRepository;

    @Override
    public Optional<PictureDto> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PictureDto> findAllAuthor() {
        return List.of();
    }

    @Override
    public Picture create(PictureDto dto) {
        return null;
    }

    @Override
    public void update(PictureDto dto) {

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
