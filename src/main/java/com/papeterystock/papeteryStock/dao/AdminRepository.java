package com.papeterystock.papeteryStock.dao;

import com.papeterystock.papeteryStock.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    default List<Admin> findByEmail(String email) {
        return null;
    }
}
