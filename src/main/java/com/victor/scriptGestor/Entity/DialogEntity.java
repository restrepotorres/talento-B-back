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
@Table(name = "dialogLine")
public class DialogEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column(name = "iddialogLine")
    private int idDialogLine;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "idposition", referencedColumnName = "idposition")
    private PositionEntity position;

    @Column (name = "idposition", insertable = false, updatable = false)
    private int idPosition;

//todo find by scriptid

//    @ManyToOne
//    @JoinColumn(name = "idscript", referencedColumnName = "idscript")
//    private ScriptEntity script;
//
//    @Column (name = "idscript", insertable = false, updatable = false)
//    private int idScript;
}
