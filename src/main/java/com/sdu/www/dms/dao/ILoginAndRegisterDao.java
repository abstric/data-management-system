package com.sdu.www.dms.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface ILoginAndRegisterDao {
    /**
     * check user name and password
     * @param username
     * @return
     */
    String checkUser(@Param("username") String username);

    /**
     * add new user
     * @param uid
     * @param username
     * @param password
     * @param lrsj
     * @return
     */
    int addNewUser(@Param("uid") String uid,
                   @Param("username") String username,
                   @Param("password") String password,
                   @Param("lrsj") Date lrsj);
}
