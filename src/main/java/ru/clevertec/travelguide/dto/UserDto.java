package ru.clevertec.travelguide.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.clevertec.travelguide.enums.Role;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Dto {
    private Long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    private String email;
    private Role role;
}
