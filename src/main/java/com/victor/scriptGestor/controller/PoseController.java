package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.PoseEntity;
import com.victor.scriptGestor.Service.PoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pose")
public class PoseController {
    @Autowired
    PoseService service;
    @GetMapping("/health-check")
    public String helloworld(){
        return "OK";
    }

    @GetMapping("/getall")
    public List<PoseEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PoseEntity> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getbyname")
    public List<PoseEntity> getByName(@RequestParam String posename) {

        return service.getPoseByName(posename);
    }


    @PostMapping("/save")
    public PoseEntity create(@RequestBody PoseEntity entity){
        return service.save(entity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
