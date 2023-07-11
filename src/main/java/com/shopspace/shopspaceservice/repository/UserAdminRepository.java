package com.shopspace.shopspaceservice.repository;

import com.shopspace.shopspaceservice.model.UserAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAdminRepository extends JpaRepository<UserAdmin, Long> {
    @Query("SELECT ua FROM UserAdmin ua WHERE (:search IS NULL OR (ua.fullName LIKE CONCAT('%', :search, '%') OR ua.code LIKE CONCAT('%', :search, '%'))) ORDER BY ua.id DESC")
    Page<UserAdmin> getAllUsersAdmins(@Param("search") String Search, Pageable pageable);
}
