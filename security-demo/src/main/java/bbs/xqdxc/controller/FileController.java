//package bbs.xqdxc.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import bbs.xqdxc.dto.FileInfo;
//
//import java.io.File;
//import java.util.Date;
//
//@RestController
//@RequestMapping("/file")
//public class FileController {
//
//    @PostMapping
//    public FileInfo upload(MultipartFile file) throws Exception{
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getName());
//        System.out.println(file.getSize());
//
//        // 存放文件夹
//        String folder = "/Users/feng/works/future/security-projects/security-demo/src/main/java/bbs/xqdxc/controller";
//        File localFile = new File(folder, new Date().getTime()+".txt");
//        file.transferTo(localFile);
//
//        return new FileInfo(localFile.getAbsolutePath());
//    }
//
////    @GetMapping
//}
