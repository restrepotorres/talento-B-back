package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Integer > {
    List<GenreEntity> findByGenreName (String genreName);
}
