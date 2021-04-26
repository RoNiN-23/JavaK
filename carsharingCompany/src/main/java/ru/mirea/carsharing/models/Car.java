package ru.mirea.carsharing.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mark;
    private String color;
    private String number;

    public Car() {
    }

    public Car(String mark, String color, String number) {
        this.mark = mark;
        this.color = color;
        this.number = number;
    }
}
