package com.sdu.www.dms.service.impl;

import com.sdu.www.dms.dao.IUpAndDownLoadDao;
import com.sdu.www.dms.dto.FileDto;
import com.sdu.www.dms.entity.FilePath;
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
        upAndDownLoadDao.fileOperateRecord(file_id,
                fileName,
                fileType,
                operateType,
                lrsj,
                lrr);
        return result;
    }

    /**
     * 文件下载
     * @param fileName
     * @return
     */
    public String fileDownload(String fileName) {
        FilePath filePath=upAndDownLoadDao.getFilePath(fileName);
        String path=filePath.getFilePath();
        int fileDownloadCount=filePath.getFileDownloadCount();
        if(fileDownloadCount==0){
            fileDownloadCount=1;
        }
        if(upAndDownLoadDao.setFileDownloadCount(fileDownloadCount,filePath.getFileId())<=0){
            path="file download count is failure";
        }
        long time=System.currentTimeMillis();
        Date lrsj=new Date(time);
        String lrr="";
        upAndDownLoadDao.fileOperateRecord(filePath.getFileId(),
                filePath.getFileName(),
                filePath.getFileType(),
                "DOWNLOAD",
                lrsj,
                lrr);
        return path;
    }
}
