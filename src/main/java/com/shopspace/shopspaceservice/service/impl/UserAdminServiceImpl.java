package com.shopspace.shopspaceservice.service.impl;

import com.shopspace.shopspaceservice.model.UserAdmin;
import com.shopspace.shopspaceservice.repository.UserAdminRepository;
import com.shopspace.shopspaceservice.service.UserAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAdminServiceImpl implements UserAdminService {
    Logger logger = LoggerFactory.getLogger(UserAdminServiceImpl.class);
    @Autowired
    private UserAdminRepository userAdminRepository;

    @Override
    public Page<UserAdmin> getPagedUsersAdmins(String search, Integer page, Integer size){
        return userAdminRepository.getAllUsersAdmins(search, PageRequest.of(page, size));
    }

    @Override
    public Optional<UserAdmin> getUserAdminById(Long id){
        return userAdminRepository.findById(id);
    }

    @Override
    public UserAdmin create(UserAdmin userAdmin){
        return userAdminRepository.save(userAdmin);
    }

    @Override
    public Boolean delete(Long id){
        try {
            userAdminRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.error("Exception delete user admin -> {0}", e);
            return false;
        }
    }
}
