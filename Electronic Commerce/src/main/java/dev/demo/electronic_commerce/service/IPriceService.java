package dev.demo.electronic_commerce.service;

import dev.demo.electronic_commerce.persistence.entity.PriceEntity;

import java.time.LocalDateTime;

public interface IPriceService {

    PriceEntity getByDateAndProductIdAndBrandId(
            LocalDateTime date, Long productId, Long brandId);
}
