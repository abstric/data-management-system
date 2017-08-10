package com.sdu.www.dms.service;

import com.sdu.www.dms.dto.FileDto;

/**
 * Created by Administrator on 2017/8/9.
 */
public interface IUpAndDownLoadSc {

    /**
     * 文件上传
     * @param fileDto
     * @return
     */
    int fileUpload(FileDto fileDto);

    /**
     * 文件下载
     * @param fileName
     * @return
     */
    String fileDownload(String fileName);
}
