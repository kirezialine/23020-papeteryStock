package com.papeterystock.papeteryStock.service;

import com.papeterystock.papeteryStock.dao.IProductRepository;
import com.papeterystock.papeteryStock.domain.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

    @Service
    public class ProductService implements IProductService{
        @Autowired
        private IProductRepository productRepository;
        private Model newProduct;

        @Override
        public Model addNewProduct(Model newProduct) {
            this.newProduct = newProduct;
            return null;
        }

        @Override
        public Model updateProduct(Model newProduct) {
            this.newProduct = newProduct;
            return null;
        }

        /**
         * @param newProduct
         * @return
         */
        @Override
        public Module addNewProduct(Module newProduct) {

            return newProduct;
        }

//        public List<CATEGORY> getCategory() {
//            return Arrays.asList(CATEGORY.values());
//        }

        public List<Module> getSize() {
            List<Module> list = Arrays.asList();
            return list;
        }


        @Override
        public Module updateProduct(Module newProduct) {
            return null;
        }


        @Override
        public void deleteProduct(Model newProduct) {
            productRepository.delete(newProduct);
        }


        @Override
        public Model findProduct(Model newProduct) {
            return null;
        }


        @Override
        public Iterable<Model> findAllProduct() {
            return productRepository.findAll();
        }


        @Override
        public Model findProductById() {
            return findProductById();
        }

        @Override
        public Model findProductById(Long id) {
            return (Model) productRepository.findById(id).orElse(null);
        }
    }

