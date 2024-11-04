package ru.clevertec.travelguide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.travelguide.entities.Author;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PictureDto implements Dto {
    private Long id;
    private String namePicture;
    private String descriptionOfPicture;
    private String pathToPictureFile;
    private Author authorOfPicture;
}
