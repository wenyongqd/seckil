package com.codemaster.seckil.controller;

import com.codemaster.seckil.base.controller.BaseApiController;
import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.UserService;
import com.codemaster.seckil.util.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
public class RegisterController extends BaseApiController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    public UserService userService;

    @RequestMapping(value="/reg", method=RequestMethod.GET)
    public String toRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping(value="/register")
    public ModelAndView register(@ModelAttribute(value="user") @Valid User user, BindingResult bindingResult){
        log.info("username="+user.getUsername()+";password="+user.getPassword());
        if(bindingResult.hasErrors()){
            return new ModelAndView("register");
        }
        String salt = "alex";
        String newPassword = MD5Util.formToDB(user.getPassword(), salt);
        user.setId(2018);
        user.setPassword(newPassword);
        user.setDbflag(salt);
        userService.regist(user);
        return new ModelAndView("register");

    }
}

