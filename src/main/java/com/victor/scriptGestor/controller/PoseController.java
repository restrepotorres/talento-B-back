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
    PoseService poseService;
    @GetMapping
    @RequestMapping("/health-check")
    public String helloworld(){
        return "OK";
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PoseEntity> getById(@PathVariable Integer id) {
        return poseService.getPoseById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/getbyname")
    public List<PoseEntity> getByName(@RequestParam String posename) {
        return poseService.getPoseByName(posename);
    }

    @GetMapping("/getall")
    public List<PoseEntity> getAllEmployees() {
        return poseService.getAllPoses();
        }
    @PostMapping("/save")
    public PoseEntity createPose (@RequestBody PoseEntity poseEntity){
        return poseService.savePose(poseEntity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePose (@PathVariable Integer id){
        poseService.deletePose(id);
        return ResponseEntity.noContent().build();
    }
}
