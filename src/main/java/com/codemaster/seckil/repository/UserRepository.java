package com.codemaster.seckil.repository;

import com.codemaster.seckil.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsername(String username);

}
