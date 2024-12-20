package com.kilo.klio.service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Service
public class OCRService {

    public String processImage(MultipartFile file) throws IOException, TesseractException {
        // MultipartFile -> BufferedImage 변환
        BufferedImage image = ImageIO.read(file.getInputStream());

        // Tesseract 설정
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Tesseract 데이터 경로
        tesseract.setLanguage("eng"); // 언어 설정 (예: 영어)

        // OCR 수행
        return tesseract.doOCR(image);
    }
}


// 모르겟어... ㅠㅠ