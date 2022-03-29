package com.example.demo.controller;


import com.example.demo.model.UploadFileResponse;
import com.example.demo.service.FileService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
/***
 *功能描述
 * @author shaoyu
 * @date 2022/3/23
 * @param null
 * @return
 * @Description :用于处理文件的
 */
@Api(value = "上传文件", tags = "上传文件")
public class FileController {
    /**
     * 用于处理日志
     */
    private static final Logger logger = LoggerFactory.getLogger ( FileController.class );

    @Autowired
    private FileService fileService;


    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
     * @param file
     * @return com.example.demo.model.UploadFileResponse
     * @Description :用于上传单个文件的
     */

    @ResponseBody
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = fileService.storeFile ( file );
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath ()
                .path ( "/downloadFile/" )
                .path ( fileName )
                .toUriString ();
        return new UploadFileResponse ( fileName, fileDownloadUri, file.getContentType (), file.getSize () );

    }

    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
     * @param files
     * @return java.util.List<com.example.demo.model.UploadFileResponse>
     * @Description :上传多个文件 （不可上文图片或者视频）
     */

    @ResponseBody
    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        List<UploadFileResponse> list = new ArrayList<> ();
        if ( files != null ) {
            for (MultipartFile multipartFile : files) {
                UploadFileResponse uploadFileResponse = uploadFile ( multipartFile );
                list.add ( uploadFileResponse );
            }
        }
        return list;
        //简单写法
     /* return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());*/
    }


    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
     * @param fileName
     * @param request
     * @return org.springframework.http.ResponseEntity<org.springframework.core.io.Resource>
     * @Description :下载文件
     */

    @GetMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName, HttpServletRequest request) {
        Resource resource = fileService.loadFileAsResource ( fileName );
        String contentType = null;
        try {
            request.getServletContext ().getMimeType ( resource.getFile ().getAbsolutePath () );
        } catch (IOException e) {
            logger.info ( "Could not determine file type." );
        }
        if ( contentType == null ) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok ()
                .contentType ( MediaType.parseMediaType ( contentType ) )
                .header ( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename () + "\"" )
                .body ( resource );
    }


    /***
     *功能描述
     * @author shaoyu
     * @date 2022/3/23
     * @return
     * @Description :用于上传视频或者图片
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file) {
        if ( file.isEmpty () ) {
            return "null";
        }
        try {
            String originalFilename = file.getOriginalFilename ();
            //用于判断上传的是否是jpg、mp4、ppt格式的文件
            int start = originalFilename.lastIndexOf(".");
            int length = originalFilename.length ();
            String finalType = originalFilename.substring(start,length);
            String path=".jpg,.mp4,.ppt";
            String [] paths=path.split ( "," );
            List<String> resultList= new ArrayList<>( Arrays.asList(paths));
            if(resultList.indexOf (finalType)<0){
                return "不是jpg、mp4、ppt格式的文件。。。";
            }
            String fileName = originalFilename.substring(0,start);

            byte[] bytes = file.getBytes ();//将文件转为byte
            String videoPath = System.getProperty("user.dir");//获取项目运行的路径（好像是tomcat下的bin目录）
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");//设置时间戳格式
            Date date = new Date();
            String filename = simpleDateFormat.format(date);//将时间戳转为String存储  防止文件名字重复
            //videoPath ="D:/aplus/" +filename;//设置完整路径以及文件名（因为之前get到的在bin目录下，所以要返回上一层目录才能到达webapp目录）
             videoPath ="D:/aplus/" +fileName+filename+finalType;//这个是为了获取上传的文件格式  设置完整路径以及文件名（因为之前get到的在bin目录下，所以要返回上一层目录才能到达webapp目录）
            System.out.println (videoPath);
            OutputStream outputStream=new FileOutputStream ( videoPath );
            outputStream.write ( bytes );
            outputStream.flush ();
            outputStream.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return "success";
    }


}
