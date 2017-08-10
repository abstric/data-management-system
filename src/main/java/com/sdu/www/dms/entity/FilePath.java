package com.sdu.www.dms.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/10.
 */
public class FilePath {
    private String fileId;
    private String fileName;
    private String fileType;
    private String filePath;
    private String lrr;
    private String xgr;
    private Date lrsj;
    private Date xgsj;
    private long fileSize;
    private int fileDownloadCount;

    @Override
    public String toString() {
        return "FilePath{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", lrr='" + lrr + '\'' +
                ", xgr='" + xgr + '\'' +
                ", lrsj=" + lrsj +
                ", xgsj=" + xgsj +
                ", fileSize=" + fileSize +
                ", fileDownloadCount=" + fileDownloadCount +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getLrr() {
        return lrr;
    }

    public void setLrr(String lrr) {
        this.lrr = lrr;
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr;
    }

    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public int getFileDownloadCount() {
        return fileDownloadCount;
    }

    public void setFileDownloadCount(int fileDownloadCount) {
        this.fileDownloadCount = fileDownloadCount;
    }
}
