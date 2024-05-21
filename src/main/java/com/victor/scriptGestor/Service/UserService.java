package com.victor.scriptGestor.Service;

import com.victor.scriptGestor.Entity.DialogEntity;
import com.victor.scriptGestor.Entity.UserEntity;
import com.victor.scriptGestor.Repository.DialogRepository;
import com.victor.scriptGestor.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserEntity> getAll() {

        return repository.findAll();
    }
    public Optional<UserEntity> getById(Integer id) {
        return repository.findById(id);
    }

    public UserEntity save(UserEntity entity){
        return this.repository.save(entity);
    }
    public void delete(int id){
        repository.deleteById(id);
    }


    public List<UserEntity> getByEmail (String email){
        return repository.findByemail(email);
    }
}
