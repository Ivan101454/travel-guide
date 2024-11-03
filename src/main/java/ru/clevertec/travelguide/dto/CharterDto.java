package ru.clevertec.travelguide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.travelguide.entities.Guide;
import ru.clevertec.travelguide.entities.Picture;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CharterDto implements Dto {
    private Long id;
    private String nameCharter;
    private Picture pictureForCharter;
    private String textCharter;
    private Guide guide;
}
