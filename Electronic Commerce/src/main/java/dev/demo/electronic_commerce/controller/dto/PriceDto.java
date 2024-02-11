package dev.demo.electronic_commerce.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PriceDto {

    private Long productId;

    private BrandDto brandDto;

    private Double priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double finalPrice;
}