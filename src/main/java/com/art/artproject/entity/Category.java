package com.art.artproject.entity;

import com.art.artproject.dto.NewCategoryRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "NVARCHAR(30)") // columnDefinition is used to specify the SQL data type for the column
    private String name;


    public static Category of(NewCategoryRequest request){
        Category category=new Category();
        category.name=request.getName();
        return category;
    }
}