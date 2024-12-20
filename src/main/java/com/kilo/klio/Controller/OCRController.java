package com.kilo.klio.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.kilo.klio.service.OCRService;


@RestController
@RequestMapping("/api/ocr")
public class OCRController {

    private final OCRService ocrService;

    public OCRController(OCRService ocrService) {
        this.ocrService = ocrService;
    }

     @PostMapping("/process")
    public ResponseEntity<String> processImage(@RequestParam("file") MultipartFile file) {
        try {
            String text = ocrService.processImage(file);
            System.out.println(text);
            return ResponseEntity.ok(text);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing the image: " + e.getMessage());
        }
    }
}

