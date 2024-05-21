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
@Table(name = "dialogline")
public class DialogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddialogline")
    private int idDialogLine;

    @Column(name = "text")
    private String text;


    @Column(name = "idscript")
    private int idScript;

    @Column(name = "actor")
    private String actor;
    @Column (name = "x")
    private int x;
    @Column (name = "y")
    private int y;
    @Column (name = "z")
    private int z;
    @Column (name = "xR")
    private int xR;
    @Column (name = "yR")
    private int yR;
    @Column (name = "zR")
    private int zR;
    @Column (name = "idpose")
    private int idPose;
    @ManyToOne
    @JoinColumn(name = "idscript", referencedColumnName = "idscript", insertable = false, updatable = false)
    private ScriptEntity script;
    @ManyToOne
    @JoinColumn(name = "idpose", referencedColumnName = "idpose", insertable = false, updatable = false)
    private PoseEntity pose;
}
