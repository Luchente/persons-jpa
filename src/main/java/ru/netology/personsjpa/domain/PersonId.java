package ru.netology.personsjpa.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Embeddable
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class PersonId implements Serializable {
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "surname", nullable = false, length = 50)
    private String surname;

    @Column(name = "age", nullable = false)
    private Integer age;
}
