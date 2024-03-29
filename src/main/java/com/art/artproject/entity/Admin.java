package com.art.artproject.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.MediaType;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin_art")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mail;
    private String password;

    public Admin(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

}
