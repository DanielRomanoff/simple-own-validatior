package ru.romanov.validation.component;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkAnnotationValidation {

    @NotNull(message = "Адрес не может быть пустым")
    private String address;

    @NotNull(message = "Название парка не может быть пустым")
    @Pattern(regexp = "[А-Яа-я]+", message = "В названии парка должны быть только русские буквы")
    private String name;

    @NotNull(message = "Вместимость парка не задана")
    @Min(value = 1, message = "Вместимость парка > 1 человека")
    @Max(value = 2000, message = "Вместимость парка должна быть < 2000 человек")
    private Integer capacity; // вместимость парка

    @NotNull(message = "Количество скамеек в парке не может быть пустым")
    @Min(value = 1, message = "Количество скамеек парка > 1")
    @Max(value = 100, message = "Количество скамеек парка должно быть < 100")
    private Integer benchCount; // скамейки

    @NotNull(message = "Количество деревьев в парке не может быть пустым")
    @Min(value = 1, message = "Количество деревьев в парке должно быть > 1")
    @Max(value = 2500, message = "Количество деревьев в парке должно быть < 2500")
    private Integer treesCount; // деревья

    @NotNull(message = "Количество фонарей в парке не может быть пустым")
    @Min(value = 1, message = "Количество фонарей в парке должно быть > 1")
    @Max(value = 2000, message = "Количество фонарей в парке должно быть < 2500")
    private Integer lampPostCount; // фонари
}
