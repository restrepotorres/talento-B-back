package com.victor.scriptGestor.controller;

import com.victor.scriptGestor.Entity.DialogEntity;
import com.victor.scriptGestor.Service.DialogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dialog")
public class DialogController {
    @Autowired
    DialogService service;

    @GetMapping ("/getall")
    public List<DialogEntity> getall(){
        return service.getAll();
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DialogEntity> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getbyscriptid/{id}")
    public List<DialogEntity> getByGenreId(@PathVariable Integer id) {
        return service.getByScriptId(id);
    }
    @PostMapping("/save")
    public DialogEntity create(@RequestBody DialogEntity entity){
        return service.save(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<DialogEntity> updateDialog(@PathVariable Integer id, @RequestBody DialogEntity dialogDetails) {
        try {
            DialogEntity updatedEmployee = service.updateDialog(id, dialogDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
