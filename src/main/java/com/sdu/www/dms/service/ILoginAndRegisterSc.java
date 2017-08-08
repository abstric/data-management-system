package com.sdu.www.dms.service;

import com.sdu.www.dms.entity.User;

/**
 * Created by Administrator on 2017/8/8.
 */
public interface ILoginAndRegisterSc {
    String ckeckUser(User user);
    int addNewUser(User user);
}
