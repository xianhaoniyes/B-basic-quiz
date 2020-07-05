package com.thoughtworks.gtb.myquiz.model;


import javax.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "year can not be null")
    private Long year;

    @NotNull(message = "title can not be null")
    @Size(min=1,max=256, message = "the length of the title must be between 8 and 512")
    private String title;

    @NotNull(message = "description can not be null")
    @Size(min=1,max=256, message = "the length of the description must be between 1 and 4096")
    private String description;

    @ManyToOne
    private User user;

}
