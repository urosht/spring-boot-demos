package com.urosht.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.urosht.demo.enums.FavoriteFood;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cat {
	@Id
	@Column(name = "id", columnDefinition = "BIGINT(20)")
	private String name;
	@Column(name = "age", columnDefinition = "INT(4)")
	private int age;
	@Column(name = "color", columnDefinition = "VARCHAR(20)")
	private String color;
	@Enumerated(EnumType.STRING)
    @Column(name = "favorite_food")
    private FavoriteFood favoriteFood;
}
