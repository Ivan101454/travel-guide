package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.PictureDto;
import ru.clevertec.travelguide.entities.Picture;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PictureService implements Service<Picture, PictureDto, Long> {

    private final Repository<Long, Picture> pictureRepository;

    @Override
    public Optional<PictureDto> findById(Long id) {
        return pictureRepository.finById(id).map(MapperGuide.INSTANCE::pictureToPictureDto);
    }

    @Override
    public List<PictureDto> findAllAuthor() {
        return pictureRepository.findAll().stream().map(MapperGuide.INSTANCE::pictureToPictureDto).toList();
    }

    @Override
    public Picture create(PictureDto dto) {
        return pictureRepository.save(MapperGuide.INSTANCE.pictureDtoToPicture(dto));
    }

    @Override
    public void update(PictureDto dto) {
        pictureRepository.update(MapperGuide.INSTANCE.pictureDtoToPicture(dto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Picture> picture = pictureRepository.finById(id);
        picture.ifPresent(p -> pictureRepository.delete(p.getId()));
        return picture.isPresent();
    }
}
