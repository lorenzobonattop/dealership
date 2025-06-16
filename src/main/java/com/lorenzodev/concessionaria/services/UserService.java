package com.lorenzodev.concessionaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lorenzodev.concessionaria.dto.user.UserCreateDTO;
import com.lorenzodev.concessionaria.models.User;
import com.lorenzodev.concessionaria.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserCreateDTO createUser(UserCreateDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setIsActive(userDTO.getIsActive());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        
        userRepository.save(user);
        
        UserCreateDTO responseDTO = new UserCreateDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setPassword(user.getPassword());
        responseDTO.setPhone(user.getPhone());
        responseDTO.setRole(user.getRole());
        responseDTO.setIsActive(user.getIsActive());
        responseDTO.setCreatedAt(user.getCreatedAt());
        responseDTO.setUpdatedAt(user.getUpdatedAt());
        
        return responseDTO;
    }

    @Transactional(readOnly = true)
    public UserCreateDTO getUserById(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        
        UserCreateDTO responseDTO = new UserCreateDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setPassword(user.getPassword());
        responseDTO.setPhone(user.getPhone());
        responseDTO.setRole(user.getRole());
        responseDTO.setIsActive(user.getIsActive());
        responseDTO.setCreatedAt(user.getCreatedAt());
        responseDTO.setUpdatedAt(user.getUpdatedAt());
        
        return responseDTO;
    }

    @Transactional
    public UserCreateDTO updateUser(UUID id, UserCreateDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setIsActive(userDTO.getIsActive());
        user.setUpdatedAt(LocalDateTime.now());
        
        userRepository.save(user);
        
        UserCreateDTO responseDTO = new UserCreateDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setPassword(user.getPassword());
        responseDTO.setPhone(user.getPhone());
        responseDTO.setRole(user.getRole());
        responseDTO.setIsActive(user.getIsActive());
        responseDTO.setCreatedAt(user.getCreatedAt());
        responseDTO.setUpdatedAt(user.getUpdatedAt());
        
        return responseDTO;
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}