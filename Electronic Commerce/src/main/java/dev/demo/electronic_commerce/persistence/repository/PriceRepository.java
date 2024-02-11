package dev.demo.electronic_commerce.persistence.repository;

import dev.demo.electronic_commerce.persistence.entity.PriceEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(value = "SELECT pri " +
                        "FROM PriceEntity pri " +
                            "WHERE pri.productId = :productId " +
                            "AND pri.brandEntity.brandId = :brandId " +
                            "AND (:dateTime BETWEEN pri.startDate AND pri.endDate) " +
                        "ORDER BY pri.priority DESC ")
    List<PriceEntity> findFirstByDateAndProductIdAndBrandId(
            @Param("dateTime") LocalDateTime dateTime,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId,
            Pageable pageable);
}