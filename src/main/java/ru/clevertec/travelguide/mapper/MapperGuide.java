package ru.clevertec.travelguide.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.clevertec.travelguide.dto.AuthorDto;
import ru.clevertec.travelguide.dto.CharterDto;
import ru.clevertec.travelguide.dto.CommentDto;
import ru.clevertec.travelguide.dto.GuideDto;
import ru.clevertec.travelguide.dto.PictureDto;
import ru.clevertec.travelguide.dto.UserDto;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.entities.Charter;
import ru.clevertec.travelguide.entities.Comment;
import ru.clevertec.travelguide.entities.Guide;
import ru.clevertec.travelguide.entities.Picture;
import ru.clevertec.travelguide.entities.User;

@Mapper
public interface MapperGuide {
    MapperGuide INSTANCE = Mappers.getMapper(MapperGuide.class);

    AuthorDto authorToAuthorDto(Author author);

    Author authorDtoToAuthor(AuthorDto authorDto);

    CharterDto charterToCharterDto(Charter charter);

    Charter charterDtoToCharter(CharterDto charterDto);

    CommentDto commentToCommentDto(Comment comment);

    Comment commentDtoToComment(CommentDto commentDto);

    GuideDto guideToGuideDto(Guide guide);

    Guide guideDtoToGuide(GuideDto guideDto);

    PictureDto pictureToPictureDto(Picture picture);

    Picture pictureDtoToPicture(PictureDto pictureDto);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);
}
