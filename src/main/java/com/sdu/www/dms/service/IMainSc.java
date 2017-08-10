package com.sdu.www.dms.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
public interface IMainSc {
    /**
     * get file size charts
     * @return
     */
    List<Map<String,Object>> getFileSizeCharts();
}
