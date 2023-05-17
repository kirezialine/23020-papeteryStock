package com.papeterystock.papeteryStock.service;

import com.papeterystock.papeteryStock.domain.Model;

public interface IProductService  {

        public Model addNewProduct(Model newProduct);
        public Model updateProduct(Model newProduct);

    Module addNewProduct(Module newProduct);

    Module updateProduct(Module newProduct);

    public void deleteProduct(Model newProduct);
        public Model findProduct(Model newProduct);
        public Iterable<Model> findAllProduct();

    Model findProductById();

    public Model findProductById(Long id);

    }


