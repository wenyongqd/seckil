package com.codemaster.seckil.controller;

import com.codemaster.seckil.model.User;
import com.codemaster.seckil.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private static Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public ModelAndView toRegister(ModelMap model) {
        User user = new User();
        return new ModelAndView("register").addObject(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult) {



        log.info("username="+user.getUsername()+";password="+user.getPassword());

        if(bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        user.setId(2018);
        userService.regist(user);
        return new ModelAndView("register");
//        User newUser = userService.regist(user);
//        if(newUser != null) {
//            return new ModelAndView("home");
//        } else {
//            return new ModelAndView("regiser");
//        }
    }

}
