package com.codemaster.seckil.service;

import com.codemaster.seckil.VO.UserVO;
import com.codemaster.seckil.model.User;

public interface UserService {

    public User regist(User user);

    public UserVO getUser(String username);

    public User saveUser(User user);

    void saveUserToRedisByToken(UserVO userVO, String token);

    Object getUserFromRedisByToken(String token);
}
