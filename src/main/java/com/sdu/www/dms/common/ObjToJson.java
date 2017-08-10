package com.sdu.www.dms.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/8/10.
 */
public class ObjToJson {

    private static Logger log= LoggerFactory.getLogger(ObjToJson.class);

    private static ObjectMapper objectMapper;

    /**
     * object to json str.
     * @param obj
     * @return
     */
    public static String ObjToJsonStr(Object obj){
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.error("object to json str was wrong! ",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


}
