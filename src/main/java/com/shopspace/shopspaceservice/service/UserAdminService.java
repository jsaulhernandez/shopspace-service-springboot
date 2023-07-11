package com.shopspace.shopspaceservice.service;

import com.shopspace.shopspaceservice.model.UserAdmin;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserAdminService {
    Page<UserAdmin> getPagedUsersAdmins(String search, Integer page, Integer size);

    Optional<UserAdmin> getUserAdminById(Long id);

    UserAdmin create(UserAdmin userAdmin);

    Boolean delete(Long id);

    Optional<UserAdmin> getUserAdminByEmail(String userEmail);
}
