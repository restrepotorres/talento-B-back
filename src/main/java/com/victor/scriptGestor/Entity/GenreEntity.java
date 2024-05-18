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
@Table(name = "genre")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgenre")
    private String idgenre;

    @Column(name = "genrename")
    private String genreName;
}
