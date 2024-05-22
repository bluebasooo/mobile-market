package ru.bluebasooo.market.mobilemarket.data.basket.entity;

import lombok.Value;
import org.springframework.data.annotation.Id;

import java.util.List;

@Value
public class BasketEntity {
    @Id
    String id;
    List<String> productId;
}
