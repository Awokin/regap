//package com.project.regap.controller;
//
//import com.project.regap.domain.FileUpload;
//import com.project.regap.domain.UserDTO;
//import com.project.regap.domain.UserDao;
//import com.project.regap.message.ResponseMessage;
////import com.project.regap.service.FileStorageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//@CrossOrigin("http://localhost:8081")
//public class FileStorageController {
//
////    @Autowired
////    FileStorageService storageService;
//
//    FileUpload upload;
//
//    @PostMapping("/upload")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("resume") MultipartFile resume, @RequestParam("passport") MultipartFile passport,UserDao user) {
//        String message = "";
//        UserDTO userd = new UserDTO();
//
//        userd.setFirst_name(user.getFirst_name());
//        userd.setLast_name(user.getLast_name());
//        userd.setAddress(user.getAddress());
//        //userd.
//
//        try {
//
//            storageService.save(resume,passport,userd);
//
//            message = "Resume uploaded successfully: " + resume.getOriginalFilename();
//            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//
//        } catch (Exception e) {
//            message = "Could not upload the file: " + resume.getOriginalFilename() + "!";
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//        }
//    }
//
//    @GetMapping("/files")
//    public ResponseEntity<List<FileUpload>> getListFiles() {
//        List<FileUpload> fileInfos = storageService.loadAll().map(path -> {
//            String filename = path.getFileName().toString();
//            String url = MvcUriComponentsBuilder
//                    .fromMethodName(FileStorageController.class, "getFile", path.getFileName().toString()).build().toString();
//
//            return new FileUpload(filename, url);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
//    }
//
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
//        Resource file = storageService.load(filename);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//}
