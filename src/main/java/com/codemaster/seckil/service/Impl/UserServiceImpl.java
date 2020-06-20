package com.codemaster.seckil.service.Impl;


import com.codemaster.seckil.model.User;
import com.codemaster.seckil.repository.UserRepository;
import com.codemaster.seckil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

    @Override
    public User regist(User user) {
        return userRepository.saveAndFlush(user);
    }


}