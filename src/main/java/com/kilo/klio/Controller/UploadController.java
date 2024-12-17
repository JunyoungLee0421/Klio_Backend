package com.kilo.klio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadController {
    
    @GetMapping("/upload")
    public String upload() {
        return "This is get mapping for upload!";
    }
}
