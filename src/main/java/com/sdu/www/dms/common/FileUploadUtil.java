package com.sdu.www.dms.common;

import com.sdu.www.dms.enums.FileTypeEnums;
import com.sdu.www.dms.enums.ImgFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/9.
 */
public class FileUploadUtil {
    private static Logger log= LoggerFactory.getLogger(FileUploadUtil.class);

    public static String fileUpload(String fileName){
        log.info(fileName+" start upload. ");

        //get file format
        String fileType=checkFileFormat(fileName);

        //create file save path
        String filePath="/WEB-INF/files/"+fileType;
        File fileDir=new File(filePath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }




        return "";
    }

    /**
     * check file format
     * @param fileName
     * @return
     */
    public static String checkFileFormat(String fileName){
        String[] nameAndFormat=new String[2];
        if(!fileName.isEmpty()&&fileName.contains(".")){
            nameAndFormat=fileName.split("\\.");
        }
        String fileType="";
        ArrayList<String> imgList=new ArrayList<String>();
        imgList.add("JPG");
        imgList.add("JPEG");
        imgList.add("GIF");
        ArrayList<String> docList=new ArrayList<String>();
        docList.add("DOC");
        docList.add("DOCX");
        docList.add("XLSX");
        docList.add("XLS");
        docList.add("TXT");
        docList.add("LOG");
        if(!nameAndFormat[1].isEmpty()){
            String fileFormat=nameAndFormat[1].toUpperCase();
            if(imgList.contains(fileFormat)){
                fileType=FileTypeEnums.IMG.name();
            }else if(docList.contains(fileFormat)){
                fileType=FileTypeEnums.DOC.name();
            }else{
                fileType=FileTypeEnums.OTHERS.name();
            }
        }
        return fileType;
    }


}
