package com.papeterystock.papeteryStock.dao;

import com.papeterystock.papeteryStock.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface IProductRepository extends JpaRepository<Model,Integer> {

        Optional<Object> findById(Long id);
    }

