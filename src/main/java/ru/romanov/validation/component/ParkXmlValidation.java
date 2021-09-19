package ru.romanov.validation.component;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkXmlValidation {

    private String address;
    private String name;
    private Integer capacity; // вместимость парка
    private Integer benchCount; // скамейки
    private Integer treesCount; // деревья
    private Integer lampPostCount; // фонари
}
