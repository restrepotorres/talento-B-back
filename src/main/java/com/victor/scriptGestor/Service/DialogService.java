package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.DialogEntity;
import com.victor.scriptGestor.Entity.PositionEntity;
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

    public List<DialogEntity> getByPositionId (int positionId){
        return repository.findByidPosition(positionId);
    }
    //todo find by scriptid

}
