package com.project.regap.service;

import com.project.regap.domain.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> listAll();
    void save(UserDTO user);
    UserDTO get(Long id);
    void delete(Long id);

}
