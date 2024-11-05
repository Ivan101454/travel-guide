package ru.clevertec.travelguide.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dto.GuideDto;
import ru.clevertec.travelguide.entities.Guide;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class GuideService implements Service<Guide, GuideDto, Long> {

    private final Repository<Long, Guide> guideRepository;

    @Transactional
    @Override
    public Optional<GuideDto> findById(Long id) {
        return guideRepository.finById(id).map(MapperGuide.INSTANCE::guideToGuideDto);
    }

    @Transactional
    @Override
    public List<GuideDto> findAllAuthor() {
        return guideRepository.findAll().stream().map(MapperGuide.INSTANCE::guideToGuideDto).toList();
    }

    @Transactional
    @Override
    public Guide create(GuideDto dto) {
        return guideRepository.save(MapperGuide.INSTANCE.guideDtoToGuide(dto));
    }

    @Transactional
    @Override
    public void update(GuideDto dto) {
        guideRepository.update(MapperGuide.INSTANCE.guideDtoToGuide(dto));
    }

    @Transactional
    @Override
    public boolean delete(Long id) {
        Optional<Guide> guide = guideRepository.finById(id);
        guide.ifPresent(g -> guideRepository.delete(g.getId()));
        return guide.isPresent();
    }
}
