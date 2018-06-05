package com.my.shop.shopmanagerweb.controller;

import org.apache.hadoop.fs.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import org.apache.hadoop.conf.Configuration;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PictureController {
    @RequestMapping("/pic/upload")
    public Map picUpload(MultipartFile uploadFile) {
        try {
            //接收上传的文件
            //取扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //上传到图片服务器
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://192.168.56.100:9000");
            conf.set("dfs.replication", "2");//默认为3
            FileSystem fileSystem = FileSystem.get(conf);

            FSDataOutputStream out = fileSystem.create(new Path("/picture/"+originalFilename));
            InputStream in = uploadFile.getInputStream();
            byte[] buf = new byte[4096];
            int len = in.read(buf);
            while(len != -1) {
                out.write(buf,0,len);
                len = in.read(buf);
            }
            in.close();
            out.close();
            String url =  "/picture/"+originalFilename;
            /*FastDFSClient fastDFSClient = new FastDFSClient("classpath:resource/client.conf");
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            url = IMAGE_SERVER_URL + url;*/
            //响应上传图片的url
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return result;
        }
    }

    @RequestMapping(value = {"/picture/{url:.+}"}, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
    public String execute(@PathVariable String url,
                          HttpServletResponse httpServletResponse) throws Exception{
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.56.100:9000");
        conf.set("dfs.replication", "2");//默认为3
        FileSystem fileSystem = FileSystem.get(conf);
        FSDataInputStream in = fileSystem.open(new Path("/picture/"+url));
        httpServletResponse.setContentType("image/png");
        OutputStream os = httpServletResponse.getOutputStream();
        byte[] car = new byte[1024];
        int length = 0;
        while ((length= in.read(car))!=-1){
            os.write(car,0,length);
        }
        os.flush();
        os.close();
        return "success";
    }

    @RequestMapping("/test/{hello}")
    public void test(@PathVariable String hello){
        System.out.println(hello);
    }
}
