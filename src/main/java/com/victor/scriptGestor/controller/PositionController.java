package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.PoseEntity;
import com.victor.scriptGestor.Entity.PositionEntity;
import com.victor.scriptGestor.Service.PoseService;
import com.victor.scriptGestor.Service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    PositionService service;

    @GetMapping("/getall")
    public List<PositionEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PositionEntity> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public PositionEntity create(@RequestBody PositionEntity entity){
        return service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping ("/findbypose/{poseid}")
//    public ResponseEntity<PositionEntity> getByposeId (@PathVariable Integer poseid){
//        return service.getByposeId(poseid);
//    }
}
