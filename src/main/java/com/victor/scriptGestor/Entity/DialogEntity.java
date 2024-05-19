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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "iddialogline")
    private int idDialogLine;

    @Column(name = "text")
    private String text;

    @Column (name = "idposition")
    private int idPosition;

    @ManyToOne
    @JoinColumn(name = "idposition", referencedColumnName = "idposition", insertable = false, updatable = false)
    private PositionEntity position;

//todo find by scriptid

//    @ManyToOne
//    @JoinColumn(name = "idscript", referencedColumnName = "idscript")
//    private ScriptEntity script;
//
//    @Column (name = "idscript", insertable = false, updatable = false)
//    private int idScript;
}
