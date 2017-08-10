package com.sdu.www.dms.dao;


import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
public interface IMainDao {

    /**
     * get file size charts
     * @return
     */
    List<Map<String,Object>> getFileSzieCharts();
}
