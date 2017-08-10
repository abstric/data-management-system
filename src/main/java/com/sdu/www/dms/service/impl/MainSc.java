package com.sdu.www.dms.service.impl;

import com.sdu.www.dms.dao.IMainDao;
import com.sdu.www.dms.service.IMainSc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
@Service
public class MainSc implements IMainSc {

    private Logger log= LoggerFactory.getLogger(MainSc.class);

    @Autowired
    private IMainDao mainDao;

    /**
     * get file size charts
     * @return
     */
    public List<Map<String,Object>> getFileSizeCharts() {
        return mainDao.getFileSzieCharts();
    }
}
