package ru.romanov.validation;

import ru.romanov.validation.component.ParkAnnotationValidation;
import ru.romanov.validation.component.ParkXmlValidation;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Описать класс Парк.
 * С помощью стандартного API валидации с использованием стандартных аннотаций произвести валидацию класса Парк.
 * Валидацию провести с использованием аннотаций при описании класса и с указанием ограничений в XML.
 *
 * */

public class App {
    public static void main(String[] args) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        try {
            ParkAnnotationValidation parkAnnotationValidation = ParkAnnotationValidation.builder()
                    .address("Павелецкая, 25")
                    .name("Зарядье")
                    .benchCount(75)
                    .treesCount(450)
                    .capacity(765)
                    .lampPostCount(350)
                    .build();
            Set<ConstraintViolation<ParkAnnotationValidation>> parkViolations = validator.validate(parkAnnotationValidation);

            for (ConstraintViolation<ParkAnnotationValidation> constraintViolation : parkViolations) {
                System.out.println("Ошибки: \n" +
                        "Поле - " + constraintViolation.getPropertyPath() + "\n" +
                        "Значение - " + constraintViolation.getInvalidValue() + "\n" +
                        "Сообщение об ошибке - " + constraintViolation.getMessage());
            }

            ParkXmlValidation parkXmlValidation = ParkXmlValidation.builder()
                    .address("Петербургская, 44")
                    .name("Олим")
                    .benchCount(95)
                    .treesCount(400)
                    .capacity(1000)
                    .lampPostCount(378)
                    .build();
            Set<ConstraintViolation<ParkXmlValidation>> parkConstraintViolations = validator.validate(parkXmlValidation);

            for (ConstraintViolation<ParkXmlValidation> constraintViolation : parkConstraintViolations) {
                System.out.println("Ошибки: \n" +
                        "Поле - " + constraintViolation.getPropertyPath() + "\n" +
                        "Значение - " + constraintViolation.getInvalidValue() + "\n" +
                        "Сообщение об ошибке - " + constraintViolation.getMessage());
            }

        } finally {
            factory.close();
        }

    }
}
