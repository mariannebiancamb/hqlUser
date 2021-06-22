package com.crud.hql.service;

import com.crud.hql.entity.User;
import com.crud.hql.repository.UserRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUSer(User user){
        return userRepository.save(user);
    }

    public List<User> findByName(String name){
        return userRepository.findAllByName(name);
    }

    public User update(User user){
        User userRep = userRepository.findById(user.getId()).get();
        userRep.setUserName(user.getUserName());
        userRep.setPassword(user.getPassword());

        return userRepository.save(userRep);
    }

    public Integer delete(long id){
        return userRepository.deleteUserByID(id);
    }


}
