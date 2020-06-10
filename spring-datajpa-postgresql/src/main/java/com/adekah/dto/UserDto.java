package com.adekah.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class UserDto {

    private Long id;

    @NotNull
    private String name;

    private String surname;

    private List<String> addresses;
}
