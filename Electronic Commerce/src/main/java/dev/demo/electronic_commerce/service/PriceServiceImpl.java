package dev.demo.electronic_commerce.service;

import dev.demo.electronic_commerce.persistence.entity.PriceEntity;
import dev.demo.electronic_commerce.persistence.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService{

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceEntity getByDateAndProductIdAndBrandId(
            LocalDateTime date, Long productId, Long brandId) {
        Pageable pageable = PageRequest.of(0, 1);
        List<PriceEntity> priceEntityList = priceRepository.findFirstByDateAndProductIdAndBrandId(
                date, productId, brandId, pageable);
        if (priceEntityList.isEmpty()) {
            return null;
        }
        return priceEntityList.get(0);
    }
}
