package ru.netology.personsjpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PERSONS")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Person {

    @EmbeddedId
    private PersonId id;

    @Column(name = "phone_number", length = 32)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false, length = 60)
    private String cityOfLiving;
}
