package ru.clevertec.travelguide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.travelguide.entities.Author;
import ru.clevertec.travelguide.entities.Charter;
import ru.clevertec.travelguide.entities.Picture;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideDto implements Dto {
    private Long id;
    private String nameOfGuide;
    private LocalDateTime dateOfCreate;
    private Author author;
    private Picture headPicture;
    private String descriptionOfGuide;
    private List<Charter> contentsCharter;
}
