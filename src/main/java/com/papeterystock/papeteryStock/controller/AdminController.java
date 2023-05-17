package com.papeterystock.papeteryStock.controller;

import com.papeterystock.papeteryStock.dao.AdminRepository;
import com.papeterystock.papeteryStock.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
    @Controller
    @RequestMapping("/admins")
    public class AdminController {
        private AdminRepository adminRepository;
        @Autowired
        public AdminController(AdminRepository adminRepository) {
            this.adminRepository = adminRepository;
        }

        @GetMapping("/SignUp")
        public String signUp(Admin theModel){
            Admin admin = new Admin();
            theModel.addAttribute("admin", admin);
            String s = "AdmissionSignUp.html";
            return s;
        }

        @GetMapping("/login")
        public String login(Admin theModel){
            // create Model attribute to bind form data
            Admin admin = new Admin();
            theModel.addAttribute("admin", admin);
            return "login";
        }

        @PostMapping("/save")
        public String saveAdmin(@ModelAttribute("admin") Admin theAdmin){
            // save the Admin
            adminRepository.save(theAdmin);
            return "redirect:/admins/login";
        }

        @PostMapping("/authenticate")
        public String AuthenticateAdmin(@ModelAttribute("admin") Admin theAdmin){
            // Find the Admin
            List<Admin> authAdmin = adminRepository.findByEmail(theAdmin.getEmail());
            if(!authAdmin.isEmpty()){
                return "redirect:/students/list";
            }
            return "redirect:/admin/SignUp";
        }
    }

