package com.sdu.www.dms.service.impl;

import com.sdu.www.dms.dao.ILoginAndRegisterDao;
import com.sdu.www.dms.entity.User;
import com.sdu.www.dms.service.ILoginAndRegisterSc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/8.
 */
@Service
public class LoginAndRegisterSc implements ILoginAndRegisterSc {

    private Logger log= LoggerFactory.getLogger(LoginAndRegisterSc.class);

    @Autowired
    ILoginAndRegisterDao loginAndRegisterDao;

    public String ckeckUser(User user){
        String username=user.getUsername();
        String password=user.getPassword();
        String password_select=loginAndRegisterDao.checkUser(username);
        if(password.equals(password_select)){
            return "main";
        }
        return "error";
    }

    /**
     * 添加新用户
     * @param user
     * @return int
     */
    public int addNewUser(User user){
        String result="false";
        String uid=user.getUid();
        String username=user.getUsername();
        String password=user.getPassword();
        Date lrsj=user.getLrsj();
        log.info(uid+";"+lrsj);
        return loginAndRegisterDao.addNewUser(uid,username,password,lrsj);
    }
}
