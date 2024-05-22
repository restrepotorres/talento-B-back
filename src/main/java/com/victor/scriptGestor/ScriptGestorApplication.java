package com.victor.scriptGestor;

import com.victor.scriptGestor.Entity.GenreEntity;
import com.victor.scriptGestor.Repository.GenreRepository;
import com.victor.scriptGestor.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class ScriptGestorApplication {





	public static void main(String[] args) {
		SpringApplication.run(ScriptGestorApplication.class, args);
	}

}
