package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.CharterDto;
import ru.clevertec.travelguide.entities.Charter;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CharterService implements Service<Charter, CharterDto, Long> {

    private final Repository<Long, Charter> charterRepository;

    @Override
    public Optional<CharterDto> findById(Long id) {
        return charterRepository.finById(id).map(MapperGuide.INSTANCE::charterToCharterDto);
    }

    @Override
    public List<CharterDto> findAllAuthor() {
        return charterRepository.findAll().stream().map(MapperGuide.INSTANCE::charterToCharterDto).toList();
    }

    @Override
    public Charter create(CharterDto dto) {
        return charterRepository.save(MapperGuide.INSTANCE.charterDtoToCharter(dto));
    }

    @Override
    public void update(CharterDto dto) {
        charterRepository.update(MapperGuide.INSTANCE.charterDtoToCharter(dto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Charter> charter = charterRepository.finById(id);
        charter.ifPresent(ch -> charterRepository.delete(ch.getId()));
        return charter.isPresent();
    }
}
