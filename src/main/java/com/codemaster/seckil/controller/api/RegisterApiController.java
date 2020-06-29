package com.codemaster.seckil.controller.api;

import com.codemaster.seckil.VO.UserVO;
import com.codemaster.seckil.base.controller.BaseApiController;
import com.codemaster.seckil.base.result.Result;
import com.codemaster.seckil.base.result.ResultCode;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.UserService;
import com.codemaster.seckil.util.MD5Util;
import com.codemaster.seckil.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class RegisterApiController extends BaseApiController {

    private static Logger log = LoggerFactory.getLogger(LoginApiController.class);

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/registerAPI")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
        // Validate passwords match

        User newUser = userService.saveUser(user);

        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }

}
