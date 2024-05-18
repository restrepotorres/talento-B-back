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
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idposition")
    private int idPosition;
    @Column(name = "x")
    private int x;
    @Column(name = "y")
    private int y;
    @Column(name = "z")
    private int z;
    @Column(name = "xrotation")
    private int xRotation;
    @Column(name = "yrotation")
    private int yRotation;
    @Column(name = "zrotation")
    private int zRotation;

    @ManyToOne
    @JoinColumn(name = "idpose", referencedColumnName = "idpose")
    private PoseEntity pose;
}
