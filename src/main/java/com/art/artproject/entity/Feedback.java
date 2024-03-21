package com.art.artproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "NVARCHAR(30)") // columnDefinition is used to specify the SQL data type for the column
    private String comment;


    @ManyToOne
    private User user;

    public Feedback( String comment, User user) {
        this.comment = comment;
        this.user = user;
    }
}
