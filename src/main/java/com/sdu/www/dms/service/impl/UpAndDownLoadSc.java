package com.sdu.www.dms.service.impl;

import com.sdu.www.dms.dao.IUpAndDownLoadDao;
import com.sdu.www.dms.dto.FileDto;
import com.sdu.www.dms.service.IUpAndDownLoadSc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/8/9.
 */
@Service
public class UpAndDownLoadSc implements IUpAndDownLoadSc {

    private Logger log= LoggerFactory.getLogger(UpAndDownLoadSc.class);

    @Autowired
    private IUpAndDownLoadDao upAndDownLoadDao;

    /**
     * 文件上传成功后，保存文件基本信息
     * @param fileDto
     * @return
     */
    public int fileUpload(FileDto fileDto) {
        long time=System.currentTimeMillis();
        Date lrsj=new Date(time);
        UUID uuid=UUID.randomUUID();
        String file_id=uuid.toString().replaceAll("-","");
        file_id=file_id.substring(0,18);
        String fileName=fileDto.getFileName();
        String fileType=fileDto.getFileType();
        String fileExistsId=upAndDownLoadDao.fileExists(fileName,fileType);
        int result=1;
        String operateType="UPDATE";
        String lrr="";
        if(fileExistsId==null || fileExistsId.isEmpty()){
            operateType="UPLOAD";
            result=upAndDownLoadDao.fileUploadPath(file_id,
                    fileName,
                    fileType,
                    fileDto.getFilePath(),
                    lrsj,
                    fileDto.getFileSize(),
                    lrr);
        }else{
            file_id=fileExistsId;
        }

        upAndDownLoadDao.fileUploadOperateRecord(file_id,
                fileName,
                fileType,
                operateType,
                lrsj,
                lrr);
        return result;
    }
}
