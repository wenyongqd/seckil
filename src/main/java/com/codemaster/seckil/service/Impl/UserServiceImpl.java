package com.codemaster.seckil.service.Impl;


import com.codemaster.seckil.VO.UserVO;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.redis.UserRedis;
import com.codemaster.seckil.repository.UserRepository;
import com.codemaster.seckil.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserRedis userRedis;

    @Override
    public User regist(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserVO getUser(String username) {
        UserVO userVO = new UserVO();
        User user = userRedis.get(username);
        if(user == null) {
            user = userRepository.findByUsername(username);
            if(user != null) {
                userRedis.put(user.getUsername(),user,-1);
            } else {
                return null;
            }
        }
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    @Override
    public void saveUserToRedisByToken(UserVO userVO, String token) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        userRedis.put(token,user,3600);
    }

    @Override
    public Object getUserFromRedisByToken(String token) {
        return userRedis.get(token);
    }
}