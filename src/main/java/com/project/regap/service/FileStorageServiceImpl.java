//package com.project.regap.service;
//
//import com.project.regap.domain.FileInfo;
//import com.project.regap.domain.UserDTO;
//import com.project.regap.domain.UserDao;
////import com.project.regap.repository.FileRepository;
//import com.project.regap.repository.UserJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.FileSystemUtils;
//import org.springframework.util.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Date;
//import java.util.stream.Stream;
//
//@Service
//@Transactional
//public class FileStorageServiceImpl implements FileStorageService {
//
//    @Autowired
//    UserJpaRepository repo;
//
//    @Autowired
//    FileRepository fileRepository;
//
//    private final Path root = Paths.get("uploads");
//    @Override
//    public void init() {
//        try {
//            Files.createDirectory(root);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not initialize folder for upload!");
//        }
//    }
//
//    @Override
//    public void save(MultipartFile resume, MultipartFile passport, UserDTO user) throws IOException {
//
//        String resumeName = StringUtils.cleanPath(resume.getOriginalFilename());
//
//        String passportName = StringUtils.cleanPath(passport.getOriginalFilename());
//
//        UserDTO userdto = new UserDTO();
//        userdto.setFirst_name(user.getFirst_name());
//        userdto.setLast_name(user.getLast_name());
//        userdto.setAddress(user.getAddress());
//        userdto.setAge(user.getAge());
//
////        FileInfo info = new FileInfo();
////        info.setResume_name(resumeName);
////        info.setResume_size(resume.getSize());
////        info.setResume_content(resume.getBytes());
////        info.setResume_uploadTime(new Date());
////
////        info.setPassport_name(passportName);
////        info.setPassport_content(resume.getBytes());
////        info.setPassport_size(resume.getSize());
////        info.setPassport_uploadTime(new Date());
//
////        userdto.setUpload(info);
//
//        repo.save(userdto);
//
//        try {
//
//              Files.copy(resume.getInputStream(), this.root.resolve(resume.getOriginalFilename()));
//              Files.copy(passport.getInputStream(), this.root.resolve(passport.getOriginalFilename()));
//
//
//        } catch (Exception e) {
//            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
//        }
//
//
//    }
//
//    @Override
//    public void save(MultipartFile resume, MultipartFile passport, UserDao userdt) {
//
////        String resumeName = StringUtils.cleanPath(resume.getOriginalFilename());
////
////        String passportName = StringUtils.cleanPath(passport.getOriginalFilename());
////
////        UserDTO userdto = new UserDTO();
////        userdto.setFirst_name(userdt.getFirst_name());
////        userdto.setLast_name(userdt.getLast_name());
////        userdto.setAddress(userdt.getAddress());
////        userdto.setAge(userdt.getAge());
////
////        FileInfo info = new FileInfo();
////        info.setResume_name(resumeName);
////        info.setResume_size(resume.getSize());
////        info.setResume_content(resume.getBytes());
////        info.setResume_uploadTime(new Date());
////
////        info.setPassport_name(passportName);
////        info.setPassport_content(resume.getBytes());
////        info.setPassport_size(resume.getSize());
////        info.setPassport_uploadTime(new Date());
////
////        userdto.setUpload(info);
////
////        fileRepository.save(userdto);
////
////        try {
////
////
////
////            Files.copy(resume.getInputStream(), this.root.resolve(resume.getOriginalFilename()));
////            Files.copy(passport.getInputStream(), this.root.resolve(passport.getOriginalFilename()));
////
////
////        } catch (Exception e) {
////            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
////        }
////
//
//
//    }
//
//    @Override
//    public Resource load(String filename) {
//        Resource resource;
//        try {
//            Path file = root.resolve(filename);
//            resource = (Resource) new UrlResource(file.toUri());
//
//            if (resource.exists() || resource.isReadable()) {
//                return resource;
//            } else {
//                throw new RuntimeException("Could not read the file!");
//            }
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("Error: " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(root.toFile());
//    }
//
//    @Override
//    public Stream<Path> loadAll() {
//        try {
//            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
//        } catch (IOException e) {
//            throw new RuntimeException("Could not load the files!");
//        }
//    }
//
//    @Override
//    public String saveUser(UserDTO userDTO) {
//
//        UserDTO userExists = repo
//                .findById(userDTO.getId())
//                .get();
//
//        if(userExists.equals(5)){
//
//            throw new IllegalStateException("user exceeded");
//        }
//        repo.save(userDTO);
//        return null;
//    }
//
//
//}
