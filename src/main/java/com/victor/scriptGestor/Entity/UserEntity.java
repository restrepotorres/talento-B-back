package com.victor.scriptGestor.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int idUser;
    @Column (name = "userName")
    private String userName;
    @Column (name = "email")
    private String email;
    @Column (name= "isadmin")
    private boolean isAdmin;
    @Column (name= "password")
    private String password;
}

