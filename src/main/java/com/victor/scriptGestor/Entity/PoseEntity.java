package com.victor.scriptGestor.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Table(name = "pose")
public class PoseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpose")
    private int idPose;

    @Column(name = "posename")
    private String poseName;


}
