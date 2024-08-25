package com.scm.scm20.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("api/v1/page")
public class PageController {
    @GetMapping("/home")
    public ResponseEntity<String> home(Model model) throws IOException {
        ClassPathResource resource = new ClassPathResource("templates/home.html");
        String content = new String(Files.readAllBytes(resource.getFile().toPath()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        model.addAttribute("name","Substring values");
        model.addAttribute("github","Github url");
        System.out.println("Home page handler");
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
