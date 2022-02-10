package com.project.regap.service;

import com.project.regap.domain.UserDTO;
import com.project.regap.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserJpaRepository useRepository;

    @Override
    public List<UserDTO> listAll() {
        return useRepository.findAll();
    }

    @Override
    public void save(UserDTO user) {

        useRepository.save(user);
    }

    @Override
    public UserDTO get(Long id) {
        return useRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        useRepository.deleteById(id);
    }

}
