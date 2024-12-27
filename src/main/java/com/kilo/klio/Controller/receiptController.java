package com.kilo.klio.Controller;

import com.kilo.klio.entity.receipt;
import com.kilo.klio.repository.receiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receipts")
public class receiptController {

    @Autowired
    private receiptRepository receiptRepository;

    // Receipt 정보 업로드
    @PostMapping
    public ResponseEntity<receipt> createReceipt(@RequestBody receipt receipt) {
        receipt savedReceipt = receiptRepository.save(receipt);
        return ResponseEntity.ok(savedReceipt);
    }

    // userId로 모든 Receipt 가져오기
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<receipt>> getReceiptsByUserId(@PathVariable Long userId) {
        List<receipt> receipts = receiptRepository.findByUserId(userId);
        return ResponseEntity.ok(receipts);
    }
}
