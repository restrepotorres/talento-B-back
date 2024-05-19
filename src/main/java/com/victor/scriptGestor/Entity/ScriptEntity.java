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
@Table(name = "script")
public class ScriptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idscript")
    private int idScript;

    @Column(name="scriptname")
    private String scriptName;

    @Column(name = "idgenre")
    private int idGenre;

    @ManyToOne
    @JoinColumn(name = "idgenre",referencedColumnName = "idgenre", insertable = false, updatable = false)
    private GenreEntity genre;

}
