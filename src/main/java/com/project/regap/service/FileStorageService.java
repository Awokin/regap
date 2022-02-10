//package com.project.regap.service;
//
//import com.project.regap.domain.UserDTO;
//import com.project.regap.domain.UserDao;
//import org.springframework.core.io.Resource;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.util.stream.Stream;
//
//public interface FileStorageService {
//
//    public void init();
//
//    public void save(MultipartFile resume, MultipartFile passport, UserDTO user) throws IOException;
//
//    void save(MultipartFile resume, MultipartFile passport, UserDao userdt) throws IOException;
//
//    public Resource load(String filename);
//
//    public void deleteAll();
//
//    public Stream<Path> loadAll();
//
//    public String saveUser(UserDTO userDTO);
//}
