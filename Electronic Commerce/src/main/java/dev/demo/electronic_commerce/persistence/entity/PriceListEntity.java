package dev.demo.electronic_commerce.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "PRICE_LIST")
@AllArgsConstructor
@NoArgsConstructor
public class PriceListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_LIST_ID")
    private Long priceListId;

    @Column(name = "PRICE")
    private Double price;
}
