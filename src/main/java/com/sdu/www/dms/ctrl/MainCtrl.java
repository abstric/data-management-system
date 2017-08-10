package com.sdu.www.dms.ctrl;

import com.sdu.www.dms.common.ObjToJson;
import com.sdu.www.dms.service.IMainSc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/10.
 */
@Controller
@RequestMapping("/mainCtrl")
public class MainCtrl {
    private Logger log= LoggerFactory.getLogger(MainCtrl.class);

    @Autowired
    private IMainSc mainSc;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/fileSizeCharts",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String fileSizeCharts(){
        List<Map<String,Object>> fileSizeChartsList=mainSc.getFileSizeCharts();
        return ObjToJson.ObjToJsonStr(fileSizeChartsList);
    }
}
