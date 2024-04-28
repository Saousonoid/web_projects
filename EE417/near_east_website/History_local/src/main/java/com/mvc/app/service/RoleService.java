package com.mvc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.entity.RoleEntity;
import com.mvc.app.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleEntity findById(Long id) {
        RoleEntity role = roleRepository.findById(id).orElse(null);
        return role;
    }
}