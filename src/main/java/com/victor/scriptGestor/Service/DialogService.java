package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.DialogEntity;
import com.victor.scriptGestor.Repository.DialogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DialogService {
    @Autowired
    private DialogRepository repository;

    public List<DialogEntity> getAll() {

        return repository.findAll();
    }
    public Optional<DialogEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public DialogEntity save(DialogEntity entity){
        return this.repository.save(entity);
    }
    public void delete(int id){
        repository.deleteById(id);
    }


    public List<DialogEntity> getByScriptId (int scriptId){
        return repository.findByidScript(scriptId);
    }

    public DialogEntity updateDialog(Integer idDialog, DialogEntity dialogDetails){
        DialogEntity dialog = repository.findById(idDialog).orElseThrow(() -> new RuntimeException("Dialog not found"));
        dialog.setActor(dialogDetails.getActor());
        dialog.setIdPose(dialogDetails.getIdPose());
        dialog.setX(dialogDetails.getX());
        dialog.setXR(dialogDetails.getXR());
        dialog.setY(dialogDetails.getY());
        dialog.setYR(dialogDetails.getYR());
        dialog.setZ(dialogDetails.getZ());
        dialog.setZR(dialogDetails.getZR());
        return repository.save(dialog);
    }

}
