package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.PoseEntity;
import com.victor.scriptGestor.Repository.PoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoseService {
    @Autowired
    private PoseRepository poseRepository;

    public List<PoseEntity> getAllPoses() {
        return poseRepository.findAll();
    }
    public Optional<PoseEntity> getPoseById(Integer id) {
        return poseRepository.findById(id);
    }
    public List<PoseEntity> getPoseByName (String name){
        return poseRepository.findByposeName(name);
    }
    public PoseEntity savePose (PoseEntity poseEntity){
        return poseRepository.save(poseEntity);
    }
    public void deletePose (int id){
        poseRepository.deleteById(id);
    }


}
