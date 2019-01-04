package com.example.shiro2.controller;

import com.example.shiro2.entity.User;
import com.example.shiro2.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login( String username, String password, HttpSession httpSession){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            if(subject.getPrincipal()==null){
                logger.error("身份为空");
                return "/login";
            }
            User user = (User) subject.getPrincipal();
            httpSession.setAttribute("user",user);
            return "/index";

        }
        catch(AuthenticationException e){
            logger.error(""+e);
          return "/login";
        }

    }
    @RequestMapping("/index1")
    public String index(){
        return "login";
    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/index1";

    }


}
