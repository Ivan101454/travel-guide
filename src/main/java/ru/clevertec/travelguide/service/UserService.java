package ru.clevertec.travelguide.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.travelguide.dao.Repository;
import ru.clevertec.travelguide.dao.UserRepository;
import ru.clevertec.travelguide.dto.UserDto;
import ru.clevertec.travelguide.entities.User;
import ru.clevertec.travelguide.mapper.MapperGuide;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService implements Service<User, UserDto, Long> {

    private final Repository<Long, User> userRepository;

    @Override
    public Optional<UserDto> findById(Long id) {
        return userRepository.finById(id).map(MapperGuide.INSTANCE::userToUserDto);
    }

    @Override
    public List<UserDto> findAllAuthor() {
        return userRepository.findAll().stream().map(MapperGuide.INSTANCE::userToUserDto).toList();
    }

    @Override
    public User create(UserDto dto) {
        return userRepository.save(MapperGuide.INSTANCE.userDtoToUser(dto));
    }

    @Override
    public void update(UserDto dto) {
        userRepository.update(MapperGuide.INSTANCE.userDtoToUser(dto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> user = userRepository.finById(id);
        user.ifPresent(u -> userRepository.delete(u.getId()));
        return user.isPresent();
    }
}
