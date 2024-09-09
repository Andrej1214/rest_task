package com.pavlov.first_rest.entry;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Data
@Setter
@Getter
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column(unique = true, nullable = false)
    private String name;
//    @Column(nullable = false)
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
