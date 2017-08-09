package com.sdu.www.dms.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/9.
 */
public interface IUpAndDownLoadDao {
    /**
     * 文件保存路径等基本信息入库
     * @param fileId
     * @param fileName
     * @param fileType
     * @param filePath
     * @param lrsj
     * @param fileSize
     * @return
     */
    int fileUploadPath(@Param("fileId") String fileId,
                       @Param("fileName") String fileName,
                       @Param("fileType") String fileType,
                       @Param("filePath") String filePath,
                       @Param("lrsj") Date lrsj,
                       @Param("fileSize") long fileSize,
                       @Param("lrr") String lrr);

    /**
     * 查询文件是否已经存在
     * @param fileName
     * @param fileType
     * @return
     */
    String fileExists(@Param("fileName") String fileName,@Param("fileType") String fileType);

    /**
     * 文件操作记录
     * @param file_id
     * @param fileName
     * @param fileType
     * @param operateType
     * @param operateTime
     * @return
     */
    int fileUploadOperateRecord(@Param("fileId") String file_id,
                                @Param("fileName") String fileName,
                                @Param("fileType") String fileType,
                                @Param("operateType") String operateType,
                                @Param("operateTime") Date operateTime,
                                @Param("operatePersion") String operatePersion);
}
