package com.sdu.www.dms.ctrl;

import com.sdu.www.dms.dto.FileDto;
import com.sdu.www.dms.service.IUpAndDownLoadSc;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import static com.sdu.www.dms.common.FileUploadUtil.checkFileFormat;

/**
 * Created by Administrator on 2017/8/9.
 */
@Controller
@RequestMapping("/upAndDownLoadCtrl")
public class UpAndDownLoadCtrl {

    private Logger log= LoggerFactory.getLogger(UpAndDownLoadCtrl.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUpAndDownLoadSc upAndDownLoadSc;

    @RequestMapping(value = "/uploadAndDownload")
    public String upload(){
        return "fileoperate/uploadanddownload";
    }

    /**
     * 文件上传
     * @param file
     * @param model
     * @return
     */
    @RequestMapping(value="/fileUpload",method = RequestMethod.POST)
    public String fileUpload(@RequestParam("fileInput") MultipartFile file,Model model){
        String fileName="";//文件名
        String fileType="";//文件类型
        String filePath="";//文件保存路径（不带文件名）
        String path="";//文件保存路径（带文件名）
        long fileSize;//文件大小（字节，byte）
        FileDto fileDto=new FileDto();
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                fileName=file.getOriginalFilename();
                log.info(fileName+" start upload");
                fileType=checkFileFormat(fileName);
                fileSize=file.getSize();

                // 文件保存路径
                filePath= request.getSession().getServletContext().getRealPath("/") + fileType
                        + File.separator ;
                File fileIO=new File(filePath);
                if(!fileIO.exists()){
                    fileIO.mkdirs();
                }
                path=filePath + fileName;

                fileDto.setFileName(fileName);
                fileDto.setFilePath(path);
                fileDto.setFileType(fileType);
                fileDto.setFileSize(fileSize);

                // 转存文件
                file.transferTo(new File(path));
            } catch (Exception e) {
                log.error("file upload failure",e.getMessage());
            }
        }
        int result=upAndDownLoadSc.fileUpload(fileDto);
        if(result<=0){
            return "redirect:/loginAndRegisterCtrl/error";
        }
        model.addAttribute("fileType",fileType);
        return "redirect:/upAndDownLoadCtrl/{fileType}/fileList";
    }

    /***
     * 读取上传文件中得所有文件并返回
     *
     * @return
     */
    @RequestMapping(value="/{fileType}/fileList")
    public ModelAndView fileList(@PathVariable("fileType") String fileType) {
        String filePath="";
        if(!fileType.isEmpty()){
            filePath = request.getSession().getServletContext().getRealPath("/")
                    + fileType + File.separator;
        }

        ModelAndView mav = new ModelAndView("fileoperate/filelist");
        File uploadDest = new File(filePath);
        String[] fileNames = uploadDest.list();
        for (int i = 0; i < fileNames.length; i++) {
            //打印出文件名
//            System.out.println(fileNames[i]);
            mav.addObject("fileName",fileNames[i]);
        }
        return mav;
    }

    /**
     * 文件下载
     * @param fileOutput
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/fileDownload")
    public ResponseEntity<byte[]> fileDownload(@RequestParam("fileOutput") String fileOutput) throws IOException {
        String path="";
        if(!fileOutput.isEmpty()){
            path=upAndDownLoadSc.fileDownload(fileOutput);
        }
        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        String fileName=new String(fileOutput.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

}
