package com.urosht.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.urosht.demo.enums.FavoriteFood;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "BIGINT(20)")
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(name = "age", columnDefinition = "INT(4)")
    private int age;

    @Column(name = "color", columnDefinition = "VARCHAR(20)")
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name = "favorite_food")
    private FavoriteFood favoriteFood;

    @Column(name = "eye_color", columnDefinition = "VARCHAR(45)")
    private String eyeColor;

    public Cat() {
    }

    public Cat(String name, int age, String color, FavoriteFood favoriteFood, String eyeColor) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.favoriteFood = favoriteFood;
        this.eyeColor = eyeColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FavoriteFood getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(FavoriteFood favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

}
