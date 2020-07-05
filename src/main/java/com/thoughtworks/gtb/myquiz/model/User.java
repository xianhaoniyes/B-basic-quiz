package com.thoughtworks.gtb.myquiz.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message="the name field can not be null")
    @Size(min=1,max=128, message="the length of the name must be between 1 and 128")
    private String name;

    @NotNull(message = "age can't be null")
    @Min(value = 16,message = "for your age: your must be larger than 16!")
    private Long age;

    @NotNull(message = "avatar link can't be null")
    @Size(min=8,max=128, message = "the length of the avatar link must be between 8 and 512")
    private String avatar;

    @Size(min=0,max=1024,message = "the length of your description must be between 0 and 1024")
    private String description;

}
