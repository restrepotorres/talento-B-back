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

    @Column(name = "idposition")
    private int idPosition;

    @Column(name = "idscript")
    private int idScript;

    @Column(name = "actor")
    private String actor;

    @ManyToOne
    @JoinColumn(name = "idposition", referencedColumnName = "idposition", insertable = false, updatable = false)
    private PositionEntity position;

    @ManyToOne
    @JoinColumn(name = "idscript", referencedColumnName = "idscript", insertable = false, updatable = false)
    private ScriptEntity script;
}
