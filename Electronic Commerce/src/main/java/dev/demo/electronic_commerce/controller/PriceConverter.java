package dev.demo.electronic_commerce.controller;

import dev.demo.electronic_commerce.controller.dto.BrandDto;
import dev.demo.electronic_commerce.controller.dto.PriceDto;
import dev.demo.electronic_commerce.persistence.entity.BrandEntity;
import dev.demo.electronic_commerce.persistence.entity.PriceEntity;
import dev.demo.electronic_commerce.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PriceConverter {

    private final IPriceService priceService;

    @Autowired
    public PriceConverter(IPriceService priceService) {
        this.priceService = priceService;
    }

    public ResponseEntity<PriceDto> getPrice(LocalDateTime date, Long productId, Long brandId) {
        PriceEntity pricesEntity = priceService.getByDateAndProductIdAndBrandId(date, productId, brandId);
        if (pricesEntity == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(mapPriceToDto(pricesEntity), HttpStatus.OK);
    }

    private PriceDto mapPriceToDto(PriceEntity entity) {
        PriceDto dto = new PriceDto();
        dto.setProductId(entity.getProductId());
        dto.setBrandDto(mapBrandToDto(entity.getBrandEntity()));
        dto.setPriceList(entity.getPriceList().getPrice());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setFinalPrice(entity.getPrice());
        return dto;
    }

    private BrandDto mapBrandToDto(BrandEntity entity) {
        BrandDto brandDto = new BrandDto();
        brandDto.setBrandId(entity.getBrandId());
        brandDto.setBrandName(entity.getBrandName());
        return brandDto;
    }
}
