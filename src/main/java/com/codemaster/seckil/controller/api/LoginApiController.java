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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class LoginApiController extends BaseApiController {
    private static Logger log = LoggerFactory.getLogger(LoginApiController.class);

    @Autowired
    public UserService userService;


    @CrossOrigin(origins = "http://localhost:8080", allowCredentials = "true")
    @RequestMapping(value = "/login")
    public Result<Object> login(@ModelAttribute(value = "user") @Valid User user, BindingResult bindingResult, HttpSession session, Model model, String code, HttpServletResponse response) {
        log.info("username="+user.getUsername()+";password="+user.getPassword());
        if(bindingResult.hasErrors()) {
            return Result.failure();
        }
//        String sessionCode = (String) session.getAttribute("code");
//        if(!StringUtils.equalsIgnoreCase(code, sessionCode)) {
//            model.addAttribute("message", "The validation code does not match");
//            return "login";
//        }
//        log.info("----------------------"+user.getPassword());
        //用户是否存在
        UserVO dbUser = userService.getUser(user.getUsername());
        log.info("username="+dbUser.getUsername()+";password="+dbUser.getPassword());
        //密码是否一致
        if(dbUser != null){
            if(dbUser.getPassword().equals(MD5Util.inputToDb(user.getPassword(), dbUser.getDbflag()))){
                //保存session
                //session.setAttribute("user", userVO);
                //将User信息存入redis
                String token = UUIDUtil.getUUID();
                userService.saveUserToRedisByToken(dbUser, token);
                Cookie cookie = new Cookie("token", token);
                cookie.setMaxAge(3600);
                cookie.setPath("/");
                response.addCookie(cookie);

                return Result.success();	// Result.success(); 200, "success"
            }else{
                return Result.failure(ResultCode.USER_LOGIN_ERROR);
            }
        }else{
            return Result.failure(ResultCode.USER_LOGIN_ERROR);
        }
    }

//    @RequestMapping(value = "/validateCode")
//    public String validateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        //设置响应的类型格式为图片格式
//        response.setContentType("image/jpeg");
//        //禁止图片缓存
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "co-cache");
//        response.setDateHeader("Expires", 0);
//
//        HttpSession session = request.getSession();
//
//        ValidateCode vCode = new ValidateCode(120, 34, 5, 100);
//        session.setAttribute("code", vCode.getCode());
//        vCode.write(response.getOutputStream());
//        return null;
//    }


}
