package com.shopspace.shopspaceservice.controller;

import com.shopspace.shopspaceservice.model.UserAdmin;
import com.shopspace.shopspaceservice.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/user-admin")
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;

    @GetMapping(path = "/paged", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Page<UserAdmin> getPagedUsersAdmins(@RequestParam(value = "search", defaultValue = "") String search, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size){
        return userAdminService.getPagedUsersAdmins(search, page, size);
    }

    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Optional<UserAdmin> getOneUserAdmin(@PathVariable("id") Long id){
        return userAdminService.getUserAdminById(id);
    }

    @PostMapping(path = "/create", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public UserAdmin create(@RequestBody UserAdmin userAdmin){
        return userAdminService.create(userAdmin);
    }

    @DeleteMapping(path = "/delete/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Boolean delete(@PathVariable("id") Long id){
        return userAdminService.delete(id);
    }
}
