package com.sdu.www.dms.ctrl;

import com.sdu.www.dms.entity.User;
import com.sdu.www.dms.service.ILoginAndRegisterSc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.UUID;


/**
 * Created by Administrator on 2017/8/8.
 */
@Controller
@RequestMapping("/loginAndResisterCtrl")
public class LoginAndRegisterCtrl {
    static Logger log= LoggerFactory.getLogger(LoginAndRegisterCtrl.class);

    private User user;

    @Autowired
    private ILoginAndRegisterSc loginAndRegisterSc;


    /**
     * 进入登录及注册页面
     * @return
     */
    @RequestMapping(value="/loginAndRegister", method = RequestMethod.GET)
    public String loginAndRegister(){
        return "loginandregister";
    }

    @RequestMapping(value = "/error")
    public String error(){
        return "error";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam(value="login_username") String username,
                        @RequestParam(value="login_password") String password,
                        Model model){
        if(username==null || password==null){
            log.error("sorry!username or password is null.");
            return "redirect:/loginAndResisterCtrl/loginAndRegister";
        }
        log.info("start check username and password!");
        user=new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("username",username);
        return loginAndRegisterSc.ckeckUser(user);
    }

    /**
     * 注册
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(@RequestParam(value="register_username") String username,
                           @RequestParam(value="register_password") String password,
                           @RequestParam(value="register_password_again") String password_again,
                           Model model){
        if(username==null || "".equals(username)){
            log.error("sorry!username is null.");
            model.addAttribute("user","username or password is empty!");
            return "forward:/loginAndResisterCtrl/error";
        }
        if(password==null || "".equals(password)){
            log.error("sorry!password is null.");
            model.addAttribute("user","username or password is empty!");
            return "forward:/loginAndResisterCtrl/error";
        }
        user=new User();
        int result;
        if(password_again!=null){
            if(password.equals(password_again)){
                UUID uuid=UUID.randomUUID();
                String uid=uuid.toString().replaceAll("-","");
                uid=uid.substring(0,18);
                user.setUid(uid);
                user.setUsername(username);
                user.setPassword(password);
                long t=System.currentTimeMillis();
                Date time=new Date(t);
                user.setLrsj(time);
                result=loginAndRegisterSc.addNewUser(user);
            }else {
                model.addAttribute("user","the twice password is not equal!");
                return "forward:/loginAndResisterCtrl/error";
            }
        } else{
            log.error("sorry!password_again is null.");
            model.addAttribute("user","confirm password is empty!");
            return "forward:/loginAndResisterCtrl/error";
        }
        if(result<=0){
            return "error";
        }
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "success";
    }
}
