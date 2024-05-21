package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.DialogEntity;
import com.victor.scriptGestor.Entity.UserEntity;
import com.victor.scriptGestor.Service.DialogService;
import com.victor.scriptGestor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/getall")
    public List<UserEntity> getall(){
        return service.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<UserEntity> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getbyscriptid/{email}")
    public List<UserEntity> getByGenreId(@PathVariable String email) {
        return service.getByEmail(email);
    }
    @PostMapping("/save")
    public UserEntity create(@RequestBody UserEntity entity){
        return service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
