package dev.demo.electronic_commerce.controller;

import dev.demo.electronic_commerce.controller.dto.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceConverter converter;

    @Autowired
    public PriceController(PriceConverter converter) {
        this.converter = converter;
    }

    @GetMapping
    public ResponseEntity<PriceDto> getPrice(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam("productId") Long productId,
            @RequestParam("brandId") Long brandId) {
        return converter.getPrice(date, productId, brandId);
    }
}
