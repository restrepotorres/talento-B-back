package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.ScriptEntity;
import com.victor.scriptGestor.Service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/script")
public class ScriptController {
    @Autowired
    ScriptService service;

    @GetMapping("/getall")
    public List<ScriptEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ScriptEntity> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getbygenreid/{id}")
    public List<ScriptEntity> getByPoseId(@PathVariable Integer id) {
        return service.getByGenreid(id);
    }

    @GetMapping("/getbyname/{name}")
    public List<ScriptEntity> getByScriptName(@PathVariable String name) {
        return service.getByName(name);
    }

    @GetMapping("/getbygenrename/{name}")
    public List<ScriptEntity> getByGenreName(@PathVariable String name) {
        return service.getByGenreName(name);
    }

    @PostMapping("/save")
    public ScriptEntity create(@RequestBody ScriptEntity entity){
        return service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
