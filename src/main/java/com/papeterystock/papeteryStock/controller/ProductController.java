package com.papeterystock.papeteryStock.controller;

import com.papeterystock.papeteryStock.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeBodyPart;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private final IProductService productService;
    private MimeBodyPart FileUploadUtil;

    public ProductController(IProductService productService, MimeBodyPart fileUploadUtil) {
        this.productService = productService;
        FileUploadUtil = fileUploadUtil;
    }

    @RequestMapping("")
    public String homeProduct(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "products";
    }
    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") com.papeterystock.papeteryStock.domain.Model product, @RequestParam("picture") MultipartFile file) {

        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            product.setProfilePicture(fileName);
            productService.addNewProduct(product);
            String uploadDir = "product-photos/" + product.getId();
            FileUploadUtil.saveFile(uploadDir);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/product";
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {

        try {
            com.papeterystock.papeteryStock.domain.Model product = productService.findProductById((long) id);

            productService.deleteProduct(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        com.papeterystock.papeteryStock.domain.Model product = productService.findProductById(id);
        model.addAttribute("product", product);
        return "updateProductForm";
    }

}
